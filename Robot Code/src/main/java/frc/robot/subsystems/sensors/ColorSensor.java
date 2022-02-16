/**
 * TODO
 * 
 * getBallStates
 * returns an array, representing the balls currently in the indexer
 * example: [0,0] no ball, no ball
 * [1,2] redball, blueball
 */
package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.util.Color;

import java.lang.reflect.Array;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;





public class ColorSensor extends SubsystemBase {
  /** Creates a new ColorSensor. */

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

  @Override
  public void periodic() {
    // This method will be called once per scheduler run


    Color detectedColor = m_colorSensor.getColor();


    int colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    int proximity = m_colorSensor.getProximity();


    
    if (proximity <6){
      if (match.color == kBlueTarget) {
        colorString = -1;
      } else if (match.color == kRedTarget) {
        colorString = -1;
      } else {
        colorString = 0;
      }
      Balls[0] = colorString;
    }


  }
  
}
