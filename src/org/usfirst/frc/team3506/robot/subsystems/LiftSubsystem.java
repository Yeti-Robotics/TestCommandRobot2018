package org.usfirst.frc.team3506.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {
	
	Spark motor;

    public LiftSubsystem() {
		motor = new Spark(5);
		motor.setInverted(true);
	}

    public void initDefaultCommand() {
        
    }
    
    public void lift(double speed) {
    		motor.set(speed);
    }
}

