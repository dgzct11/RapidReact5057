// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.button_commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SwitchDriveMode extends InstantCommand {
  public SwitchDriveMode() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(Constants.drive_mode.equals(Constants.field_oriented))
      Constants.drive_mode = Constants.robot_oriented;
    else
      Constants.drive_mode = Constants.field_oriented;
  }
}
