package org.usfirst.frc.team3506.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestCommandGroup extends CommandGroup {

    public TestCommandGroup() {
        addParallel(new UserGrabberCommand(true));
        addSequential(new DistanceDriveCommand(-0.6, -0.6, 60, 60));
        addParallel(new UserGrabberCommand(false));
        addSequential(new DistanceDriveCommand(-0.6, 0.6, 24, 24));
        addSequential(new DistanceDriveCommand(-0.6, -0.6, 60, 60));
    }
}
