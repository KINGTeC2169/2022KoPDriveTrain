package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.utils.LimeLightManager;

public class LLDistancePrint extends CommandBase {

    public LLDistancePrint() {
        System.out.println((94) / Math.tan(((45+LimeLightManager.getXPercent()) * Math.PI)/180));
    }
    
}
