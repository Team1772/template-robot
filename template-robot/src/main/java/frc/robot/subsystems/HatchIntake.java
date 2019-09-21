package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

public class HatchIntake extends Subsystem {

    Solenoid hatchIntake;

    public HatchIntake() {
        hatchIntake = new Solenoid(0);
    }

    public void enable(boolean activate) {
        hatchIntake.set(activate);
    }

    @Override
    protected void initDefaultCommand() { }
}