// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class ChangeMaxSpeed extends CommandBase {
  /** Creates a new ChangeMaxSpeed. */
  double change;
  public ChangeMaxSpeed(double c) {
    // Use addRequirements() here to declare subsystem dependencies.
    change = c;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Constants.max_motor_percent += change;
    if(Constants.max_motor_percent<0) Constants.max_motor_percent = 0;
    else if(Constants.max_motor_percent > 1) Constants.max_motor_percent = 1;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
