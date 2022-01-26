// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.NavXGyro;

public class SwitchDriveMode extends CommandBase {
  private final DriveTrain driveTrain;
  private final NavXGyro navx;
  /** Creates a new TankDrive. */
  public SwitchDriveMode(DriveTrain dt, NavXGyro n) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
    navx = n;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(Constants.driveMode == 0){
      driveTrain.setDefaultCommand(new TankDriveStraight(driveTrain));
      Constants.driveMode = 1;


    }
    else if (Constants.driveMode == 1){
      
      driveTrain.setDefaultCommand(new FieldOrientedDrive(driveTrain, navx));
      Constants.driveMode = 2;
    }
    else if (Constants.driveMode ==2){
      driveTrain.setDefaultCommand(new TankDrive(driveTrain));
      Constants.driveMode = 0;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
