/*----------------------------------------------------------------------------*/
  /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team687;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.nerdherd.lib.drivetrain.singlespeed.Drivetrain;
import com.nerdherd.lib.misc.AutoChooser;
import com.nerdherd.robot.OI;
import com.team687.subsystems.Drive;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 */
public class Robot extends TimedRobot {

	public static final String kDate = "2019_01_29_";

	public static Drive drive;
	// public static SingleMotorTalonSRX leftKickerWheel, rightKickerWheel, chevalRamp;
	public static OI oi;
	public static AutoChooser chooser;

	@Override
	public void robotInit() {
		chooser = new AutoChooser();
		// nav = new AHRS(SPI.Port.kMXP);
		drive = new Drive();


		// leftKickerWheel = new SingleMotorTalonSRX(RobotMap.kLeftKickerWheelTalonID, "Left Kicker Wheel", true, true);
		// leftKickerWheel.configPIDF(SuperstructureConstants.kLeftKickerWheelP, 0, 0, 0);

		// rightKickerWheel = new SingleMotorTalonSRX(RobotMap.kRightKickerWheelTalonID, "Right Kicker Wheel", false, false);
		// rightKickerWheel.configPIDF(SuperstructureConstants.kRightKickerWheelP, 0, 0, 0);

		// chevalRamp = new SingleMotorTalonSRX(RobotMap.kChevalRampTalonID, "Cheval Ramp", true, true);
		// chevalRamp.configPIDF(SuperstructureConstants.kChevalRampP, 0, 0, 0);
		
		oi = new OI(); 
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
    public void testPeriodic() {
    }
}
