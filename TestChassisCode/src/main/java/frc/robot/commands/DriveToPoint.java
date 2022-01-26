// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveToPoint extends SequentialCommandGroup {
  /** Creates a new DriveToPoint. */
  double x;
  double y;
  public DriveToPoint(double x_c, double y_c, DriveTrain dt) {
    // Add your commands in thde addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    x = x_c;
    y = y_c;
    double angle = Constants.stickTo360(x, y);
    double distince = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    
    addCommands(new TurnAngle(dt, angle));
    addCommands(new DriveStraightDistance(distince, angle, dt));
    
  }
}
