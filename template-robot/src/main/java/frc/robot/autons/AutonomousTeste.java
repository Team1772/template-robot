package frc.robot.autons;
import frc.robot.Robot;
import frc.robot.autons.commands.*;
import frc.robot.autons.commands.groups.*;

public class AutonomousTeste extends CommandTypes {

	public AutonomousTeste() {
		super(Robot.driver);

		addStep(new PullCargo(), 5); //Time in seconds

		addStep(new PushCargo(), 5);

		addStep(new Stop());
	}

}