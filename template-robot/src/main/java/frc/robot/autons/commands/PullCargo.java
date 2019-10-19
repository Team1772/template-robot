package frc.robot.autons.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PullCargo extends Command {
  public PullCargo() {
    requires(Robot.cargoIntake);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.cargoIntake.pull(0.1);
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
