// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import com.kauailabs.navx.frc.AHRS;

//import org.graalvm.compiler.nodes.ConstantNode;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ChangeMaxSpeed;
import frc.robot.commands.DisplayMPX;

import frc.robot.commands.SwitchDriveMode;
import frc.robot.commands.TankDrive;
import frc.robot.commands.TurnAngle;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.NavXGyro;
//import jdk.vm.ci.meta.Constant;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //devices
   public  static XboxController xbox_controller = new XboxController(Constants.xbox_port);
 
  //subsystems
  private final NavXGyro navx;
  private final DriveTrain driveTrain;

  //commands
  private final TankDrive tankDrive;
  private final DisplayMPX displayMPX;
  private final TurnAngle tn;



  //Buttons
  /*Button aButtonTurn90Left = new JoystickButton(xbox_controller, Constants.a_button_num);
  Button bButtonTurn90Right = new JoystickButton(xbox_controller, Constants.b_button_num);
  Button xButtonSwitchDrive = new JoystickButton(xbox_controller, Constants.x_button_num);
  Button yButtonGo0 = new JoystickButton(xbox_controller, Constants.y_button_num);*/
  Button leftPad = new POVButton(xbox_controller, Constants.left_pad_num);
  Button rightPad = new POVButton(xbox_controller, Constants.right_pad_num);
  Button upPad = new POVButton(xbox_controller, Constants.up_pad_num);
  Button downPad = new POVButton(xbox_controller, Constants.down_pad_num);

  Button xButtonSwitchDrive = new JoystickButton(xbox_controller, Constants.x_button_num);

  Button rightButtonIncMotor = new JoystickButton(xbox_controller, Constants.rb_button_num);
  Button leftButtonDecMotor = new JoystickButton(xbox_controller, Constants.lb_button_num);
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    //subsytems 
    driveTrain = new DriveTrain();
    navx = new NavXGyro();
    
    //commands
    tankDrive = new TankDrive(driveTrain);
    tankDrive.addRequirements(driveTrain);
  
    tn = new TurnAngle(driveTrain, 90);
    tn.addRequirements(navx);
    tn.addRequirements(driveTrain);
    displayMPX = new DisplayMPX(navx);
    displayMPX.addRequirements(navx);
   
    driveTrain.setDefaultCommand(tankDrive);
    navx.setDefaultCommand(displayMPX);
    configureButtonBindings();
    
    
    
    
    
    
  }

  /*
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    leftPad.whenPressed(new TurnAngle(driveTrain, -90));
    rightPad.whenPressed(new TurnAngle(driveTrain,  90));
    upPad.whenPressed(new TurnAngle(driveTrain, 0));
    downPad.whenPressed(new TurnAngle(driveTrain, 180));
    xButtonSwitchDrive.whenPressed(new SwitchDriveMode(driveTrain, navx));
    rightButtonIncMotor.whenPressed(new ChangeMaxSpeed(0.1));
    leftButtonDecMotor.whenPressed(new ChangeMaxSpeed(-0.1));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }


  public Command getPathFollowCommand(){
    public Command getAutonomousCommand() {
 81
 82    // Create a voltage constraint to ensure we don't accelerate too fast
 83    var autoVoltageConstraint =
 84        new DifferentialDriveVoltageConstraint(
 85            new SimpleMotorFeedforward(
 86                Constants.ksVolts,
 87                Constants.kvVoltSecondsPerMeter,
 88                Constants.kaVoltSecondsSquaredPerMeter),
 89            Constants.kDriveKinematics,
 90            10);
 91
 92    // Create config for trajectory
 93    TrajectoryConfig config =
 94        new TrajectoryConfig(
 95                Constants.kMaxSpeedMetersPerSecond,
 96                       Constants.kMaxAccelerationMetersPerSecondSquared)
 97            // Add kinematics to ensure max speed is actually obeyed
 98            .setKinematics(DriveConstants.kDriveKinematics)
 99            // Apply the voltage constraint
100            .addConstraint(autoVoltageConstraint);
101
102    // An example trajectory to follow.  All units in meters.
103    Trajectory exampleTrajectory =
104        TrajectoryGenerator.generateTrajectory(
105            // Start at the origin facing the +X direction
106            new Pose2d(0, 0, new Rotation2d(0)),
107            // Pass through these two interior waypoints, making an 's' curve path
108            List.of(new Translation2d(1, 1), new Translation2d(2, -1)),
109            // End 3 meters straight ahead of where we started, facing forward
110            new Pose2d(3, 0, new Rotation2d(0)),
111            // Pass config
112            config);
113
114    RamseteCommand ramseteCommand =
115        new RamseteCommand(
116            exampleTrajectory,
117            driveTrain::getPose,
118            new RamseteController(Constants.kRamseteB, Constants.kRamseteZeta),
119            new SimpleMotorFeedforward(
120                Constants.ksVolts,
121                Constants.kvVoltSecondsPerMeter,
122                Constants.kaVoltSecondsSquaredPerMeter),
123           Constants.kDriveKinematics,
124            driveTrain::getWheelSpeeds,
125            new PIDController(Constants.kPDriveVel, 0, 0),
126            new PIDController(Constants.kPDriveVel, 0, 0),
127            // RamseteCommand passes volts to the callback
128            driveTrain::tankDriveVolts,
129            driveTrain);
130
131    // Reset odometry to the starting pose of the trajectory.
132    driveTrain.resetOdometry(exampleTrajectory.getInitialPose());
133
134    // Run path following command, then stop at the end.
135    return ramseteCommand.andThen(() -> m_robotDrive.tankDriveVolts(0, 0));

  }
}
