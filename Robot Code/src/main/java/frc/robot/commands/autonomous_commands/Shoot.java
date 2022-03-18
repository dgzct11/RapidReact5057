// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.mechanical_subsystems.DriveTrain;
import frc.robot.subsystems.mechanical_subsystems.Indexer;
import frc.robot.subsystems.mechanical_subsystems.Shooter;
import frc.robot.subsystems.sensors.LimeLight;
import frc.robot.subsystems.sensors.NavXGyro;
import frc.robot.subsystems.sensors.Odometry;

public class Shoot extends CommandBase {
  /** Creates a new Shoot. */
  DriveTrain drivetrain;
  Odometry odometry;
  Shooter shooter;
  Indexer indexer;
  double angle;
  LimeLight limelight;
  long initialTime;

  public Shoot(DriveTrain dt, Odometry o, Shooter s, Indexer id, LimeLight ll) {
    // Use addRequirements() here to declare subsystem dependencies.
    drivetrain = dt;
    odometry = o;
    shooter = s;
    indexer = id;
    limelight = ll;
    initialTime = System.currentTimeMillis();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.setFlywheelPercentOutput(1);
    angle = RobotContainer.vectorToAngle(odometry.currentPosition.x, -+odometry.currentPosition.y);
    shooter.setTuretAngle(0);
    //drivetrain.alignDrive(0, 0, angle);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //if (RobotContainer.angleDistance2(NavXGyro.getAngle(), angle) > 5) {
      if(System.currentTimeMillis() - initialTime > 3000){
      
        indexer.setPercentOutputBack(0.75);
        indexer.setPercentOutputFront(0.5);
      }
    //}
    //drivetrain.alignDrive(0, 0, angle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    indexer.setPercentOutputBack(0);
    indexer.setPercentOutputBack(0);
    shooter.setFlywheelPercentOutput(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() - initialTime > 6000 || !Constants.in_auto;

  }
}
