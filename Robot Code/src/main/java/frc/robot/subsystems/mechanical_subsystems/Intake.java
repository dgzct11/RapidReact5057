// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.mechanical_subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
<<<<<<< HEAD

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  public Intake() {}
=======
import frc.robot.Constants;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  Compressor comp = new Compressor(1, PneumaticsModuleType.REVPH);
  DoubleSolenoid ds = new DoubleSolenoid(Constants.pneumatic_CAN_id, PneumaticsModuleType.REVPH, Constants.forward_channel_port, Constants.reverse_channel_port);
  TalonSRX intakeMotor = new TalonSRX(Constants.intake_motor_id);
  boolean isUp;
  public Intake() {
    up();
  }

  public void up(){
    ds.set(kReverse);
    isUp = true;
    
  }
  public void down(){
    ds.set(kForward);
    isUp = false;
  }

  public void spin(){
    intakeMotor.set(ControlMode.PercentOutput, Constants.intake_motor_percent_output);
  }

  public boolean getState(){
    return isUp;
  }
>>>>>>> 5637c0897a29f6309d1c8ec58718d9148ae1cbca
  //TODO
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
