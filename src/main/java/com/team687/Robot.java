/*----------------------------------------------------------------------------*/
  /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team687;

import com.team687.subsystems.Drive;
import com.team687.subsystems.Jevois;
import com.team687.subsystems.Sensor;
import com.team687.utilities.AutoChooser;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 */
public class Robot extends TimedRobot {
	
	public static final String kDate = "Dope_2019_01_26_";

	public static Drive drive;
	public static Jevois leftJevois;
	// public static Jevois rightJevois;
	public static Subsystem livestream;
	public static DriverStation ds;
	public static AutoChooser autoChooser;
	public static Sensor sensor;

	public static OI oi;

	@Override
	public void robotInit() {
	//	autoChooser = new AutoChooser();
		leftJevois = new Jevois(115200, SerialPort.Port.kUSB);
		// rightJevois = new Jevois(115200, SerialPort.Port.kUSB);
		sensor = new Sensor();
		// CameraServer.getInstance().startAutomaticCapture();

	    drive = new Drive();
	    oi = new OI();
		ds = DriverStation.getInstance();
		
	}

	@Override
	public void disabledInit() {
		leftJevois.stopLog();
		// rightJevois.stopLog();

		leftJevois.enableStream();
		// rightJevois.enableStream();

		
	}

	@Override
	public void disabledPeriodic() {
		leftJevois.reportToSmartDashboard();
		
		sensor.reportToSmartDashboard();

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
		leftJevois.startLog();
		// rightJevois.startLog();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		leftJevois.reportToSmartDashboard();
		// rightJevois.reportToSmartDashboard();
		sensor.reportToSmartDashboard();

		leftJevois.logToCSV();
		// rightJevois.logToCSV();
		// System.out.println(SerialPort.Port.values());
		// drive.reportToSmartDashboard();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
    public void testPeriodic() {
    }
}
