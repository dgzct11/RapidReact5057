// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake_commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.mechanical_subsystems.Intake;

public class IntakeUpDown extends CommandBase {
  //true for up, false for down
  public boolean isUp;
  public Intake intake;
  /** Creates a new IntakeDown. */
  public IntakeUpDown(boolean ud, Intake i) {
    // Use addRequirements() here to declare subsystem dependencies.
    isUp = ud;
    intake = i;
  }

  public IntakeUpDown(Intake i) {
    intake = i;
    isUp = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (isUp) {
      intake.down();
      isUp = false;
    }
    else {
      intake.up();
      isUp = true;
    }
    SmartDashboard.putBoolean("is up", isUp);
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
    return false;
  }
}
