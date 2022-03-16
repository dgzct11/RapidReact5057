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
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Shooter extends SubsystemBase {
  TalonSRX turetMotor = new TalonSRX(Constants.turet_motor_id);
  //TalonSRX hoodMotor = new TalonSRX(Constants.hood_servo_id);
  Servo hoodServo1 = new Servo(Constants.hood_servo_id1);
  Servo hoodServo2 = new Servo(Constants.hood_servo_id2);
  TalonSRX flywheelMotor = new TalonSRX(Constants.flywheel_motor_id);
  TalonSRX flywheelMotor2 = new TalonSRX(Constants.flywheel_motor_2_id);
  
  double a, v, p = 0;
  /** Creates a new Shooter. */
  public Shooter() {
    turetMotor.setSelectedSensorPosition(0);
    turetMotor.configForwardSoftLimitEnable(true);
    turetMotor.configReverseSoftLimitEnable(true);
    turetMotor.configForwardSoftLimitThreshold(90*Constants.turet_ticks_per_degree);
    turetMotor.configReverseSoftLimitThreshold(-90*Constants.turet_ticks_per_degree);
    flywheelMotor2.follow(flywheelMotor);
    flywheelMotor2.setInverted(InvertType.OpposeMaster);
    hoodServo1.set(0);
    hoodServo2.set(0);


    //TODO
    //set soft limits for motior
    //pid constants
    
  }

  public void setTuretAngle(double angle){
    if(a != angle){
    //add motor checks
    if(angle<=90 && angle >= -90){
      turetMotor.set(ControlMode.Position, ((turetMotor.getSelectedSensorPosition() + 
      RobotContainer.angleDistance2(angle, getTuretAngle())*Constants.turet_ticks_per_degree * (RobotContainer.shouldTurnLeft(getTuretAngle(), angle) ? 1:-1) )));
    }
    a = angle;
  }
    
  } 
  public double getTuretAngle(){
    //WIP
    double pos = turetMotor.getSelectedSensorPosition();
    pos = RobotContainer.floorMod(pos/Constants.turet_ticks_per_degree, 360);
    return pos;
  }
  /*public void setHoodAngle(int angle){
    hoodMotor.set(ControlMode.Position, angle * Constants.hood_ticks_per_degree);
  } */

  public void setHood(double d) {
    hoodServo1.set(d);
    hoodServo2.set(d);
  }
  
  public int getHoodAngle(){
    //WIP
    return 0;
  }
  public void setFlywheelVelocity(double velocity){
    if(v != velocity){

    
    flywheelMotor.set(ControlMode.Velocity, velocity * Constants.flywheel_velocity_to_meters);
    v = velocity;
    }
  }

  public void setFlywheelPercentOutput(double percentOutput){
    if( p!= percentOutput){
      flywheelMotor.set(ControlMode.PercentOutput, percentOutput);
      p = percentOutput;
    }
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
