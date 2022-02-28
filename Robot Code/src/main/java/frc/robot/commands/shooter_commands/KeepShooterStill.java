// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooter_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.mechanical_subsystems.Shooter;
import frc.robot.subsystems.sensors.NavXGyro;

public class KeepShooterStill extends CommandBase {
  /** Creates a new KeepShooterStill. */
  Shooter shooter;
  public KeepShooterStill(Shooter s) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooter = s;
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.setTuretAngle(360-NavXGyro.getAngle());
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
