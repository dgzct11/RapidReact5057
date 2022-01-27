// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import com.kauailabs.navx.frc.AHRS;

//import org.graalvm.compiler.nodes.ConstantNode;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AlignBall;
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
    return new AlignBall(driveTrain);
  }






}
