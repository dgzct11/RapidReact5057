// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.driving_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.mechanical_subsystems.DriveTrain;
import frc.robot.subsystems.sensors.XboxRemote;

public class SwerveDrive extends CommandBase {
  /** Creates a new SwerveDrive. */
  DriveTrain driveTrain;
  XboxRemote xboxRemote;
  public SwerveDrive(DriveTrain dt, XboxRemote xr) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
    xboxRemote = xr;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Constants.in_auto) return;

    double strafeAngle = xboxRemote.getLeftAngle();
    double speed = xboxRemote.getLeftMagnitude();
    double rotateSpeed = xboxRemote.getRightX();
    
    if(Constants.drive_mode.equals(Constants.field_oriented))
      driveTrain.fieldOrientedDrive(strafeAngle, speed, rotateSpeed);
    else
      driveTrain.rotateDriveVelocity(strafeAngle, speed, rotateSpeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
