package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroTurnCommand2 extends Command {

    private double power, angle;

    public GyroTurnCommand2(double power, double angle) {
		super();
		this.power = power;
		this.angle = angle;
		requires(Robot.drivetrainSubsystem);
	}

	// Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.drivetrainSubsystem.drive(power, -power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(angle) <= Math.abs(Robot.drivetrainSubsystem.getAngleDegrees());
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
