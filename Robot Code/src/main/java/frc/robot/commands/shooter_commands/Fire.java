// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooter_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.mechanical_subsystems.Shooter;
import frc.robot.subsystems.sensors.LimeLight;
import frc.robot.subsystems.sensors.NavXGyro;

public class Fire extends CommandBase {
  /** Creates a new Fire. */
  Shooter shooter;
  LimeLight limelight;
  public Fire(Shooter s, LimeLight ll) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooter = s;
    limelight = ll;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.setFlywheelPercentOutput(Constants.shooterPercent);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Constants.limelight_enabled)
      shooter.setTuretAngle(NavXGyro.getAngle() - limelight.getHorizontalOffset());
    else
      shooter.setTuretAngle(0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.setFlywheelPercentOutput(0);
 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
