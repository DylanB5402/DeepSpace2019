package com.team687;

import com.nerdherd.lib.oi.DefaultOI;
// import com.team687.commands.led.LedBlue;
// import com.team687.commands.led.LedOff;
// import com.team687.commands.led.LightGreen;
import com.team687.commands.vision.DriveAtHeading;
import com.team687.commands.vision.LiveTargetTrack;
import com.team687.commands.vision.TurnAndApproach;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 */
public class OI extends DefaultOI {

	JoystickButton ping, disableStream, enableStream, liveTargetTrack, stopDrive, lineFollow, driveAtHeading, TurnAndApproach;

	public OI() {
		super();

		//liveTargetTrack = new JoystickButton(super.driveJoyRight, 1);
		// liveTargetTrack.whileHeld(new LiveTargetTrack(0.0139));


		// TurnAndApproach = new JoystickButton(super.driveJoyRight, 1);
		// TurnAndApproach.whileHeld(new TurnAndApproach());

		// SmartDashboard.putData("TurnAndApproach", new TurnAndApproach());
		// SmartDashboard.putData("DriveAtHeading", new DriveAtHeading(.0139, .0000354));
		// SmartDashboard.putData("LiveTargetTrack", new LiveTargetTrack(0.0139));

		// SmartDashboard.putData("blue", new LedBlue());
		// SmartDashboard.putData("off", new LedOff());
		// SmartDashboard.putData("green", new LightGreen());
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											
		//disableStream = new JoystickButton(driveJoyLeft,2);
		//disableStream.whenPressed(new DisableStream());
		
		// enableStream = new JoystickButton(driveJoyLeft,3);
		// enableStream.whenPressed(new EnableStream());
			

	}

	@Override
	public double getDriveJoyRightY() {
		return super.driveJoyRight.getY();
	}
}