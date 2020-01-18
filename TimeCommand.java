/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;

public class TimeCommand extends CommandBase {
  /**
   * Creates a new TimeCommand.
   */
  double variableSpeed;
  double variableTime;
  private final Timer localTimer = new Timer();


  public TimeCommand(double time, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    variableTime = time;
    variableSpeed = speed;
    addRequirements(Robot.objectDrivingSubsystem);
  }
    


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    localTimer.start();
   
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.objectDrivingSubsystem.teleopDrive(variableSpeed, variableSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.objectDrivingSubsystem.teleopDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (localTimer.get() > variableTime){
      return true;
    }
    else {
      return false;
    }
  }
}
