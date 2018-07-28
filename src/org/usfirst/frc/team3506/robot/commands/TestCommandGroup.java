package org.usfirst.frc.team3506.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestCommandGroup extends CommandGroup {

	public TestCommandGroup() {
		addSequential(new GyroTurnCommand2(-0.35, 60));
		addSequential(new DistanceDriveCommand(-0.5, -0.5, 120, 120));

		for (int i = 0; i < 2; i++) {
			addSequential(new GyroTurnCommand2(-0.35, 120));
			addSequential(new DistanceDriveCommand(-0.5, -0.5, 120, 120));
		}

		addSequential(new GyroTurnCommand2(-0.35, 60));
	}
}
