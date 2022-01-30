// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.sensors;

import java.util.ArrayList;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class JetsonVision extends SubsystemBase {
  /** Creates a new JetsonVision. */
  
  ArrayList<NetworkTableEntry> ball_entries = new ArrayList<NetworkTableEntry>();
  double[] zereos = {0,0,0,0,0,0};
  
  public JetsonVision() {
    //Get the default instance of NetworkTables that was created automatically
      //when your program starts
      NetworkTableInstance inst = NetworkTableInstance.getDefault();

      //Get the table within that instance that contains the data. There can
      //be as many tables as you like and exist to make it easier to organize
      //your data. In this case, it's a table called datatable.
      NetworkTable table = inst.getTable("balldata");

      //Get the entries within that table that correspond to the X and Y values
      //for some operation in your program.
      
      for(int i = 0; i<22; i++){
        ball_entries.add(table.getEntry("ball_"+(i+1)));
        ball_entries.get(0).setDoubleArray(zereos);
      }
  }

  public static double[] undistort(double[] imagePoint, double[] k, double[] center, double[] focalLength){
    imagePoint = imagePoint.clone();

    imagePoint[0] = (imagePoint[0]-center[0])*1/focalLength[0];
    imagePoint[1] = (imagePoint[1]-center[1])*1/focalLength[1];

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
  

x = x/0.001138 + center[0];
y = y/0.001138 + center[1];
double[] result = {x,y};
return result;

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
