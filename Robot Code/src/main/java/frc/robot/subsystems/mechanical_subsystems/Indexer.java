/**
 * TODO
 * 
 * Complete the color sensor class:
 * - we will have two color sensors, one in the front indexer, one in the back of the indexer. 
 * - the color sensor subsystem should return if we have a ball in the front or back, and the color of each ball
 * 
 * Then: 
 * PID settings for Falcon Motors
 * 
 *
 * getBallStates methods for the indexer class
 * 
 * commands
 * BackIndexerUpDown command
 * front indexer spin
 * 
 * 
 */

package frc.robot.subsystems.mechanical_subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Indexer extends SubsystemBase {
  /** Creates a new Indexer. */
  TalonSRX frontleftMotor = new TalonSRX(Constants.front_left_Motor);
  TalonSRX frontrightMotor = new TalonSRX(Constants.front_right_Motor);
  TalonSRX backleftMotor = new TalonSRX(Constants.back_left_Motor);
  TalonSRX backrightMotor = new TalonSRX(Constants.back_right_Motor);

  double v, p = 0.0;

  public double[] getBallStates(){
    //TODO
    double[] zero = {0,0};
    return zero;
  }
 
  public Indexer(){
    frontleftMotor.setInverted(false);
    frontrightMotor.setInverted(true);
    backleftMotor.setInverted(false);
    backleftMotor.setInverted(false);
  }
 

  public void setVFront(double velocity){
    if (velocity != v) {
      frontleftMotor.set(ControlMode.Velocity, (velocity/10)*Constants.front_wheel_rev_per_meter*Constants.front_index_motor_ticks_per_rotation);
      frontrightMotor.set(ControlMode.Velocity, (velocity/10)*Constants.front_wheel_rev_per_meter*Constants.front_index_motor_ticks_per_rotation);
      v = velocity;
    }
  }
 
  public void setPercentOutput(double percentOutput){
    if(percentOutput != p){
      backleftMotor.set(ControlMode.PercentOutput,  percentOutput);
      backrightMotor.set(ControlMode.PercentOutput,  percentOutput);

      frontleftMotor.set(ControlMode.PercentOutput, percentOutput);
      frontrightMotor.set(ControlMode.PercentOutput, percentOutput);
      p = percentOutput;
    }
  }


  public void setPercentOutputFront(double percentOutput){
    if(percentOutput != p){
      
      frontleftMotor.set(ControlMode.PercentOutput, percentOutput);
      frontrightMotor.set(ControlMode.PercentOutput, percentOutput);
      p = percentOutput;
    }
  }

  
  public void setPercentOutputBack(double percentOutput){
    if(percentOutput != p){
      
      backleftMotor.set(ControlMode.PercentOutput,  percentOutput);
      backrightMotor.set(ControlMode.PercentOutput,  percentOutput);
      p = percentOutput;
    }
  }
  

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
