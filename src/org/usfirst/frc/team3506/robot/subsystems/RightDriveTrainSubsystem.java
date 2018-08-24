package org.usfirst.frc.team3506.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class RightDriveTrainSubsystem extends PIDSubsystem {

    Spark rightFrontMotor;
    Spark rightRearMotor;
    Spark rightMiddleMotor;
    Encoder rightEncoder;
    
    // Initialize your subsystem here
    public RightDriveTrainSubsystem() {
        super(1, 0.01, 0.001);
        rightFrontMotor = new Spark(1);
        rightFrontMotor.setInverted(true);
        rightRearMotor = new Spark(9);
        rightMiddleMotor = new Spark(10);

        rightEncoder = new Encoder(2, 3, true, EncodingType.k4X);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(double leftSpeed, double rightSpeed) {
        rightFrontMotor.set(rightSpeed);
        rightRearMotor.set(rightSpeed);
        rightMiddleMotor.set(rightSpeed);
    }

    public double getRightEndcoderPulses() {
        return rightEncoder.get();
    }
    
    public void resetEncoders() {
        rightEncoder.reset();
    }
 
       protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return getRightEndcoderPulses();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        drive(output, output);
    }
}
