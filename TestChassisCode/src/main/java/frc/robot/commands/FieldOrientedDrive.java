// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.NavXGyro;

public class FieldOrientedDrive extends CommandBase {
  private final DriveTrain driveTrain;
  private final NavXGyro navx;
  double kp = 1;
  double ki = 0;
  double kd = 0;
  double kf = 0;
  double time = 0;
  double previous_error = 0;
  double error = 0;
  /** Creates a new TankDrive. */
  public FieldOrientedDrive(DriveTrain dt, NavXGyro n) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
    navx = n;
    addRequirements(driveTrain);
    addRequirements(navx);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rightX = RobotContainer.xbox_controller.getRawAxis(Constants.right_x_axis);
    double rightY = RobotContainer.xbox_controller.getRawAxis(Constants.right_y_axis);
    
    double angle = Constants.stickTo360(rightX, rightY);
    SmartDashboard.putNumber("Field Oriented Angle", angle);
    SmartDashboard.putNumber("Navx Angle", Constants.navxTo360( NavXGyro.ahrs.getYaw()));
    double speed = Math.sqrt(Math.pow(rightX, 2)+Math.pow(rightY, 2));
   /*
    if(NavXGyro.ahrs.getYaw()<angle-Constants.angle_error){
      //turn right
      driveTrain.spin(speed);
      
    }
    else if(NavXGyro.ahrs.getYaw()>angle+Constants.angle_error){
      //turn left
      driveTrain.spin(-speed);
    }
    else{
      //go straight
      driveTrain.setLeftMotor(speed);
      driveTrain.setRightMotor(speed);
    }
*/    error = Constants.angleDistance(angle);
      double angle_corrector = Math.max(kp*error + ki*error*time + kd*(error-previous_error)/time, 1);
      speed*=Constants.max_motor_percent;
      if(Constants.shouldTurnLeft(NavXGyro.ahrs.getYaw(), angle)){
          //turn left
          driveTrain.setLeftMotor(speed/angle_corrector);
          driveTrain.setRightMotor(speed);
      }
      else{
          //turn right
          driveTrain.setLeftMotor(speed);
          driveTrain.setRightMotor(speed/angle_corrector);
      }
      previous_error = error;

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
