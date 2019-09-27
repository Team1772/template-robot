package frc.robot.routines;

import frc.core.util.XboxController;
import frc.robot.Robot;

public enum Teleop {
    INSTANCE;

    private XboxController driver, operator;

    public void init() {
        int usbPortDriver = 0, usbPortOperator = 1;
        driver = new XboxController(usbPortDriver);
        operator = new XboxController(usbPortOperator);
        Robot.arm.enable(true);
    }

    public void periodic() {

        if (operator.getButtonY())
            Robot.arm.enable(true);
        else if (operator.getButtonA())
            Robot.arm.enable(false);

        Robot.hatchIntake.enable(operator.getButtonX());

        if (operator.getButtonR1() && operator.getButtonL1())
            Robot.cargoIntake.pull(0.15);
        else if (operator.getButtonL1())
            Robot.cargoIntake.pull(0.5);
        else if (operator.getButtonR1())
            Robot.cargoIntake.push(1);
        else
            Robot.cargoIntake.stop();

        if (driver.getButtonL1())
            Robot.driver.arcadeDrive(-driver.getAxisLeftY(), driver.getAxisRightX());
        else
            Robot.driver.arcadeDrive(driver.getAxisLeftY(), driver.getAxisRightX());

    }
}
