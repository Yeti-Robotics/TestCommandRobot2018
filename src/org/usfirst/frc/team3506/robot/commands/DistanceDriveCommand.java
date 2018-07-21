package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DistanceDriveCommand extends Command {

	double leftSpeed, rightSpeed;
	double leftInches, rightInches;

	public DistanceDriveCommand(double leftSpeed, double rightSpeed, 
			double leftInches, double rightInches) {
		super();
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
		this.leftInches = leftInches;
		this.rightInches = rightInches;
		requires(Robot.drivetrainSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drivetrainSubsystem.resetEncoders();
		Robot.drivetrainSubsystem.setEncoderDistance();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrainSubsystem.drive(leftSpeed, rightSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		double leftDistance = Robot.drivetrainSubsystem.getLeftEncoderDistance();
		double rightDistance = Robot.drivetrainSubsystem.getRightEncoderDistance();
		if (Math.abs(leftDistance) < Math.abs(leftInches)
				&& Math.abs(rightDistance) < Math.abs(rightInches)) {
			return false;
		} else {
			return true;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrainSubsystem.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
