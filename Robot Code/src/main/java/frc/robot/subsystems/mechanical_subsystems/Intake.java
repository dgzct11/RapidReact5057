// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.mechanical_subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  
  public Intake() {
    Compressor comp = new Compressor(1, PneumaticsModuleType.REVPH);
    DoubleSolenoid ds = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.forward_channel, Constants.reverse_channel);
  }
  //TODO
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
