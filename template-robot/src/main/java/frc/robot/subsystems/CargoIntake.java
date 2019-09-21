package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;

public class CargoIntake extends Subsystem {

    VictorSP rollIntake;

    public CargoIntake() {
        rollIntake = new VictorSP(0);
    }

    public void pull(double speed) {
        rollIntake.set(speed);
    }

    public void push(double speed) {
        rollIntake.set(-speed);
    }

    public void stop() {
        rollIntake.set(0);
    }

    @Override
    protected void initDefaultCommand() {
    }
}