/**
 * TODO
 * 
 * getBallStates
 * returns an array, representing the balls currently in the indexer
 * example: [0,0] no ball, no ball
 * [1,2] redball, blueball
 */
package frc.robot.subsystems.sensors;

<<<<<<< HEAD
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
=======
import edu.wpi.first.wpilibj2.command.SubsystemBase;

>>>>>>> 8affcc67ef8069a35fafe8acfdf9f1e45698a7bc
public class ColorSensor extends SubsystemBase {
  /** Creates a new ColorSensor. */
  public ColorSensor() {}

<<<<<<< HEAD
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(Constants.i2cPort);
  
  private final ColorMatch m_colorMatcher = new ColorMatch();
  
  private final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
  private final Color kRedTarget = new Color(0.561, 0.232, 0.114);

  public int[] Balls = new int[2];

  
  public ColorSensor() {
  }

  public int[] getBalls(){
    if (Constants.TeamColor == "Red"){
      Balls[0] = Balls[0];
       }
    else if (Constants.TeamColor == "Blue"){
      Balls[0] = Balls[0];
    }
    return Balls;
  }
=======
>>>>>>> 8affcc67ef8069a35fafe8acfdf9f1e45698a7bc

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
  
}
