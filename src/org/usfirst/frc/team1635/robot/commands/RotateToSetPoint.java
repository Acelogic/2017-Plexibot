package org.usfirst.frc.team1635.robot.commands;

import org.usfirst.frc.team1635.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * true- clockwise, false - counterclockwise
 */
public class RotateToSetPoint extends Command {
	private double rotation;
	
	

	/**
	 * true- clockwise, false - counterclockwise
	 */
	public RotateToSetPoint(double rot) {

		requires(Robot.chassisSystem);
		rotation = rot; 
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.chassisSystem.resetYaw();
		Robot.chassisSystem.enableTurnToSetPoint(rotation);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.chassisSystem.rotateToSetPoint();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.chassisSystem.isDoneTurning();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.chassisSystem.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
