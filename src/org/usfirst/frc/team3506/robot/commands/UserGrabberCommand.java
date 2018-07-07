package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserGrabberCommand extends Command {
	
	boolean open;

    public UserGrabberCommand(boolean open) {
        requires(Robot.grabberSubsytem);
        this.open = open;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if (open) {
    			Robot.grabberSubsytem.openGrabber();
    		} else {
    			Robot.grabberSubsytem.closeGrabber();
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}