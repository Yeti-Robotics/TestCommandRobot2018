package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.commands.UserDriveCommand;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DrivetrainSubsystem extends PIDSubsystem {

    Spark leftFrontMotor;
    Spark leftRearMotor;
    Spark leftMiddleMotor;
    Spark rightFrontMotor;
    Spark rightRearMotor;
    Spark rightMiddleMotor;
    Encoder leftEncoder;
    Encoder rightEncoder;
    int wheelDiameter = 6;
    int pulsesPerRev = 2048;
    double distancePerPulse = Math.PI * wheelDiameter / pulsesPerRev;
    ADXRS450_Gyro gyro;
    
    double pulsesPer360 = 11280;
    double degreePerPulse = 360.0 / pulsesPer360;

    public DrivetrainSubsystem() {
        super(1, 0.01, 0.001);
        leftFrontMotor = new Spark(0);
        leftRearMotor = new Spark(7);
        leftRearMotor.setInverted(true);
        leftMiddleMotor = new Spark(8);
        leftMiddleMotor.setInverted(true);
        rightFrontMotor = new Spark(1);
        rightFrontMotor.setInverted(true);
        rightRearMotor = new Spark(9);
        rightMiddleMotor = new Spark(10);
        gyro = new ADXRS450_Gyro();
        
        leftEncoder = new Encoder(1, 0, true, EncodingType.k4X);
        rightEncoder = new Encoder(2, 3, true, EncodingType.k4X);
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
    
    public double getLeftEncoderDistance() {
        return leftEncoder.getDistance();
    }
    
    public double getLeftEndcoderPulses() {
        return leftEncoder.get();
    }
    
    public double getRightEndcoderPulses() {
        return rightEncoder.get();
    }
    
    public double getRightEncoderDistance() {
        return rightEncoder.getDistance();
    }
    
    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }
    
    public void setEncoderDistance() {
        leftEncoder.setDistancePerPulse(distancePerPulse);
        rightEncoder.setDistancePerPulse(distancePerPulse);
    }
    
    public void setEncoderAngle() {
        leftEncoder.setDistancePerPulse(degreePerPulse);
        rightEncoder.setDistancePerPulse(degreePerPulse);
    }
    
    public double getAngleDegrees() {
        return gyro.getAngle();
    }
    
    public void resetGyro() {
        gyro.reset();
    }

    @Override
    protected double returnPIDInput() {
        return (getLeftEncoderDistance() + getRightEncoderDistance()) / 2;
       
    }

    @Override
    protected void usePIDOutput(double output) {
       drive(output, output);
    }
}


