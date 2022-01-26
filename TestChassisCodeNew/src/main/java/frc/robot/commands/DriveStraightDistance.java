// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.NavXGyro;

public class DriveStraightDistance extends CommandBase {
  /** Creates a new DriveStraightDistance. */
  double distance;
  double angle;
  DriveTrain driveTrain;
  double kp = 1;
  double ki = 0;
  double kd = 0;
  double kf = 0;
  double time = 0;
  double previous_error = 0;
  double error = 0;
  public DriveStraightDistance(double d, double a, DriveTrain dt) {
    // Use addRequirements() here to declare subsystem dependencies.
    distance = d;
    driveTrain = dt;
    angle = a;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    NavXGyro.ahrs.resetDisplacement();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    
      double speed = Constants.max_motor_percent;
      
      error = Constants.angleDistance(angle);
      Constants.angle_correction_multiplier = kp*error + ki*error*time + kd*(error-previous_error)/time;
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
        previous_error = error;
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    boolean value = NavXGyro.ahrs.getDisplacementX() <= distance + Constants.distance_error && NavXGyro.ahrs.getDisplacementX()>= distance - Constants.distance_error;
    this.end(value);
    return value;
  }
}
