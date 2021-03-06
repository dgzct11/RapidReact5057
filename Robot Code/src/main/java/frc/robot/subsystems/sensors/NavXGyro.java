// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.sensors;   

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.Constants;
public class NavXGyro extends SubsystemBase {
  /** Creates a new NavXGyro. */
  //TODO
  public static AHRS ahrs = new AHRS(Constants.mxp_port);
  public NavXGyro() {
    
  }

  public static double getAngle(){
    return RobotContainer.navxTo360(ahrs.getAngle())%360;
  }
  public static void reset(){
    ahrs.reset();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Navx Angle", NavXGyro.getAngle());
   
  }
}