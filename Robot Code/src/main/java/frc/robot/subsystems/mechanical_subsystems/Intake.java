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
import frc.robot.RobotContainer;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  public static PneumaticHub hub = new PneumaticHub(19);
  //Compressor comp = hub.makeCompressor();
  
  Solenoid fs  = hub.makeSolenoid(Constants.forward_channel_port);
  Solenoid rs = hub.makeSolenoid(Constants.reverse_channel_port);

  //DoubleSolenoid ds = new DoubleSolenoid(Constants.pneumatic_CAN_id, PneumaticsModuleType.REVPH, Constants.forward_channel_port, Constants.reverse_channel_port);
  TalonSRX intakeMotor = new TalonSRX(Constants.intake_motor_id);
  public boolean isUp;



  //m_motor = new CANSparkMax(deviceID, MotorType.kBrushless);
  public Intake() {
    up();
    intakeMotor.setStatusFramePeriod(1, 255);
    intakeMotor.setStatusFramePeriod(2, 255);

    
    
  }

  public void up(){
    isUp = true;
    //fs.set(true);
    //rs.set(false);
    //ds.set(kForward);
    
    
  }
  public void down(){
    isUp = false;
    //fs.set(false);
    //rs.set(true);
    
    //ds.set(kReverse);
  }

  public void spin(){
    intakeMotor.set(ControlMode.PercentOutput, Constants.intake_motor_percent_output);
 
  }

  public void stop(){
    intakeMotor.set(ControlMode.PercentOutput, 0);
  
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
