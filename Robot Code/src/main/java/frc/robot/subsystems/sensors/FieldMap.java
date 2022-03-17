// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.sensors;

import java.util.ArrayList;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.functional.Ball;
import frc.robot.functional.BoundingBox;
import frc.robot.functional.trajectory.Line;
import frc.robot.functional.trajectory.Position;

public class FieldMap extends SubsystemBase {
  /** Creates a new FieldMap. */
  ArrayList<Ball> balls = new ArrayList<Ball>();
  ArrayList<BoundingBox> robots = new ArrayList<BoundingBox>();

  ArrayList<BoundingBox> fieldElements = new ArrayList<BoundingBox>();
  Odometry odometry;
  JetsonVision jetson;
  double xBound = 4.121;
  double yBound = 8.230;
  double[] zero = {0,0};
  Line tapeLine = new Line(0, zero);

  public FieldMap(Odometry od) {
    constructField();
    odometry = od;
  }

  public void constructField(){
    //hub box
    
    BoundingBox hub = new BoundingBox(new Position(-0.625, 1.404), new Position(1.404,0.625), new Position(0.625, -1.404), new Position(-1.404,-0.625));
  
    //terminal 1
   
    //terminal 2
    fieldElements.add(hub);
  }
 
  public void updateField(){
    //ArrayList<Position> currentBalls = jetson.getBallPositions();
    
  }


public void getBestCargo(){

}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
