// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.button_commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.mechanical_subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SetShooterAngle extends InstantCommand {
  double angle;
  Shooter shooter;
  public SetShooterAngle(double a, Shooter s) {
    // Use addRequirements() here to declare subsystem dependencies.
    angle = a;
    shooter = s;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.setTuretAngle(angle);
  }
}
