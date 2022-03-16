/**
 * TODO
 * 
 * implement getHeight, getAngle, setAngularVelocity
 * 
 * PID settings for Falcon Motors
 * 
 * Commands:
 * driverClimbControl
 * Automatic climbing
 */

package frc.robot.subsystems.mechanical_subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {
  /** Creates a new Climber. */
  TalonSRX telescopingTL = new TalonSRX(Constants.motorTLPort);

  TalonSRX telescopingAL = new TalonSRX(Constants.motorALPort);
  TalonSRX telescopingAR = new TalonSRX(Constants.motorARPort);
  
  double v, a, h = 0.0;
  public Climb() {
    telescopingAL.setStatusFramePeriod(1, 255);
    telescopingAL.setStatusFramePeriod(2, 255);

    telescopingTL.setStatusFramePeriod(1, 255);
    telescopingTL.setStatusFramePeriod(2, 255);
    

    telescopingAR.setStatusFramePeriod(1, 255);
    telescopingAR.setStatusFramePeriod(2, 255);

  }
  
  //TODO
  public double getHeight()
  {
    return (telescopingTL.getSelectedSensorPosition()/Constants.telescoping_meter_to_ticks);
  } 

  public double getAngle()
  {
    return ((telescopingAL.getSelectedSensorPosition()/Constants.pivot_motor_ticks__per_degree)+(telescopingAR.getSelectedSensorPosition()/Constants.pivot_motor_ticks__per_degree)/2);
  }

  public void setAngularVelocity(double angularVelocity)
  {
   
  }


  public void setVelocity(double velocity)
  {
    if (velocity != v) {
      telescopingTL.set(ControlMode.Velocity, velocity * (Constants.telescoping_velocity_to_ticks));
      v = velocity;
    }

   
    
    
  }


  public void setPercentOutput(double percentOutput){
    telescopingTL.set(ControlMode.PercentOutput, percentOutput);
  }
  public void setHeight(double height)
  {
    
    if (height != h) {
      telescopingTL.set(ControlMode.MotionMagic, height*(Constants.telescoping_meter_to_ticks));
      h = height;
    }
  }

  public void setAngle(double angle)
  {
    
    if (angle != a) {
      telescopingAL.set(ControlMode.MotionMagic, angle*(Constants.pivot_motor_ticks__per_degree));
      telescopingAR.set(ControlMode.MotionMagic, angle*(Constants.pivot_motor_ticks__per_degree));
      a = angle;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
