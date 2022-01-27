package frc.robot.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class Controls {
    private static XboxController controller = new XboxController(ActuatorMap.controller);
    private static Joystick leftJoy = new Joystick(ActuatorMap.leftJoystick);
    private static Joystick rightJoy = new Joystick(ActuatorMap.rightJoystick);

    public static double getLeftX() {
        return controller.getLeftX();
    }

    public static double getLeftY() {
        return controller.getLeftY();
    }

    public static double getRightX() {
        return controller.getRightX();
    }

    public static double getRightY() {
        System.out.print("balls");
        return controller.getRightY();
    }
    
    public static double getRightTwist() {
        return controller.getLeftTriggerAxis();
    
    }
}
