/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team687.commands.vision;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.team687.Robot;

public class LineFollow extends Command {

  private int m_threshold; 
  private double m_lineFollowOffset;
  private double m_power;
  private double m_offset;

  public LineFollow(double power) {
    m_power = power;
    m_threshold = 3409; //3150 is white, 3309 is blue
    m_offset = 0.25;
    m_lineFollowOffset = 150;
    requires(Robot.drive);
  }


  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    SmartDashboard.putString("Current Command", "Line Follow");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putBoolean("Line Found, Left", Robot.sensor.getValue0() < m_threshold);
    SmartDashboard.putBoolean("Line Found, Right", Robot.sensor.getValue2() < m_threshold);

    // when it's over blue, it's less

    if (Robot.sensor.getValue1() < (m_threshold + 100)) {
      if (Robot.sensor.getValue0() < m_threshold + m_lineFollowOffset) {
        Robot.drive.setPower(-m_power + (m_offset + 0.02), -m_power - (m_offset + 0.02));
        SmartDashboard.putString("Turn", "Right");
      } 
  
      else if (Robot.sensor.getValue2() < m_threshold + (m_lineFollowOffset)) {
        Robot.drive.setPower(-m_power - (m_offset - 0.00), -m_power + (m_offset - 0.00));
        SmartDashboard.putString("Turn", "Left");
      }

      else if (Robot.sensor.getValue0() > m_threshold && Robot.sensor.getValue2() > m_threshold 
                && Robot.sensor.getValue1() < m_threshold) {
        SmartDashboard.putString("Turn", "Neither");
        Robot.drive.setPower(-m_power, -m_power);
      } 
      

    else if(Robot.sensor.getValue0() > m_threshold && Robot.sensor.getValue1() > m_threshold && Robot.sensor.getValue2() > m_threshold){
      Robot.drive.setPower(0, 0);
      SmartDashboard.putString("Turn", "ugh");
    }
     
  }

  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (Robot.sensor.getValue0() > m_threshold && Robot.sensor.getValue1() > m_threshold && Robot.sensor.getValue2() > m_threshold);
    //return false;
  }

  // Called once after isFinished returns trSue
  @Override
  protected void end() {
    Robot.drive.setPower(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
