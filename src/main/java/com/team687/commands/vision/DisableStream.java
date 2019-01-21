package com.team687.commands.vision;

import com.team687.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DisableStream extends Command {

    public DisableStream() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.jevois);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.jevois.disableStream();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
