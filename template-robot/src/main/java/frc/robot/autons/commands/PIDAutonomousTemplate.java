package frc.robot.autons.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PIDBase.Tolerance;
import edu.wpi.first.wpilibj.command.Command;
import frc.core.util.PID.Gains;
import frc.core.util.PID.PIDTalonSRX;
import frc.robot.Robot;
import frc.robot.subsystems.Driver;

public class PIDAutonomousTemplate extends Command {
    Encoder enc;
    Gains gains;
    TalonSRX motor;
    TalonSRX follower;
    Tolerance tolerance;
    PIDTalonSRX pid;
    XboxController pilot;

    public PIDAutonomousTemplate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driver);
    }

    @Override
    protected void initialize() {
        pilot = new XboxController(0);

        motor = new TalonSRX(0);
        follower = new TalonSRX(1);

        gains = new Gains(0, 0, 0, 0, 0, 0);
        pid = new PIDTalonSRX(motor, follower, 0, 0, true, 0, 0, 0, 0, true, gains);
    }

    @Override
    protected void execute() {
        if (pilot.getAButton()){
            pid.setPostion(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
