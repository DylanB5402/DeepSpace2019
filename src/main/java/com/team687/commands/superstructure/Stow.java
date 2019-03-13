/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team687.commands.superstructure;

import com.team687.Robot;
import com.team687.constants.SuperstructureConstants;
import com.team687.subsystems.Superstructure;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Stow extends Command {

  private double intakeDelayStartTime = 0;

  public Stow() {
    requires(Robot.intake);
    requires(Robot.arm);
    requires(Robot.elevator);
    requires(Robot.claw);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    intakeDelayStartTime = Timer.getFPGATimestamp();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.claw.setReverse();
    if (!Superstructure.getInstance().isHatchMode) {
      Robot.intake.setPower(0, 0);
    } else if (Timer.getFPGATimestamp() - intakeDelayStartTime > 1) {
      Robot.intake.setPower(0, 0);
    }
    Robot.arm.setAngleMotionMagic(SuperstructureConstants.kArmStowAngle);
    Robot.elevator.setHeightMotionMagic(SuperstructureConstants.kElevatorStowHeight);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
