// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.mechanical_subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {
  /** Creates a new Climber. */
  TalonSRX telescopingTL = new TalonSRX(Constants.motorTLPort);
  TalonSRX telescopingTR = new TalonSRX(Constants.motorTRPort);
  TalonSRX telescopingAL = new TalonSRX(Constants.motorALPort);
  TalonSRX telescopingAR = new TalonSRX(Constants.motorARPort);
  
  public Climb() {}
  
  //TODO
  public void getHeight()
  {

  }
  public void setVelocity(int velocity)
  {
    telescopingTL.set(ControlMode.Velocity, velocity);
    telescopingTR.set(ControlMode.Velocity, velocity);
  }
  public void setHeight(int height)
  {
    telescopingTL.set(ControlMode.MotionMagic, height*(Constants.telescoping_meter_to_ticks));
    telescopingTR.set(ControlMode.MotionMagic, height*(Constants.telescoping_meter_to_ticks));
  }

  public void setAngle(int angle)
  {
    telescopingAL.set(ControlMode.MotionMagic, angle*(Constants.pivot_motor_ticks__per_degree));
    telescopingAR.set(ControlMode.MotionMagic, angle*(Constants.pivot_motor_ticks__per_degree));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
