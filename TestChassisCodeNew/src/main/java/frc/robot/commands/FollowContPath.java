// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.ArrayList;

import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import frc.robot.subsystems.NavXGyro;
;

public class FollowContPath extends CommandBase {
  /** Creates a new FollowContPath. */
  double initialTime;
  boolean firstTime = true;
  double time = 0;
  Trajectory trajectory;
  RamseteController controller;
  public FollowContPath(int[] start, int[] end, int[][] points, double maxV, double maxA) {
    // Use addRequirements() here to declare subsystem dependencies.
    TrajectoryConfig config = new TrajectoryConfig(maxV, maxA);
    Pose2d startPos = new Pose2d(start[0], start[1], Rotation2d.fromDegrees(0));
    Pose2d endPos = new Pose2d(end[0], end[1], Rotation2d.fromDegrees(0));
    ArrayList<Translation2d> interiorWaypoints = new ArrayList<Translation2d>();
    for(int[] point: points)
      interiorWaypoints.add(new Translation2d(point[0], point[1]));

    trajectory = TrajectoryGenerator.generateTrajectory(
      startPos, 
      interiorWaypoints, 
      endPos, 
      config);
      

      controller = new RamseteController(2.0, 0.7);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!firstTime){
      time = System.currentTimeMillis()/1000F;
      Trajectory.State goal = trajectory.sample(time);
      Pose2d currentRobotPose = new Pose2d(NavXGyro.ahrs.getDisplacementX(), NavXGyro.ahrs.getDisplacementY(), Rotation2d.fromDegrees(NavXGyro.ahrs.getAngle()));
      ChassisSpeeds adjustedSpeeds = controller.calculate(currentRobotPose, goal);
      DifferentialDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(adjustedSpeeds);
    } else {
      initialTime = System.currentTimeMillis();
      
      firstTime = false;
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
