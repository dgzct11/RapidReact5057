// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.sensors;

import java.util.ArrayList;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.functional.Position;

public class JetsonVision extends SubsystemBase {
  /** Creates a new JetsonVision. */
  
  ArrayList<NetworkTableEntry> ball_entries = new ArrayList<NetworkTableEntry>();
  //{x, y, width, height, confidence, class, camera}
  double[] zereos = {0,0,0,0,0,0};
  double ball_confidence_threshold = 0.7;
  Odometry odometry;
  public JetsonVision(Odometry od) {
    //Get the default instance of NetworkTables that was created automatically
      //when your program starts
      NetworkTableInstance inst = NetworkTableInstance.getDefault();

      //Get the table within that instance that contains the data. There can
      //be as many tables as you like and exist to make it easier to organize
      //your data. In this case, it's a table called datatable.
      NetworkTable table = inst.getTable("balldata");

      //Get the entries within that table that correspond to the X and Y values
      //for some operation in your program.
      odometry = od;
      for(int i = 0; i<22; i++){
        ball_entries.add(table.getEntry("ball_"+(i+1)));
        ball_entries.get(0).setDoubleArray(zereos);
      }
  }

  public ArrayList<Position> getFieldPosition(ArrayList<double[]> anglesDistancesColors){
    ArrayList<Position> fieldPositions = new ArrayList<Position>();
    for(double[] angleDistance: anglesDistancesColors){
      double fieldAngle = NavXGyro.getAngle() + angleDistance[0];
      Position fieldPosition = new Position(odometry.currentPosition.x - Math.sin(Math.toDegrees(fieldAngle))*angleDistance[1], odometry.currentPosition.y + Math.cos(Math.toDegrees(fieldAngle))*angleDistance[1], 0);
      fieldPositions.add(fieldPosition);
    }
    return fieldPositions;

  }
  public ArrayList<double[]> getBallsRelativeHeadingDistanceColor(){
    ArrayList<double[]> angleDistances = new ArrayList<double[]>();
    for(NetworkTableEntry ball_entry: ball_entries){
      double[] ball = ball_entry.getDoubleArray(zereos);
      
      //check if ball confidence is ok
      if(ball[4] >= ball_confidence_threshold ){
        //chooses between cameras.
        double[] k;
        double[] center;
        double[] focalLength;
        double camera_angle_offset;
        if(ball[5] == 0){
          k = Constants.camera_0_radial_constants;
          center = Constants.camera_0_distortion_center;

          focalLength = Constants.camera_0_focal_lengths;
          camera_angle_offset = Constants.camera_0_angle_offset;
        }
        else{
          k = Constants.camera_1_radial_constants;
          center = Constants.camera_1_distortion_center;
          focalLength = Constants.camera_1_focal_lengths;
          camera_angle_offset = Constants.camera_1_angle_offset;
        }
        double[] imagePoint = {ball[0], ball[1]};
        double[] undistortedPoint = undistortPoint(imagePoint, k, center, focalLength);
        double[] angleDiffs = getAngleDifferencesToBall(undistortedPoint, center, focalLength);
        double distance = getDistanceToBall(angleDiffs);
        double[] angleDistance = {angleDiffs[0]+camera_angle_offset, distance, ball[5]};
        angleDistances.add(angleDistance);
      }

    }
    return angleDistances;
  }

  public  double[] undistortPoint(double[] imagePoint, double[] k, double[] center, double[] focalLength){
    imagePoint = imagePoint.clone();

    imagePoint[0] = (imagePoint[0]-center[0])/focalLength[0];
    imagePoint[1] = (imagePoint[1]-center[1])/focalLength[1];

    System.out.println(imagePoint[0] + " " + imagePoint[1]);
    //calc some values
    double coefficient = 1+ Math.pow(imagePoint[1]/imagePoint[0], 2);
    //solve for x value
    double x = 0.1;
    if(imagePoint[0]<0) x = -1.1;
    double y;
    for(int i = 0; i<150; i++){
      y = x + k[0]*Math.pow(coefficient,2)*Math.pow(x, 5) + k[1]*Math.pow(coefficient,4)*Math.pow(x, 9)-imagePoint[0];
      double derivative = 1 + 5*k[0]*Math.pow(coefficient,2)*Math.pow(x, 4) + 9*k[1]*Math.pow(coefficient,4)*Math.pow(x, 8);
      x = -y/derivative + x;
    }

    //solve for y 
    y = imagePoint[1]/imagePoint[0]*x;
  

    x = x*focalLength[0] + center[0];
    y = y*focalLength[1] + center[1];
    double[] result = {x,y};
    return result;

  }
  public double[] getAngleDifferencesToBall(double[] undistorted_imagePoint, double[] image_center, double[] focal_lengths){
    //left is positive, right is negative
    double xDiff = image_center[0] - undistorted_imagePoint[0];
    double yDiff = image_center[1] - undistorted_imagePoint[1];

    double[] angleDiff = {
      Math.toDegrees(Math.atan(xDiff/focal_lengths[0])),
      Math.toDegrees(Math.atan(yDiff/focal_lengths[1]))
    };
    return angleDiff;

  }

  public double getDistanceToBall(double[] angle_diffs){
    double distance_to_object_line = Math.tan(Math.toRadians(Constants.camera_angle +angle_diffs[1]))*(Constants.camera_height-Constants.cargo_diameter);
    return distance_to_object_line/Math.cos(Math.toDegrees(angle_diffs[0]));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
