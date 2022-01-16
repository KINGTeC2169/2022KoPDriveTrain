package frc.robot.operationCommands;

public class DriveCommand {

    private final double leftX;
    private final double leftY;
    private final double rightX;
    private final double rightY;
    private final double rightTwist;

    DriveCommand(double leftX, double leftY, double rightX, double rightY, double rightTwist){
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;
        this.rightY = rightY;
        this.rightTwist = rightTwist;
    }
    public double getLeftX() {
        return leftX;
    }

    public double getLeftY() {
        return leftY;
    }

    public double getRightX() {
        return rightX;
    }

    public double getRightY() {
        return rightY;
    }
    public double getRightTwist() {
        return rightTwist;
    }
}