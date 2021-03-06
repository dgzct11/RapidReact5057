/**
 * TODO
 * 
 * finish intake up down, and intake spin commands
 * research 
 * check out limelight TODO
 */
package frc.robot.subsystems.mechanical_subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  Compressor comp = new Compressor(1, PneumaticsModuleType.REVPH);
  DoubleSolenoid ds = new DoubleSolenoid(Constants.pneumatic_CAN_id, PneumaticsModuleType.REVPH, Constants.forward_channel_port, Constants.reverse_channel_port);
  Spark intakeMotor = new Spark(Constants.intake_motor_id);
  boolean isUp;
  public Intake() {
    down();
  }

  public void down() {
    ds.set(kForward);
    isUp = false;
  }

  public void up() {
    ds.set(kReverse);
    isUp = true;
  }

  public void spin(){
    intakeMotor.set(Constants.intake_motor_percent_output);
  }

  public void stopSpin() {
    intakeMotor.set(0.0);
  }

  public boolean getState(){
    return isUp;
  }
  //TODO
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
