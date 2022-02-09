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
import java.lang.Math;
import java.lang.reflect.Array;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Indexer extends SubsystemBase {
  /** Creates a new Indexer. */
  TalonSRX frontleftMotor = new TalonSRX(Constants.front_left_Motor);
  TalonSRX frontrightMotor = new TalonSRX(Constants.front_right_Motor);
  TalonSRX backleftMotor = new TalonSRX(Constants.back_left_Motor);
  TalonSRX backrightMotor = new TalonSRX(Constants.back_right_Motor);

  public double[] getBallStates(){
    //TODO
  }
 
  public Indexer(){
    frontleftMotor.setInverted(true);
    frontrightMotor.setInverted(true);
    backleftMotor.setInverted(false);
    backleftMotor.setInverted(false);
  }
 

  public void setVFront(int velocity){
    frontleftMotor.set(ControlMode.Velocity, (velocity/10)*Constants.front_wheel_rev_per_meter*Constants.front_index_motor_ticks_per_rotation);
    frontrightMotor.set(ControlMode.Velocity, (velocity/10)*Constants.front_wheel_rev_per_meter*Constants.front_index_motor_ticks_per_rotation);
  }
 
  public void setPercentOutput(int percentOutput){
    backleftMotor.set(ControlMode.PercentOutput,  percentOutput);
    backleftMotor.set(ControlMode.PercentOutput,  percentOutput);
  }

  //Motor775 = 0000;
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
