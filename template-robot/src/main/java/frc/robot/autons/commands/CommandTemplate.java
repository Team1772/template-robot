package frc.robot.autons.commands;

import edu.wpi.first.wpilibj.command.Command;

public class CommandTemplate extends Command {
  public CommandTemplate() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    // Use setTimeout() here to define specific run time in seconds for the command
    // setTimeout(time);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
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
