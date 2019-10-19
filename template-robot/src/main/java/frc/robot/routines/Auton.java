package frc.robot.routines;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.autons.AutonomousTeste;

public enum Auton {
    INSTANCE;

    private ArrayList<Command> autons;
    private Command autonCommand;

    public void init(){
        autons = new ArrayList<>();

        autons.add(new AutonomousTeste());
        /*Add autons like this:
        autons.add(new CenterGear());
        */
    }

    public void periodic(){
        Scheduler.getInstance().run();
    }

    public void start(){
        autonCommand = getAutonSelected();

        if(autonCommand != null)
            autonCommand.start();
    }

    public void cancel(){
        if(autonCommand != null)
            autonCommand.cancel();
    }

    private Command getAutonSelected(){
        int number = (int)SmartDashboard.getNumber("Auto mode", 0);

        return autons.size() > number ? autons.get(number) : autons.get(0);
    }

}
