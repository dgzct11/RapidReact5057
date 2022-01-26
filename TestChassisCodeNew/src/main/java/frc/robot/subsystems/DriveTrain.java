// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  TalonSRX leftSpeedC = new TalonSRX(Constants.left_motor_port);
  TalonSRX rightSpeedC = new TalonSRX(Constants.right_motor_port);
  public double currentLeft = 0;
  public double currentRight = 0;
  
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    
  }

  public void setRightMotor(double speed){
    double value = speed*Constants.max_motor_percent;
    rightSpeedC.set(ControlMode.PercentOutput, value);
    currentRight = value;
  }
  public void setLeftMotor(double speed){
    double value = -speed*Constants.max_motor_percent;
    leftSpeedC.set(ControlMode.PercentOutput,value );
    currentLeft = -speed*Constants.max_motor_percent;
  }

  public void stop(){
  
    rightSpeedC.setNeutralMode(NeutralMode.Brake);
    leftSpeedC.setNeutralMode(NeutralMode.Brake);
    currentLeft = 0;
    currentRight = 0;
  }
  public void spin(double speed){
    //pos speed is left
    //neg speed is right
    rightSpeedC.set(ControlMode.PercentOutput, speed*Constants.max_motor_percent);
    currentLeft = speed;
    currentRight = speed;
    leftSpeedC.set(ControlMode.PercentOutput, speed*Constants.max_motor_percent);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
