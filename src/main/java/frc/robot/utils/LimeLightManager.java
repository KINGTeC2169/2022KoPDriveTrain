package frc.robot.utils;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimeLightManager {
    
    private static NetworkTable limeLight = NetworkTableInstance.getDefault().getTable("limelight");

    public static double getXPercent() {
        return limeLight.getEntry("tx").getDouble(0);
        
    }
}
