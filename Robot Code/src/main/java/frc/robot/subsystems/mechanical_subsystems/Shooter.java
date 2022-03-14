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

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Shooter extends SubsystemBase {
  private double shooterAngle;
  private double flywheelVelocity;
  private double hoodAngle; 

  TalonSRX turetMotor = new TalonSRX(Constants.turet_motor_id);
  Servo hoodServo = new Servo(Constants.hood_servo_id);
  TalonSRX flywheelMotorL = new TalonSRX(Constants.flywheel_motor_id);
  TalonSRX flywheelMotorR = new TalonSRX(Constants.flywheel_motor_id);

  /** Creates a new Shooter. */
  public Shooter(double angle) {
    flywheelMotorL.setInverted(true);
    shooterAngle = angle;
  }
  public Shooter() {
    flywheelMotorL.setInverted(true);
    shooterAngle = 0;
  }

  //
  public void setTuretAngle(int angle){
    if(angle != shooterAngle){
      turetMotor.set(ControlMode.Position, angle * Constants.turet_ticks_per_degree);
      shooterAngle = angle;
    }
  } 
  public double getTuretAngle(){
    return shooterAngle;
  }

  public void setHood(double b) {
    if(b != hoodAngle){
      hoodServo.set(b);
      hoodAngle = b;
    }
  }
  public double getHoodAngle(){
    return hoodAngle;
  }

  public void setFlywheelVelocity(double velocity){
    if(velocity != flywheelVelocity){
      flywheelMotorL.set(ControlMode.Velocity, velocity * Constants.flywheel_velocity_to_ticks * Constants.flywheel_percent);
      flywheelMotorR.set(ControlMode.Velocity, velocity * Constants.flywheel_velocity_to_ticks * Constants.flywheel_percent);
      flywheelVelocity = velocity;
    }
  }
  public double getFlywheelVelocity(){
    return flywheelMotorL.getSelectedSensorVelocity()/Constants.flywheel_velocity_to_ticks;
  }
  

  //TODO
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
