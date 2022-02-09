// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.indexer_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.mechanical_subsystems.Indexer;

public class BackIndexer extends CommandBase {
  /** Creates a new back_indexer. */
  Indexer indexer;
  boolean bool; // Change Name
  public BackIndexer(Indexer in, boolean b) {
    // Use addRequirements() here to declare subsystem dependencies.
    indexer = in;
    bool = b;


  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (bool == true){
      indexer.setPercentOutput(Constants.back_indexer_speed);
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
