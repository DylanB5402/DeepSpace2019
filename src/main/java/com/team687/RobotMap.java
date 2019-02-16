/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team687;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Power up robots
	
    public static final int kRightMasterTalonID = 2;
    public static final int kLeftMasterTalonID = 1;

    public static final int kRightSlaveTalon1ID = 4;
    public static final int kLeftSlaveTalon1ID = 5;

    public static final int kDrivetrainShifter1ID = 4;
    public static final int kDrivetrainShifter2ID = 7;

    // public static final int kLeftKickerWheelTalonID = 0;
    // public static final int kRightKickerWheelTalonID = 0;

    // public static final int kChevalRampTalonID = 0;

    // public static final int kChevalLockPiston1ID = 0;
    // public static final int kChevalLockPiston2ID = 0;

    public static final int kArmTalonID = 13;
    public static final int kIntakeTalonID = 12;
    public static final int kElevatorTalonID = 20;
}
