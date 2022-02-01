package frc.robot.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class Controls {
    private static XboxController controller = new XboxController(ActuatorMap.controller);
    private static Joystick leftJoy = new Joystick(ActuatorMap.leftJoystick);
    private static Joystick rightJoy = new Joystick(ActuatorMap.rightJoystick);

    public static double getLeftX() {
        return leftJoy.getX();
    }

    public static double getLeftY() {
        return leftJoy.getY();
    }

    public static double getRightX() {
        return rightJoy.getX();
    }

    public static double getRightY() {
        System.out.print("balls");
        return rightJoy.getY();
    }
    
    public static double getRightTwist() {
        return rightJoy.getTwist();
    
    }
}
