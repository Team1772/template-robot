package frc.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.autons.commands.*;
import frc.robot.autons.commands.groups.*;

public class AutonomousTeste extends CommandGroup {

	public AutonomousTeste() {
		addSequential(new PullCargo());

		addSequential(new PushCargo());

		addSequential(new Stop());
	}

}