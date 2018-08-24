package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.commands.UserClawCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawSubsystem extends Subsystem {
	
	CANTalon leftIntakeMotor;
	CANTalon rightIntakeMotor;
	CANTalon wristMotor;
	
	public ClawSubsystem() {
		leftIntakeMotor = new CANTalon(3);
		rightIntakeMotor = new CANTalon(4);
		wristMotor = new CANTalon(2);
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
