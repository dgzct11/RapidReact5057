// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.mechanical_subsystems.Intake;

public class IntakeSpin extends CommandBase {
  public boolean spinning;
  public Intake intake;
  /** Creates a new IntakeSpin. */
  public IntakeSpin(boolean spin, Intake i) {
    // Use addRequirements() here to declare subsystem dependencies.
    spinning = spin;
    intake = i;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (spinning == false) {
      intake.spin();
    }
    else {
      intake.stopSpin();
    }
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
