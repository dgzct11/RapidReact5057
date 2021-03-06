// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.SPI.Port;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //ports
    public static final int left_joystick_port = 1;
    public static final int right_joystick_port = 0;

    public static final int xbox_port = 0;
    public static final Port mxp_port = Port.kMXP;
    
    //Swurve Drive
    public static final int left_front_direction_port = 7;
    public static final int left_front_thrust_port = 8;
    public static final int right_back_direction_port = 3;
    public static final int right_back_thrust_port = 4;
    public static final int left_back_direction_port = 1;
    public static final int left_back_thrust_port = 2;
    public static final int right_front_direction_port = 5;
    public static final int right_front_thrust_port = 6;
   
    //Intake
    public static final int forward_channel= 1;
    public static final int reverse_channel = 1;

    //Climb
    public static final int motorTLPort = 0;
    public static final int motorTRPort = 0;
    public static final int motorALPort = 0;
    public static final int motorARPort = 0;
    public static final int pivot_motor_ticks__per_degree = 0;
    public static final int telescoping_meter_to_ticks = 0;
    public static final int telescoping_velocity_to_ticks = 0;
    //Index
    public static final int front_left_Motor = 0000; // WIP
    public static final int front_right_Motor = 0000; // WIP
    public static final int back_left_Motor = 0000; // WIP
    public static final int back_right_Motor = 0000; // WIP
    public static final int front_radius = 1;
    public static final double front_wheel_rev_per_meter = 1/(2*Math.PI*front_radius);
    public static final double front_index_motor_ticks_per_rotation = 1;




    //Intake
    public static final int forward_channel_port = 1;
    public static final int reverse_channel_port = 0;
    public static final int pneumatic_CAN_id = 9;
    public static final int intake_motor_id = 9;
    public static final int intake_motor_percent_output = 1;
    public static final int back_indexer_speed = 1;
    public static final int front_indexer_speed = 1;

    //Climb
   
    //Shooter WIP
    public static final int turet_motor_id = 1111;//tbd
    public static final int hood_servo_id = 1111;//tbd
    public static final int flywheel_motor_id = 1111;//tbd
    public static final int turet_ticks_per_degree = 1;
    public static final int hood_ticks_per_degree = 1;
    public static final int flywheel_velocity_to_ticks = 1; 
    public static final int flywheel_percent = 1; 

    //xbox bindings
    //-2552707
    //-3372071
    
    public static final int left_x_axis = 0;
    public static final int left_y_axis = 1;
    public static final int right_x_axis = 4;
    public static final int right_y_axis = 5;

    public static final int right_j_x_axis = 0;
    public static final int right_j_y_axis = 1;

    public static final int a_button_num = 1;
    public static final int b_button_num = 2;
    public static final int x_button_num = 3;
    public static final int y_button_num = 4;

    
    public static final int left_pad_num = 270;
    public static final int right_pad_num = 90;
    public static final int up_pad_num = 0;
    public static final int down_pad_num = 180;
    public static int start_button_num = 8;
    public static int back_button_num = 7;  
    public static final int lb_button_num = 5;
    public static final int rb_button_num = 6;
    
    //robot spacific constants

    public static final double pos_units_per_degree = 72.857777778;
    public static final double pos_units_per_degree_rf = 72.8171171171;
   //thickness of wheels 41.9mm
   //61.25 cm front back
   //61.4 cm
   //85.5 cm
   //9.8552 cm wheel diameter
   //205
    public static final double pos_units_per_rotation = 16676.4;
    public static final double pos_units_per_meter = pos_units_per_rotation*(1/(Math.PI*0.098552));
    public static final double left_right_wheel_distance = 0.59305;
    public static final double max_pos_units = 6178;
    public static final double front_back_wheel_distance = 0.59155;
    public static final double[] center = {0,0};
    public static final double[] leftFrontCenter = {-left_right_wheel_distance/2,front_back_wheel_distance/2};
    public static final double[] leftBackCenter = {left_right_wheel_distance/2,front_back_wheel_distance/2};
    public static final double[] rightFrontCenter = {-left_right_wheel_distance/2,-front_back_wheel_distance/2};
    public static final double[] rightBackCenter = {left_right_wheel_distance/2,-front_back_wheel_distance/2};
    public static final double distance_wheel_center = RobotContainer.distance(center, leftFrontCenter);
    //native units per 0.1 seconds
    public static final double talon_velocity_per_ms = pos_units_per_meter/10;
  

    // control modifiers

    public static double max_rotate = 1;
    public static final double limeLightHeight = 0;
    public static final double ball_area = 0;

   
   
    public static  double velocityMax = 1;
    
    public static double max_motor_percent = 1;
    
    // state variables
    public static String field_oriented = "fo";
    public static String robot_oriented = "ro";
    
    public static String drive_mode = field_oriented;
  
    public static boolean in_auto = false;
    public static double[] camera_0_radial_constants;
    public static double[] camera_0_distortion_center;
    public static double[] camera_0_focal_lengths;
    public static double camera_0_angle_offset;
    public static double[] camera_1_radial_constants;
    public static double[] camera_1_distortion_center;
    public static double[] camera_1_focal_lengths;
    public static double camera_1_angle_offset;
    public static int camera_height;
    public static int cargo_diameter;
    public static double maximum_telescoping_velocity;
    public static double maximum_pivot_velocity;

    public static final double camera_angle = 0;
    public static final double hub_height = 0;




    
   
   
    




}
