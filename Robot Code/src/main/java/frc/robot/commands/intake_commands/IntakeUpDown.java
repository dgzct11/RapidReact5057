// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.mechanical_subsystems.Intake;

public class IntakeUpDown extends CommandBase {
  //true for up, false for down
  public boolean upDown;
  public Intake intake;
  /** Creates a new IntakeDown. */
  public IntakeUpDown(boolean ud, Intake i) {
    // Use addRequirements() here to declare subsystem dependencies.
    upDown = ud;
    intake = i;
  }

  public IntakeUpDown(Intake i) {
    intake = i;
    upDown = !upDown;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(upDown)
    {
      intake.up();
    }
    else
    {
      intake.down();
    }
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
