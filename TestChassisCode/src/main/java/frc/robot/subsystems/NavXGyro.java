// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NavXGyro extends SubsystemBase {
  public static AHRS ahrs;
  /** Creates a new NavXGyro. */
  public NavXGyro() {
    ahrs = new AHRS(Constants.mxp_port);
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
