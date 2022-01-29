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
  double[] zereos = {0,0,0,0,0,0, 0};
  // vector = [x,y,width, height, confidence, red or blue ball, camera_number]
  NetworkTable table = NetworkTableInstance.getDefault().getTable("balldata");
  
  public JetsonVision() { 
      for(int i = 0; i<22; i++){
        ball_entries.add(table.getEntry("ball_"+(i+1)));
        ball_entries.get(i).setDoubleArray(zereos);
      }
  }

  public double[] getAngleDifference(double[] ball){
    return zereos;
  }

  public double getDistance(double[] ball_angle_diff){
    return 0;
  }
}
