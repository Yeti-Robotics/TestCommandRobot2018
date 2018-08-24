package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotInput;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PlayRecordingCommand extends Command {
	private int count;

    public PlayRecordingCommand() {
        requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		Robot.recording = false;
    		Robot.playing = true;
    		count = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if (Robot.inputs.size() > count) {
    			RobotInput input = Robot.inputs.get(count);
    			Robot.drivetrainSubsystem.drive(input.leftY, input.rightY);
    		}
    		count++;
    		SmartDashboard.putNumber("Play Count", count);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return count >= Robot.inputs.size();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.drivetrainSubsystem.drive(0, 0);
    		Robot.playing = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
