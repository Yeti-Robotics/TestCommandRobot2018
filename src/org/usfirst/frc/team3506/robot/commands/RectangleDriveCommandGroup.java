package org.usfirst.frc.team3506.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RectangleDriveCommandGroup extends CommandGroup {

    public RectangleDriveCommandGroup() {
        /*
         * drive forward 5ft
         * turn 90 degrees
         * repeat 4 times
         */
        for (int i = 0; i < 4; i++) {
            addSequential(new DistanceDriveCommand(-0.5, -0.5, 60, 60));
            addSequential(new AngleTurnCommand(0.5, 90));
        }
    }
}
