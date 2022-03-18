// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.autonomous_commands.AutoTest;
import frc.robot.commands.autonomous_commands.FinalAuto;
import frc.robot.commands.button_commands.AlignAllWheels;
import frc.robot.commands.button_commands.DecreaseRotateSpeed;
import frc.robot.commands.button_commands.DecreaseSpeed;

import frc.robot.commands.button_commands.IncreaseRotateSpeed;
import frc.robot.commands.button_commands.IncreaseSpeed;
import frc.robot.commands.button_commands.IncrementShooterOutput;
import frc.robot.commands.button_commands.ResetNavX;
import frc.robot.commands.button_commands.SwitchDriveMode;
import frc.robot.commands.button_commands.ToggleLimelight;
import frc.robot.commands.climb_commands.ClimbCommand;
import frc.robot.commands.driving_commands.SwerveDrive;
import frc.robot.commands.indexer_commands.BackIndexer;
import frc.robot.commands.indexer_commands.IndexerSpin;
import frc.robot.commands.intake_commands.BackIndexerSpin;
import frc.robot.commands.intake_commands.IntakeSpin;
import frc.robot.commands.intake_commands.IntakeToggle;
import frc.robot.commands.shooter_commands.ControlHood;
import frc.robot.commands.shooter_commands.Fire;
import frc.robot.commands.shooter_commands.KeepShooterStill;
import frc.robot.functional.trajectory.Circle;
import frc.robot.functional.trajectory.Line;
import frc.robot.functional.trajectory.Path;
import frc.robot.subsystems.mechanical_subsystems.Climb;
import frc.robot.subsystems.mechanical_subsystems.DriveTrain;
import frc.robot.subsystems.mechanical_subsystems.Indexer;
import frc.robot.subsystems.mechanical_subsystems.Intake;
import frc.robot.subsystems.mechanical_subsystems.Shooter;
import frc.robot.subsystems.sensors.LimeLight;
import frc.robot.subsystems.sensors.NavXGyro;
import frc.robot.subsystems.sensors.Odometry;
import frc.robot.subsystems.sensors.XboxRemote;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //hardware
  public XboxController xboxController = new XboxController(Constants.xbox_port);
  public XboxController subsystemController = new XboxController(Constants.xbox_port_2);

  private SendableChooser<Command> chooser = new SendableChooser<>();


  //subsystems
    //Mechanical subsystems
  public DriveTrain driveTrain = new DriveTrain();
  public Intake intake;
  public Shooter shooter = new Shooter();
  public Indexer indexer = new Indexer();
  public Climb climb = new Climb();
 
    //Sensor subsystems
  public XboxRemote xboxRemote = new XboxRemote(xboxController);
  public XboxRemote subsytemRemote = new XboxRemote(subsystemController);
 
  public NavXGyro navx = new NavXGyro(); 
  public LimeLight limeLight = new LimeLight();

  public Odometry odometry = new Odometry(driveTrain, limeLight);

  
  //FinalAuto auto = new FinalAuto(driveTrain, odometry, intake, indexer, shooter, limeLight);

  
  //public Odometry odometry = new Odometry(driveTrain, limeLight);
  //buttons

    //xboxcontroller buttons

      Button leftPad = new POVButton(xboxController, Constants.left_pad_num);
      Button rightPad = new POVButton(xboxController, Constants.right_pad_num);
      Button upPad = new POVButton(xboxController, Constants.up_pad_num);
      Button downPad = new POVButton(xboxController, Constants.down_pad_num);

      Button rightButton = new JoystickButton(xboxController, Constants.rb_button_num);
      Button leftButton = new JoystickButton(xboxController, Constants.lb_button_num);

      Button xButton = new JoystickButton(xboxController, Constants.x_button_num);
      Button aButton = new JoystickButton(xboxController, Constants.a_button_num);
      Button bButton = new JoystickButton(xboxController, Constants.b_button_num); 
      Button yButton = new JoystickButton(xboxController, Constants.y_button_num);


      Button startButton = new JoystickButton(xboxController, Constants.start_button_num);
      Button backButton = new JoystickButton(xboxController, Constants.back_button_num);
      
    // subsystem buttons
      Button subLeftPad = new POVButton(subsystemController, Constants.left_pad_num);
      Button subRightPad = new POVButton(subsystemController, Constants.right_pad_num);
      Button subUpPad = new POVButton(subsystemController, Constants.up_pad_num);
      Button subDownPad = new POVButton(subsystemController, Constants.down_pad_num);
      Button subRightButton = new JoystickButton(subsystemController, Constants.rb_button_num);
      Button subLeftButton = new JoystickButton(subsystemController, Constants.lb_button_num);
      Button subXButton = new JoystickButton(subsystemController, Constants.x_button_num);
      Button subAButton = new JoystickButton(subsystemController, Constants.a_button_num);
      Button subBButton = new JoystickButton(subsystemController, Constants.b_button_num); 
      Button subYButton = new JoystickButton(subsystemController, Constants.y_button_num);
      Button subStartButton = new JoystickButton(subsystemController, Constants.start_button_num);
      Button subBackButton = new JoystickButton(subsystemController, Constants.back_button_num);
      Joystick subRightJ = new Joystick(Constants.right_joystick_port);

  public RobotContainer() {
    // configures commands
    NavXGyro.ahrs.reset();

    SwerveDrive sd = new SwerveDrive(driveTrain, xboxRemote);
    driveTrain.setDefaultCommand(sd);
    sd.addRequirements(driveTrain);
  
    //KeepShooterStill ks = new KeepShooterStill(shooter, limeLight);
    
    //shooter.setDefaultCommand(ks);
   
    //ks.addRequirements(shooter);
    

    intake = new Intake();

    ClimbCommand cc = new ClimbCommand(subsytemRemote, climb);
    climb.setDefaultCommand(cc);
    cc.addRequirements(climb);


    SmartDashboard.putData("Autonomous Chooser", chooser);

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  
  private void configureButtonBindings() {
    leftButton.whenPressed(new DecreaseSpeed());
    rightButton.whenPressed(new IncreaseSpeed());

  

    yButton.whenPressed(new DecreaseRotateSpeed());
    aButton.whenPressed(new IncreaseRotateSpeed());
    xButton.whenPressed(new ResetNavX());
    bButton.whenPressed(new ToggleLimelight());
    
    //startButton.whenPressed(new AlignAllWheels(driveTrain));
    backButton.whenPressed(new SwitchDriveMode());
    
    //subsytems
    subRightButton.whenHeld(new Fire(shooter, limeLight));
    //subXButton.whenPressed(new IntakeToggle(intake));
    subAButton.whenHeld(new IntakeSpin(intake, indexer));
    subBButton.whenHeld(new IndexerSpin(indexer));
    subYButton.whenHeld(new BackIndexerSpin(indexer));

    //subUpPad.whenPressed(new SetShooterAngle(0, shooter));
    //subLeftPad.whenPressed(new SetShooterAngle(90, shooter));
    //subDownPad.whenPressed(new SetShooterAngle(180, shooter));
    //subRightPad.whenPressed(new SetShooterAngle(270, shooter));

    
    //subYButton.whenPressed(new IncrementShooterOutput(-0.1));
    //subBButton.whenPressed(new IncrementShooterOutput(0.1));

    
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    Command auto = null;
    //if()
    return null;
    //return new FinalAuto(driveTrain, odometry, intake, indexer, shooter, limeLight);
    //return new AutoTest(driveTrain, intake, indexer, shooter, odometry, limeLight);
  }

  public static double navxTo360(double angle){
        
    if (angle<=0) angle += 360;

    return 360-angle;
  }
  public static double to360(double angle) {
    if (angle <= 0) angle += 360;

    return Math.abs(angle%360);
  }
  public static double stickTo360(double x, double y){
   return (Math.toDegrees(Math.atan2(-x, y)) +360 )%360;
  }
  public static boolean shouldTurnLeftNavx(double currentNavxAngle, double targetAngle){
    double angle = navxTo360(currentNavxAngle);
    boolean value = false;

    if(targetAngle < 180) value = angle<targetAngle || angle> 180+targetAngle;
    else value = angle<targetAngle && angle> targetAngle-180;
    return value;
  }
  public static boolean shouldTurnLeft(double currentNavxAngle, double targetAngle){
    double angle = currentNavxAngle;
    boolean value = false;

    if(targetAngle <= 180) value = angle<targetAngle || angle> 180+targetAngle;
    else value = angle<targetAngle && angle> targetAngle-180;
    return value;
  }

  public static double vectorToAngle(double x, double y) {
    return (Math.toDegrees(Math.atan2(y, x)) +360 )%360;
  }

  public static double distance(double[] p1, double[] p2){
    return Math.sqrt( Math.pow(p1[1] - p2[1], 2) + Math.pow(p1[0] - p2[0], 2));
  }


  public static double angleFromSlope(double[] start, double[] end){
    return Math.toDegrees(Math.atan2((end[1] - start[1]), end[0] - start[0]));
  }
  public static double magnitutde(double[] vector){
    return Math.sqrt((vector[0]*vector[0]) + (vector[1]*vector[1]));
  }

  public static double angleDistance2(double targetAngle, double angle){
    
    double distance = Math.abs(targetAngle - angle)%360;
    if (distance > 180) distance = 360 - distance;
    return distance;
  }


  public static double floorMod(double x, double y){
    if(x<0)
        return y - Math.abs(x)%y;
    return x%y;
}

public static double angleToPoint(double[] start, double[] end){
  double dx = end[0]-start[0];
  double dy = end[1]-start[1];
  return to360(Math.toDegrees(Math.atan2(-dx, dy)));

}
public static double getArcLength(Circle circle){
  Line base = new Line(circle.startPoint, circle.endPoint);
  double[] midPoint = base.getMidPoint();
  double halfAngle = Math.atan(distance(midPoint, base.startPoint)/distance(midPoint, circle.center));
  return halfAngle*2*circle.radius;
}
  public static double getAngleFromPathEndpoints(Path path){
    double[] endpoint = path.points[path.points.length-1];
    double[] secondpoint = path.points[path.points.length-2];
    double dx = endpoint[0]- secondpoint[0];
    double dy = endpoint[0]- secondpoint[0];
    return Math.toDegrees(Math.atan2(dy, dx)) + 270;
  }


}
