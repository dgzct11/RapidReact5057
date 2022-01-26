// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Vision;

public class AlignBall extends CommandBase {
  /** Creates a new AlignBall. */
  Vision vision = new Vision();
  private final DriveTrain driveTrain;
  public AlignBall(DriveTrain dt) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double error;
    if(Math.abs(vision.getHorizontalAngleDiff()) < 0.01)
      error = vision.getHorizontalAngleDiff()*0.001;
    else error = 0.01 * ( vision.getHorizontalAngleDiff() < 0 ? 1:-1);
    driveTrain.spin(error);
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
