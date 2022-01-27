package frc.robot.utils;

import javax.lang.model.type.MirroredTypeException;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MotorManager {
    private static final TalonSRX m_left = new TalonSRX(ActuatorMap.m_left);
    private static final TalonSRX s_left = new TalonSRX(ActuatorMap.s_left);
    private static final TalonSRX m_right = new TalonSRX(ActuatorMap.m_right);
    private static final TalonSRX s_right = new TalonSRX(ActuatorMap.s_right);
    
    public MotorManager() {
        
    }

    public static double getEncoderVelocity() {
        return m_right.getSelectedSensorVelocity();
    }
    public static double getEncoderPosition() {
        return m_right.getSelectedSensorPosition();
    }
    public static void resetEncoderPosition() {
     m_right.setSelectedSensorPosition(0);

    }

    public static void leftDrivePower(double power) {
        s_left.follow(m_left);
        s_right.follow(m_right);
        m_left.setInverted(true);
        m_left.set(ControlMode.PercentOutput, power);
    }

    public static void RightDrivePower(double power) {
        s_left.follow(m_left);
        s_right.follow(m_right);

        m_left.setInverted(true);
        m_right.set(ControlMode.PercentOutput, power);
    }
    public static void Stop() {
        m_right.set(ControlMode.Disabled, 1);
        m_left.set(ControlMode.Disabled, 1);

    }


}
