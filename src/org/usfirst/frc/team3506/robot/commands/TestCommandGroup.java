package org.usfirst.frc.team3506.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestCommandGroup extends CommandGroup {

	public TestCommandGroup() {
		addSequential(new DistanceDriveCommand(-0.5, -0.5, 120, 120));
		addSequential(new DistanceDriveCommand(0.4, -0.4, 60, 60));
		addSequential(new DistanceDriveCommand(-0.5, -0.5, 120, 120));
	}
}
