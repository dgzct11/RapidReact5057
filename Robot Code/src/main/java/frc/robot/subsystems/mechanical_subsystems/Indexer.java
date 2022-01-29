// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.mechanical_subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Indexer extends SubsystemBase {
  /** Creates a new Indexer. */
  TalonSRX frontleftMotor = new TalonSRX(Constants.front_left_motor);
  TalonSRX frontrightMotor = new TalonSRX(Constants.front_right_motor);
  //Motor775 = 0000;
  

  public Indexer() {}
  //TODO
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
