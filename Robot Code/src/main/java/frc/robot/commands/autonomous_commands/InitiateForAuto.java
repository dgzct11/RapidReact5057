// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous_commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.functional.trajectory.Position;
import frc.robot.subsystems.mechanical_subsystems.DriveTrain;
import frc.robot.subsystems.sensors.NavXGyro;
import frc.robot.subsystems.sensors.Odometry;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class InitiateForAuto extends InstantCommand {

  Odometry odometry;

  public InitiateForAuto(Odometry od) {
    // Use addRequirements() here to declare subsystem dependencies.
    odometry = od;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    odometry.currentPosition = new Position(2, 2, 0);
    NavXGyro.reset();
    NavXGyro.ahrs.setAngleAdjustment(225);

  }
}
