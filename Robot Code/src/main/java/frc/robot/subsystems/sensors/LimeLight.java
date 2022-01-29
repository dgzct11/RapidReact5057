// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.sensors;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj2.command.SubsystemBase;




public class LimeLight extends SubsystemBase {
  /** Creates a new LimeLight. */
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  //horizontal angle offset to target
  NetworkTableEntry tx = table.getEntry("tx");
  //vertical angle offset to target
  NetworkTableEntry ty = table.getEntry("ty");

  //how much of the cameras area is taken up by the object
  //used for distance estimation. 
  NetworkTableEntry ta = table.getEntry("ta");

  //boolean value wether its in viuew
  NetworkTableEntry tv = table.getEntry("tv");
  
  

  public LimeLight() {
  
  }

  public double getDistance(){}

  public boolean isInView(){
    return tv.getBoolean(false);
  }
  
  @Override
  public void periodic() {
   System.out.println(ta.getDouble(0)); //prints area of object
  }
}
//hi