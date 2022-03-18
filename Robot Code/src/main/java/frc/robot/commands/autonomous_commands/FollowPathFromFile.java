// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous_commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

import frc.robot.functional.files.SCSetPoint;
import frc.robot.functional.trajectory.KinematicSegment;
import frc.robot.functional.trajectory.Path;
import frc.robot.functional.trajectory.Position;
import frc.robot.subsystems.mechanical_subsystems.DriveTrain;
import frc.robot.subsystems.sensors.NavXGyro;
import frc.robot.subsystems.sensors.Odometry;

public class FollowPathFromFile extends CommandBase {
  /** Creates a new FollowPathFromFile. */
  Path path;
  Odometry odometry;
  DriveTrain driveTrain;
  double initialTime;
  double timeUnit = 0.1;
  
  public FollowPathFromFile(DriveTrain dt, Odometry od, String prefix) {
    // Use addRequirements() here to declare subsystem dependencies.
    path = new Path(prefix);
    odometry = od;
    driveTrain = dt;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Constants.in_auto = true;
    odometry.reset();
    double[] start =  path.segments.get(0).startPoint;
    double[] startPoint = {6.5,1.5};
    odometry.currentPosition = new Position((double[])(path.segments.get(0).startPoint.clone()), 0);
    NavXGyro.ahrs.reset();
    initialTime = System.currentTimeMillis()/1000.;
    Constants.velocityMax = 1;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double[] currentPosition = odometry.currentPosition.point;
    double time = System.currentTimeMillis()/1000. - initialTime;
    Position newPosP = path.getPositionFromTime(time + timeUnit);
    double[] newPos = newPosP.point;
    double angleToPoint = RobotContainer.angleToPoint(currentPosition, newPos);
    double speed = RobotContainer.distance(currentPosition, newPos)/timeUnit; 
    //SCSetPoint subsytemSetting = path.getSetPoint(time + timeUnit);
   
   
    SmartDashboard.putNumber("speed", speed);
    if(speed>2) speed = 2;
    SmartDashboard.putNumber("time", time + timeUnit);
    SmartDashboard.putNumber("new Pos X", newPos[0]);
    SmartDashboard.putNumber("new Pos Y", newPos[1]);

    KinematicSegment segment = path.kinematics.segments.get(path.kinematics.currentIndex);
    
    
    driveTrain.fieldOrientedDrive(angleToPoint, speed, 0);
    /*
    if(subsytemSetting == null){
      
    }
    else if(subsytemSetting.subsystemIdentifier.equals("navx")){
        driveTrain.alignDrive(angleToPoint, speed, subsytemSetting.inputs.get(0));
    }
    
    else{
         driveTrain.fieldOrientedDrive(angleToPoint, speed, 0);
    }

    */
    


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Constants.in_auto = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return  (System.currentTimeMillis()/1000 - initialTime )>=path.kinematics.totalTime;
  }
}