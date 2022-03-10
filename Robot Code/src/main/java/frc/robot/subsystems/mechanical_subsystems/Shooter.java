//TODO
/**
 * Subsystem Methods:
 * set Turet Angle
 * get turet Angle
 * 
 * set Hood Angle
 * get Hood Angle
 * 
 * set Flywheel Velocity
 * get Flywheel Velocity
 * 
 * fire( double distance)
 * 
 * PID settigns for falcon motors
 * 
 * 
 * Subsystem Commands:
 * Align With Hub
 * Fire
 * driver shooter control (this command allows the driver to control the angle of the turet with joystikcs, incase limelight stops working)
 * 
 * 
 * 
 * 
 */
package frc.robot.subsystems.mechanical_subsystems;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Shooter extends SubsystemBase {
  TalonSRX turetMotor = new TalonSRX(Constants.turet_motor_id);
  TalonSRX hoodMotor = new TalonSRX(Constants.hood_motor_id);
  TalonSRX flywheelMotor = new TalonSRX(Constants.flywheel_motor_id);
  /** Creates a new Shooter. */
  public Shooter() {
    turetMotor.setSelectedSensorPosition(0);

    //TODO
    //set soft limits for motior
    //pid constants
    
  }

  public void setTuretAngle(double angle){
    
    //add motor checks
    
    turetMotor.set(ControlMode.Position, ((turetMotor.getSelectedSensorPosition() + 
    RobotContainer.angleDistance2(angle, getTuretAngle())*Constants.turet_ticks_per_degree * (RobotContainer.shouldTurnLeft(getTuretAngle(), angle) ? 1:-1) )));

    
  } 
  public double getTuretAngle(){
    //WIP
    double pos = turetMotor.getSelectedSensorPosition();
    pos = RobotContainer.floorMod(pos/Constants.turet_ticks_per_degree, 360);
    return pos;
  }
  public void setHoodAngle(int angle){
    hoodMotor.set(ControlMode.Position, angle * Constants.hood_ticks_per_degree);
  } 
  public int getHoodAngle(){
    //WIP
    return 0;
  }
  public void setFlywheelVelocity(int velocity){
    flywheelMotor.set(ControlMode.Velocity, velocity * Constants.flywheel_velocity_to_meters);
  }
  public int getFlywheelVelocity(int velocity){
   //WIP
    return 0;
  }


  //TODO
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Turet Angle", getTuretAngle());
  }
}
