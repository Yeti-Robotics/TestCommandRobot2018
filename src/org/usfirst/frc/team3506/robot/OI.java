/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.AngleTurnCommand;
import org.usfirst.frc.team3506.robot.commands.LiftCommand;
import org.usfirst.frc.team3506.robot.commands.RectangleDriveCommandGroup;
import org.usfirst.frc.team3506.robot.commands.TestCommandGroup;
import org.usfirst.frc.team3506.robot.commands.UniversalTimedDriveCommand;
import org.usfirst.frc.team3506.robot.commands.UserGrabberCommand;
import org.usfirst.frc.team3506.robot.commands.UserIntakeCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick leftJoystick;
	public Joystick rightJoystick;
	public Joystick clawJoystick;
	
	public OI() {
		leftJoystick = new Joystick(0);
		rightJoystick = new Joystick(1);
		clawJoystick = new Joystick(2);
		
		JoystickButton left8 = new JoystickButton(leftJoystick, 8);
		JoystickButton left9 = new JoystickButton(leftJoystick, 9);
		JoystickButton left7 = new JoystickButton(leftJoystick, 7);
		JoystickButton left11 = new JoystickButton(leftJoystick, 11);
		JoystickButton left10 = new JoystickButton(leftJoystick, 10);
		JoystickButton claw7 = new JoystickButton(clawJoystick, 7);
		JoystickButton claw8 = new JoystickButton(clawJoystick, 8);
		JoystickButton claw9 = new JoystickButton(clawJoystick, 9);
		JoystickButton claw10 = new JoystickButton(clawJoystick, 10);
		JoystickButton right6 = new JoystickButton(rightJoystick, 6);
		JoystickButton right7 = new JoystickButton(rightJoystick, 7);
		JoystickButton claw2 = new JoystickButton(clawJoystick, 2);
		JoystickButton claw3 = new JoystickButton(clawJoystick, 3);
		JoystickButton claw4 = new JoystickButton(clawJoystick, 4);
		
		left8.whenPressed(new UniversalTimedDriveCommand(0.4, -0.4, 3));
		left9.whenPressed(new UniversalTimedDriveCommand(-0.7, 0.7, 3));
		left7.whenPressed(new TestCommandGroup());
		left11.whileHeld(new UserIntakeCommand(0.5));
		left10.whileHeld(new UserIntakeCommand(-0.5));
		claw7.whenPressed(new UserGrabberCommand(true));
		claw8.whenPressed(new UserGrabberCommand(false));
		claw9.whileHeld(new LiftCommand(-0.5));
		claw10.whileHeld(new LiftCommand(0.5));
//		right6.whenPressed(new DistanceDriveCommand(-0.7, 12));
//		right7.whenPressed(new DistanceDriveCommand(0.7, 12));
		claw2.whenPressed(new AngleTurnCommand(0.5, -90));
		claw3.whenPressed(new AngleTurnCommand(0.5, 90));
		claw4.whenPressed(new RectangleDriveCommandGroup());
	}
}
