/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team687.commands.auto;

import com.nerdherd.lib.drivetrain.auto.DriveFalconTrajectory;
import com.nerdherd.lib.motor.commands.SetDualMotorPower;
import com.team687.Robot;
import com.team687.commands.superstructure.SetHatchMode;
import com.team687.commands.superstructure.Stow;
import com.team687.commands.superstructure.TeleopSimultaneous;
import com.team687.commands.vision.DriveAtHeading;
import com.team687.constants.AutoConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftRocketNear extends CommandGroup {
  /**
   * Add your docs here.
   */
  public LeftRocketNear() {
    addSequential(new DriveFalconTrajectory(Robot.drive, AutoConstants.leftRocketNearPathOne, 3, true, 0.01, 0));
    // addParallel(new DriveAtHeading(0, 0));
    // addParallel(new SetHatchMode(true));
    // addParallel(new TeleopSimultaneous(67));
    // addSequential(new SetDualMotorPower(Robot.intake, 0.25, 0.25));
    // addParallel(new Stow());
    // addSequential(new DriveFalconTrajectory(Robot.drive, AutoConstants.leftRocketNearPathTwo, 3, false, 0.01, 0));
  }
}
