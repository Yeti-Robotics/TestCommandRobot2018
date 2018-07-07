package org.usfirst.frc.team3506.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestCommandGroup extends CommandGroup {

    public TestCommandGroup() {
        addSequential(new UniversalTimedDriveCommand(-0.7, -0.7, 3)); // drive straight
        addParallel(new UserGrabberCommand(true));
        addParallel(new UserIntakeCommand(0.5), 3);
        addSequential(new UniversalTimedDriveCommand(-0.7, 0.7, 3)); // turn right
        addParallel(new UserGrabberCommand(false));
        addSequential(new UniversalTimedDriveCommand(-0.7, -0.7, 3)); // drive straight
    }
}
