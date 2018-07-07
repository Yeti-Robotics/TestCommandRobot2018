package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.commands.UserClawCommand;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawSubsystem extends Subsystem {
	
	Spark leftIntakeMotor;
	Spark rightIntakeMotor;
	Spark wristMotor;
	
	public ClawSubsystem() {
		leftIntakeMotor = new Spark(3);
		rightIntakeMotor = new Spark(4);
		wristMotor = new Spark(2);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UserClawCommand());
	}
	
	public void intakeMotors(double speed) {
		leftIntakeMotor.set(speed);
		rightIntakeMotor.set(speed);
	}
	
	public void wristMotor(double speed) {
		wristMotor.set(speed);
	}
}
