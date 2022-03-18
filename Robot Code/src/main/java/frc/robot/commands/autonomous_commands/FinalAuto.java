// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous_commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.mechanical_subsystems.DriveTrain;
import frc.robot.subsystems.mechanical_subsystems.Indexer;
import frc.robot.subsystems.mechanical_subsystems.Intake;
import frc.robot.subsystems.mechanical_subsystems.Shooter;
import frc.robot.subsystems.sensors.LimeLight;
import frc.robot.subsystems.sensors.Odometry;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FinalAuto extends SequentialCommandGroup {
  /** Creates a new FinalAuto. */
  public FinalAuto(DriveTrain dt, Odometry od, Intake in, Indexer id, Shooter s, LimeLight ll) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new InitiateForAuto(od),
      new FollowPathFromFile(dt, od, "one"),
      new IntakeBall(dt, id, in),
      new Shoot(dt, od, s, id, ll),
      new FollowPathFromFile(dt, od, "two"),
      new IntakeBall(dt, id, in),
      new Shoot(dt, od, s, id, ll),
      new FollowPathFromFile(dt, od, "three"),
      new IntakeBall(dt, id, in),
      new FollowPathFromFile(dt, od, "four"),
      new Shoot(dt, od, s, id, ll)
    );
  }
}
