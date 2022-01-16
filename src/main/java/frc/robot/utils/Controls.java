package frc.robot.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class Controls {

    private static final int leftJoyPort = 1;
    private static final int rightJoyPort = 2;
    private static final int controllerPort = 0;

    private final Joystick leftJoy;
    private final Joystick rightJoy;
    private final XboxController controller;

    public Controls() {
        leftJoy = new Joystick(leftJoyPort);
        rightJoy = new Joystick(rightJoyPort);
        controller = new XboxController(controllerPort);
    }

    public double getLeftJoyX(){
        return leftJoy.getX();
    }

    public double getLeftJoyY() {
        return leftJoy.getY();
    }

    public double getRightJoyX(){
        return rightJoy.getX();
    }

    public double getRightJoyY() {
        return rightJoy.getY();
    }

    public double getRightJoyTwist() {
        return rightJoy.getTwist();
    }
}
