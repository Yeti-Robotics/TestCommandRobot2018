package org.usfirst.frc.team3506.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GrabberSubsytem extends Subsystem {
	
	DoubleSolenoid piston;
	
	public GrabberSubsytem() {
		piston = new DoubleSolenoid(0, 1);
	}

    public void initDefaultCommand() {
        
    }
    
    public void openGrabber() {
    		piston.set(Value.kForward);
    }
    
    public void closeGrabber() {
    		piston.set(Value.kReverse);
    }
}

