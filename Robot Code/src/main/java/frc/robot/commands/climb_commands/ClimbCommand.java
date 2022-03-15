package frc.robot.commands.climb_commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.mechanical_subsystems.Climb;
import frc.robot.subsystems.sensors.XboxRemote;

public class ClimbCommand extends CommandBase{
    /** Creates a new TelescopingUp. */
    XboxRemote xboxRemote;
    Climb climb;
    public ClimbCommand( XboxRemote xRemote, Climb c) {
        xboxRemote = xRemote;
        climb = c;

        addRequirements(climb);
      // Use addRequirements() here to declare subsystem dependencies.
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if(Constants.climb_enabled){
        double leftYAxis = xboxRemote.getLeftY();
        double rightXAxis = xboxRemote.getRightX();
        
        climb.setVelocity(leftYAxis*(0.1));
        //climb.setAngularVelocity(rightXAxis*(Constants.maximum_pivot_velocity));
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
