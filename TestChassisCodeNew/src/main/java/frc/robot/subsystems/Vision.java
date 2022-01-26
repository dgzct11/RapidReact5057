// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.ArrayList;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Vision extends SubsystemBase {
  /** Creates a new Vision. */
  ArrayList<NetworkTableEntry> ball_entries = new ArrayList<NetworkTableEntry>();
  double[] zereos = {0,0,0,0,0,0};
  
  public Vision() {
    //Get the default instance of NetworkTables that was created automatically
      //when your program starts
      NetworkTableInstance inst = NetworkTableInstance.getDefault();

      //Get the table within that instance that contains the data. There can
      //be as many tables as you like and exist to make it easier to organize
      //your data. In this case, it's a table called datatable.
      NetworkTable table = inst.getTable("ball_data");

      //Get the entries within that table that correspond to the X and Y values
      //for some operation in your program.
      
      for(int i = 0; i<22; i++){
        ball_entries.add(table.getEntry("ball_"+(i+1)));
        ball_entries.get(0).setDoubleArray(zereos);
      }
  }

  public double getHorizontalAngleDiff(){
    double[] vector = ball_entries.get(0).getDoubleArray(zereos);

    return vector[0] + vector[2]/2 - 500;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
