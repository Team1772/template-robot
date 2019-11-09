package frc.robot.autons.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PushCargo extends Command {
    Timer timer;

  public PushCargo() {
    requires(Robot.cargoIntake);
    setTimeout(5);
  }

  @Override
  protected void initialize() {
      timer = new Timer();
      timer.start();
      timer.reset();
  }

  @Override
  protected void execute() {
    Robot.cargoIntake.push(0.1);
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
    Robot.cargoIntake.stop();
  }

  @Override
  protected void interrupted() {
  }
}
