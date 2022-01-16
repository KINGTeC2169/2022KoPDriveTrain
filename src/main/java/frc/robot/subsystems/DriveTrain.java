package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.operationCommands.DriveCommand;
import frc.robot.utils.ActuatorMap;
import frc.robot.utils.MathManager;

public class DriveTrain {

    private final TalonSRX left = new TalonSRX(ActuatorMap.masterLeft);
    private final TalonSRX right = new TalonSRX(ActuatorMap.masterRight);
    

    public DriveTrain() {
        TalonSRX s_rightDrive = new TalonSRX(ActuatorMap.slaveRight);
        TalonSRX s_leftDrive = new TalonSRX(ActuatorMap.slaveLeft);
        s_leftDrive.follow(left);
        s_rightDrive.follow(right);
    
        //Inverts the left motors so 1 is forward
        left.setInverted(true);

    }

    public void handle(DriveCommand dCommand) {
        drive(dCommand);
    }

    private void drive(DriveCommand dCommand){

        double rightDriveValue =  MathManager.clamp(dCommand.getLeftY() - dCommand.getRightTwist(), -1.0, 1.0);
        double leftDriveValue =  MathManager.clamp(dCommand.getLeftY() + dCommand.getRightTwist(), -1.0, 1.0);
        rightDriveValue = MathManager.clamp(rightDriveValue - (dCommand.getRightX() / 2), -1.0, 1.0);
        leftDriveValue = MathManager.clamp(leftDriveValue + (dCommand.getRightX() / 2), -1.0, 1.0);

    
        right.set(ControlMode.PercentOutput, rightDriveValue);
        left.set(ControlMode.PercentOutput, leftDriveValue);
    }

    public void stop(){
        right.set(ControlMode.Disabled, 1);
        left.set(ControlMode.Disabled, 1);
    }

}