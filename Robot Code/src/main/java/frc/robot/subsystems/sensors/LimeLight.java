//TODO
/**
 * In Odometry, implement the updatePosition Limelight
 *  - this method should use the heading from the robot, the heading of the turet, and the horizontal angle displacement of the limelight,
 *    as well as the distance, to calculate the x, y cooridnate of the robot.
 */
package frc.robot.subsystems.sensors;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;




public class LimeLight extends SubsystemBase {
  /** Creates a new LimeLight. */
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  //horizontal angle offset to target
  NetworkTableEntry tx = table.getEntry("tx");
  //vertical angle offset to target
  NetworkTableEntry ty = table.getEntry("ty");

  //how much of the cameras area is taken up by the object
  //used for distance estimation. 
  NetworkTableEntry ta = table.getEntry("ta");

  //boolean value wether its in viuew
  NetworkTableEntry tv = table.getEntry("tv");
  
  

  public LimeLight() {
  
  }

  

  public double getDistance(){
    double theta = Constants.camera_angle + ty.getDouble(0.0);
    double height = Constants.hub_height - Constants.limeLightHeight;
    double distance = height / java.lang.Math.tan(theta);
    return distance;
  }
  public double getHorizontalOffset(){
    return tx.getDouble(0.0);
  }
  public boolean isInView(){
    return tv.getBoolean(false);
  }
  

  @Override
  public void periodic() {
   System.out.println(ta.getDouble(0)); //prints area of object
  }
}
//hi