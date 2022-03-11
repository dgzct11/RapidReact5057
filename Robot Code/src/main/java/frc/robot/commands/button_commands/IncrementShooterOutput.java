// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.button_commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IncrementShooterOutput extends InstantCommand {
  double increment;
  public IncrementShooterOutput(double i) {
    // Use addRequirements() here to declare subsystem dependencies.
    increment = i;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(increment <= 0 && increment >= -1)
      Constants.shooterPercent += increment;
  }
}
