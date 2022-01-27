package frc.robot.auto;

import frc.robot.utils.LimeLightManager;
import frc.robot.utils.MotorManager;

public class LLFollow {
    public LLFollow() {
         
     System.out.println(LimeLightManager.getXPercent());
     double right = 0;
     double left = 0;
     if((int) LimeLightManager.getXPercent() > 5) {
      right = Math.abs(LimeLightManager.getXPercent()) * .01;
       left = -Math.abs(LimeLightManager.getXPercent()) * .01;
     }
     if((int) LimeLightManager.getXPercent() < 5) {
      right = -Math.abs(LimeLightManager.getXPercent()) * .01;
      left = Math.abs(LimeLightManager.getXPercent()) * .01;
     }

     if(Math.abs(LimeLightManager.getXPercent()) < 5) {
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
    if(LimeLightManager.getXPercent() == 0.0) {
      right = 0.0;
      left = 0.0;

   }
    MotorManager.RightDrivePower(right);
    MotorManager.leftDrivePower(left);
    }
}
