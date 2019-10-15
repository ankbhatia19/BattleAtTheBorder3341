/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PnuematicsCommand extends Command {
  public PnuematicsCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.pnuematics);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    boolean compressorstate = Robot.pnuematics.compressorState();
    boolean enable = Robot.pnuematics.pressureState();
    System.out.print("compressorstate"+ compressorstate+"\n");
    System.out.print("enable"+ enable+"\n");

    if(Robot.m_oi.buttonF.get()== true){
    Robot.pnuematics.Forward();
    System.out.print("FORWARD+++++++ \n");
    }
    if(Robot.m_oi.buttonB.get()==true){
    Robot.pnuematics.Backward();
    System.out.print("BackWARD+++++++ \n");
    }
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
