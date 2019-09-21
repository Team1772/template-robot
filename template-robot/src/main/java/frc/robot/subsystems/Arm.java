package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Arm extends Subsystem {

    DoubleSolenoid arm;

    public Arm() {
        arm = new DoubleSolenoid(0, 1);
    }

    public void enable(boolean activate) {
        arm.set(activate ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    }

    @Override
    protected void initDefaultCommand() { }

}