// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.mechanical_subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.lang.reflect.Array;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Indexer extends SubsystemBase {
  /** Creates a new Indexer. */
<<<<<<< HEAD
  TalonSRX frontleftMotor = new TalonSRX(Constants.front_left_Motor);
  TalonSRX frontrightMotor = new TalonSRX(Constants.front_right_Motor);
  TalonSRX backleftMotor = new TalonSRX(Constants.back_left_Motor);
  TalonSRX backrightMotor = new TalonSRX(Constants.back_right_Motor);

  public void getBalls(){
    //TODO
  }
  public void outputBall(){
   //TODO
 }
  public Indexer(){
    frontleftMotor.setInverted(true);
    frontrightMotor.setInverted(true);
    backleftMotor.setInverted(false);
    backleftMotor.setInverted(false);
  }
 

  public void setVFront(int velocity){
    frontleftMotor.set(ControlMode.Velocity, velocity/10);
    frontrightMotor.set(ControlMode.Velocity, velocity);
  }
 
  public void setVBack(int percentOutput){
    backleftMotor.set(ControlMode.PercentOutput,  percentOutput);
    backleftMotor.set(ControlMode.PercentOutput,  percentOutput);
  }
=======
  TalonSRX frontleftMotor = new TalonSRX(Constants.front_left_motor);
  TalonSRX frontrightMotor = new TalonSRX(Constants.front_right_motor);
  //Motor775 = 0000;
  
>>>>>>> 5637c0897a29f6309d1c8ec58718d9148ae1cbca

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
