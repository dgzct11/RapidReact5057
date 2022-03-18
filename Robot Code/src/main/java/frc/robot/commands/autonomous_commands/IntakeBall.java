// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.mechanical_subsystems.DriveTrain;
import frc.robot.subsystems.mechanical_subsystems.Indexer;
import frc.robot.subsystems.mechanical_subsystems.Intake;

public class IntakeBall extends CommandBase {
  /** Creates a new IntakeBall. */
  DriveTrain drivetrain;
  Indexer indexer;
  Intake intake;
  long initialTime;
  public IntakeBall(DriveTrain dt, Indexer id, Intake in) {
    // Use addRequirements() here to declare subsystem dependencies.
    drivetrain = dt;
    indexer = id;
    intake = in;
    initialTime = System.currentTimeMillis();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake.spin();
    indexer.setPercentOutputFront(Constants.front_indexer_speed);
    drivetrain.rotateDriveVelocity(0, 0.4826, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.rotateDriveVelocity(0, 0.4826, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.stop();
    indexer.setPercentOutput(0.0);
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() - initialTime > 1000 || Constants.in_auto;
  }
}
