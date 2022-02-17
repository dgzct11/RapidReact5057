/**
 * TODO
 * 
 * getBallStates
 * returns an array, representing the balls currently in the indexer
 * example: [0,0] no ball, no ball
 * [1,2] redball, blueball
 */
package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ColorSensor extends SubsystemBase {
  /** Creates a new ColorSensor. */
  public ColorSensor() {}


  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(Constants.i2cPort);
  
  private final ColorMatch m_colorMatcher = new ColorMatch();
  
  private final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
  private final Color kRedTarget = new Color(0.561, 0.232, 0.114);

  public int[] Balls = new int[2];

