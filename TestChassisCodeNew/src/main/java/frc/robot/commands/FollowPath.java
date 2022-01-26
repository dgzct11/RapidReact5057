// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.DriveTrain;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FollowPath extends SequentialCommandGroup {
  /** Creates a new DriveToPoint. */
  
  public FollowPath(int[][] points, DriveTrain dt) {
    // Add your commands in thde addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
   for(int p = 0; p<points.length; p++){
       addCommands(new DriveToPoint(points[p][0], points[p][1], dt));
   }
    
   
    
  }
}
