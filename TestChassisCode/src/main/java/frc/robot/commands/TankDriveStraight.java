// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.NavXGyro;

public class TankDriveStraight extends CommandBase {
  private final DriveTrain driveTrain;
  double kp = 1;
  double ki = 0;
  double kd = 0;
  double kf = 0;
  double time = 0;
  double previous_error = 0;
  double error = 0;
  private double angle;
  /** Creates a new TankDrive. */
  public TankDriveStraight(DriveTrain dt) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
   
    addRequirements(driveTrain);
   
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      angle = NavXGyro.ahrs.getAngle();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftY = RobotContainer.xbox_controller.getRawAxis(Constants.left_y_axis);
    double rightY = RobotContainer.xbox_controller.getRawAxis(Constants.right_y_axis);
    
    if(Math.abs(leftY)>Constants.min_joystick_correction_threshold && Math.abs(rightY)>Constants.min_joystick_correction_threshold){
      double speed = Constants.max_motor_percent*(leftY > 0 ? 1:-1);
      
      if(!Constants.angle_fixed){
        angle=NavXGyro.ahrs.getYaw(); 
        Constants.angle_fixed = true;
      }
      error = Constants.angleDistance(angle);
      Constants.angle_correction_multiplier = kp*error + ki*error*time + kd*(error-previous_error)/time;
      if(leftY < 0) Constants.angle_correction_multiplier = 1/Constants.angle_correction_multiplier;
      if(Constants.shouldTurnLeft(NavXGyro.ahrs.getYaw(), angle)){
            //turn left
            driveTrain.setLeftMotor(speed/Constants.angle_correction_multiplier);
            driveTrain.setRightMotor(speed*Constants.angle_correction_multiplier);
        }
        else{
            //turn right
            driveTrain.setLeftMotor(speed*Constants.angle_correction_multiplier);
            driveTrain.setRightMotor(speed/Constants.angle_correction_multiplier);
        }
        if(leftY < 0) Constants.angle_correction_multiplier = 1/Constants.angle_correction_multiplier;
        previous_error = error;
    }
    else{
        driveTrain.setRightMotor(rightY);
        driveTrain.setLeftMotor(leftY);
        Constants.angle_fixed = false;
    }
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
