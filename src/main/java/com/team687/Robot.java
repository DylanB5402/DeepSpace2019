/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team687;

import com.nerdherd.lib.logging.LoggableLambda;
import com.nerdherd.lib.logging.NerdyBadlog;
import com.nerdherd.lib.misc.AutoChooser;
import com.nerdherd.lib.motor.dual.DualMotorIntake;
import com.nerdherd.lib.motor.single.SingleMotorVictorSPX;
import com.nerdherd.lib.motor.single.mechanisms.SingleMotorArm;
import com.nerdherd.lib.motor.single.mechanisms.SingleMotorElevator;
import com.nerdherd.lib.pneumatics.Piston;
import com.nerdherd.lib.sensor.HallSensor;
import com.team687.subsystems.Arm;
import com.team687.subsystems.Drive;
import com.team687.subsystems.Elevator;
import com.team687.subsystems.Jevois;
import com.team687.subsystems.Sensor;
import com.team687.subsystems.Superstructure;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 */
public class Robot extends TimedRobot {

	public static final String kDate = "2019_01_29_";

	public static Drive drive;
	public static Subsystem livestream;
	public static DriverStation ds;
	public static AutoChooser chooser;
	public static SingleMotorElevator elevator;
	public static SingleMotorArm arm;
	// public static SingleMotorTalonSRX chevalRamp;
	public static DualMotorIntake intake;
	public static Piston claw;
	public static Sensor sensor;
	public static Jevois jevois;

	public static OI oi;
	// big yummy
	public static HallSensor armHallEffect;
	public static Superstructure superstructureData;

	@Override
	public void robotInit() {
		// jevois = new Jevois(115200, SerialPort.Port.kUSB);
		sensor = new Sensor();

		chooser = new AutoChooser();
	    drive = new Drive();
		ds = DriverStation.getInstance();
		claw = new Piston(RobotMap.kClawPiston1ID, RobotMap.kClawPiston2ID);
		elevator = Elevator.getInstance();
		arm = Arm.getInstance();
		armHallEffect = new HallSensor(1, "ArmHallEffect", true);

		intake = new DualMotorIntake(new SingleMotorVictorSPX(RobotMap.kLeftIntakeVictorID, "LeftIntake", true), 
									new SingleMotorVictorSPX(RobotMap.kRightIntakeVictorID, "RightIntake", true));

		superstructureData = Superstructure.getInstance();

		// chevalRamp = new SingleMotorTalonSRX(RobotMap.kChevalRampTalonID, "Cheval Ramp", true, true);

		LoggableLambda armClosedLoopError = new LoggableLambda("ArmClosedLoopError",
			() -> (double) arm.motor.getClosedLoopError());
		LoggableLambda elevatorClosedLoopError = new LoggableLambda("ElevatorClosedLoopError",
			() -> (double) arm.motor.getClosedLoopError());
	
		oi = new OI();
		NerdyBadlog.initAndLog("/media/sda1/logs/", "testingAt4201_", 0.02, 
			elevator, elevatorClosedLoopError, arm, 
			armClosedLoopError, armHallEffect);
		CameraServer.getInstance().startAutomaticCapture();
	}

	@Override
	public void robotPeriodic() {
		elevator.reportToSmartDashboard();
		arm.reportToSmartDashboard();
		armHallEffect.reportToSmartDashboard();
		superstructureData.reportToSmartDashboard();
		SmartDashboard.putBoolean("Claw is forwards?", Robot.claw.isForwards());
		SmartDashboard.putBoolean("Claw is reverse?", Robot.claw.isReverse());
	}

	@Override
	public void disabledInit() {
		drive.stopLog();
		// jevois.stopLog();
		// jevois.enableStream();	
	}

	@Override
	public void disabledPeriodic() {
		// jevois.reportToSmartDashboard();
		drive.reportToSmartDashboard();
		
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
		// jevois.startLog();
		// rightJevois.startLog();
		drive.startLog();
		// drive.setCoastMode();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		drive.logToCSV();
		// jevois.reportToSmartDashboard();
		sensor.reportToSmartDashboard();
		drive.reportToSmartDashboard();


		// jevois.logToCSV();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
    public void testPeriodic() {
    }
}
