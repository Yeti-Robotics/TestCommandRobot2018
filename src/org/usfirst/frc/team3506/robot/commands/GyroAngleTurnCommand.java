package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroAngleTurnCommand extends Command {

    private double power, angle;

    public GyroAngleTurnCommand(double power, double angle) {
        this.power = power;
        this.angle = angle;
        requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (angle < 0) {
            Robot.drivetrainSubsystem.drive(power, -power);
        } else {
            Robot.drivetrainSubsystem.drive(-power, power);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.drivetrainSubsystem.getGyro().getAngle()) >= angle;
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
