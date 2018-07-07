package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.commands.UserDriveCommand;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DrivetrainSubsystem extends Subsystem {

	Spark leftFrontMotor;
	Spark leftRearMotor;
	Spark leftMiddleMotor;
	Spark rightFrontMotor;
	Spark rightRearMotor;
	Spark rightMiddleMotor;

	public DrivetrainSubsystem() {
		leftFrontMotor = new Spark(0);
		leftFrontMotor.setInverted(true);
		leftRearMotor = new Spark(7);
		leftRearMotor.setInverted(true);
		leftMiddleMotor = new Spark(8);
		leftMiddleMotor.setInverted(true);
		rightFrontMotor = new Spark(1);
		rightRearMotor = new Spark(9);
		rightMiddleMotor = new Spark(10);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UserDriveCommand());
	}
	
	public void drive(double leftSpeed, double rightSpeed) {
		leftFrontMotor.set(leftSpeed);
		leftRearMotor.set(leftSpeed);
		leftMiddleMotor.set(leftSpeed);
		rightFrontMotor.set(rightSpeed);
		rightRearMotor.set(rightSpeed);
		rightMiddleMotor.set(rightSpeed);
	}
}
