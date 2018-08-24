package org.usfirst.frc.team3506.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {
	
    CANTalon leftMotor;
    CANTalon rightMotor;

    public LiftSubsystem() {
        leftMotor = new CANTalon(5);
		rightMotor = new CANTalon(6);
		leftMotor.setInverted(true);
		rightMotor.setInverted(true);
	}

    public void initDefaultCommand() {
        
    }
    
    public void lift(double speed) {
        leftMotor.set(speed);
    	rightMotor.set(speed);
    }
}

