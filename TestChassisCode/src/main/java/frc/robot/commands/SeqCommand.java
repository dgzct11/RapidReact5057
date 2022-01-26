// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;




// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SeqCommand extends SequentialCommandGroup {
  /** Creates a new DriveToPoint. */
  
  public SeqCommand(Command[] commands) {
    // Add your commands in thde addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
   for(int c = 0; c<commands.length; c++){
       addCommands(commands[c]);
   }
    
   
    
  }
}
