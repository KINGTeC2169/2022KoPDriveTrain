package frc.robot.operationCommands;

import frc.robot.utils.Controls;

public class CommandMachine {

    private final Controls controls;

    public CommandMachine(){
        controls = new Controls();
    }

    public DriveCommand generateDriveCommand(){
        return new DriveCommand(controls.getLeftJoyX(), controls.getLeftJoyY(), 
        controls.getRightJoyX(), controls.getRightJoyY(), controls.getRightJoyTwist());
    }
}
