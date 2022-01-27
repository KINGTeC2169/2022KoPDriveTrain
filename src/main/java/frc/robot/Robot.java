// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
import java.lang.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.auto.LLDistancePrint;
import frc.robot.auto.LLFollow;
import frc.robot.utils.Controls;
import frc.robot.utils.LimeLightManager;
import frc.robot.utils.MotorManager;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  
  //SendableChooser<Object> m_chooser = new SendableChooser<>();
  @Override
  public void robotInit() {
    //private final Command jeffery = new LLDistancePrint();
   // m_chooser.setDefaultOption("banana Pepper", new LLDistancePrint());
    //m_chooser.addOption("sllab",new LLDistancePrint());
    //SmartDashboard.putData(m_chooser);
  }

  @Override
  public void robotPeriodic() {}

  SendableChooser chooser;
  @Override
  public void autonomousInit() {
    chooser = new SendableChooser<Command>();
  }

  @Override
  public void autonomousPeriodic() {
    chooser.addOption("cat", new LLDistancePrint());
    //if(m_chooser.getSelected().equals("sllab")) {
      
    //}
  }

  DigitalInput balls;
  @Override
  public void teleopInit() {
    balls = new DigitalInput(3);
    CameraServer.startAutomaticCapture();
    MotorManager.resetEncoderPosition();
  }

  double prevPosition;
  double prevTime;
  double currentPosition;
  double currentTime;
  
  @Override
  public void teleopPeriodic() {
    //DigitalOutput balls = new DigitalOutput(0);\
    //Rev Bore encoder divide by 22.76 to get percentage and 8192 SPR
    //Falcon 500 divide by 5.69 to get percentage and 2048 SPR
    prevPosition = MotorManager.getEncoderPosition();
    prevTime = System.currentTimeMillis();
  
    currentPosition = MotorManager.getEncoderPosition();
    currentTime = System.currentTimeMillis();

    currentPosition -= prevPosition;
    currentPosition /= 8192;
    currentTime -= prevTime;
    currentTime /= 60000;
    //System.out.println(currentTime);
  System.out.println(600 * MotorManager.getEncoderVelocity() / 8192);



    //System.out.println((94) / Math.tan(((45+LimeLightManager.getXPercent()) * Math.PI)/180));
   // DriveTrain.Drive();

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() { 
  }


  @Override
  public void testInit() {
    CameraServer.startAutomaticCapture();
  }

  @Override
  public void testPeriodic() {

    if(Math.abs(Controls.getLeftX()) > .1 || Math.abs(Controls.getLeftY()) >  .1) {
          MotorManager.leftDrivePower(Controls.getLeftY() - Controls.getLeftX());
          MotorManager.RightDrivePower(Controls.getLeftY() + Controls.getLeftX());
    } else {


        System.out.println(LimeLightManager.getXPercent());
        if(LimeLightManager.getXPercent() < 2 && LimeLightManager.getXPercent() > -2) {
          MotorManager.Stop();
        }
        if(LimeLightManager.getXPercent() < -2.5) {
          MotorManager.leftDrivePower(-LimeLightManager.getXPercent() * .025);
          MotorManager.RightDrivePower(LimeLightManager.getXPercent() * .025);
        }
        if(LimeLightManager.getXPercent() > 2.5) {
          MotorManager.leftDrivePower(-LimeLightManager.getXPercent() * .025);
          MotorManager.RightDrivePower(LimeLightManager.getXPercent() * .025);
        }
        




    }

  }
}
