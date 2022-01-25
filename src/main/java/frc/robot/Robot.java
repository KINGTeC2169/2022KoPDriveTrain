// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.utils.Controls;
import frc.robot.utils.MotorManager;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  

  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {
    NetworkTable limeLight = NetworkTableInstance.getDefault().getTable("limelight");
     double xOffset = limeLight.getEntry("tx").getDouble(500);
     System.out.println(xOffset);
     double right = 0;
     double left = 0;
     if((int) xOffset > 5) {
      right = Math.abs(xOffset) * .01;
       left = -Math.abs(xOffset) * .01;
     }
     if((int) xOffset < 5) {
      right = -Math.abs(xOffset) * .01;
      left = Math.abs(xOffset) * .01;
     }

     if(Math.abs(xOffset) < 5) {
      left = -.5;
      right = -.5;
    }
    if(left < .2 && left > 0) {
      left = .2;
    }
    if(right < .2 && right > 0) {
      right = .2;
    }
    if(left < -.2 && left < 0) {
      left = -.2;
    }
    if(right < -.2 && right < 0) {
      right = -.2;
    }
    if(xOffset == 0.0) {
      right = 0.0;
      left = 0.0;

   }
    MotorManager.RightDrivePower(right);
    MotorManager.leftDrivePower(left);
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    NetworkTable limeLight = NetworkTableInstance.getDefault().getTable("limelight");
    double xOffset = limeLight.getEntry("ty").getDouble(0);
    System.out.println((94) / Math.tan(((45+xOffset) * Math.PI)/180));
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() { 
  }

  @Override
  public void testInit() {
    CameraServer.startAutomaticCapture();
    NetworkTable limeLight = NetworkTableInstance.getDefault().getTable("limelight");
  }

  @Override
  public void testPeriodic() {
    
    double xOffset = limeLight.getEntry("tx").getDouble(0);

    if(Controls.getLeftX() != 0) {
          MotorManager.leftDrivePower(-Controls.getLeftX());
          MotorManager.RightDrivePower(Controls.getLeftX());
    } else {


        System.out.println(xOffset);
        if(xOffset < 4 && xOffset > -4) {
          System.out.println("balls 4");
          MotorManager.Stop();
        }
        if(xOffset < -5) {
          MotorManager.leftDrivePower(-xOffset * .01);
          MotorManager.RightDrivePower(xOffset * .01);
        }
        if(xOffset > 5) {
          MotorManager.leftDrivePower(-xOffset * .01);
          MotorManager.RightDrivePower(xOffset * .01);
        }
        




    }

  }
}
