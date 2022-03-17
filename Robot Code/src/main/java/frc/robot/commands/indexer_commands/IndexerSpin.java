// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.indexer_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.mechanical_subsystems.Indexer;

public class IndexerSpin extends CommandBase {
  /** Creates a new IndexerSpin. */
  Indexer indexer;
  public IndexerSpin(Indexer ind) {
    // Use addRequirements() here to declare subsystem dependencies.
    indexer = ind;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    indexer.setPercentOutputFront(0.5);
    indexer.setPercentOutputBack(0.5);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    indexer.setPercentOutputFront(0);
    indexer.setPercentOutputBack(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
