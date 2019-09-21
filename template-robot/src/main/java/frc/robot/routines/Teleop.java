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
    }

    public void periodic() {
        updateToggleArm();

        Robot.arm.enable(toggleOnArm);

        Robot.driver.arcadeDrive(driver.getAxisLeftY(), driver.getAxisRightX());

        Robot.hatchIntake.enable(operator.getButtonX());

        if (operator.getButtonR1())
            Robot.cargoIntake.pull(0.1);
        else if (operator.getButtonL1())
            Robot.cargoIntake.push(0.6);
        else
            Robot.cargoIntake.stop();

        if(driver.getButtonL1())
            invertDriver();

    }

    private boolean toggleOnArm = false;

    public void updateToggleArm() {
        boolean togglePressedArm = false;

        if (operator.getButtonA()) {
            if (!togglePressedArm) {
                toggleOnArm = !toggleOnArm;
                togglePressedArm = true;
            }
        } else {
            togglePressedArm = false;
        }
    }

    public void invertDriver() {
        Robot.driver.arcadeDrive(-(driver.getAxisLeftY()), -(driver.getAxisLeftX()));
    }
}
