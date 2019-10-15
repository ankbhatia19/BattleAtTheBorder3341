/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class PnuematicsSubsystem extends Subsystem {
  private Compressor c;
  private DoubleSolenoid s;
  public PnuematicsSubsystem(){
   c = new Compressor(5);
   c.setClosedLoopControl(true);
    s= new DoubleSolenoid(5, 0,1);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
public boolean compressorState(){
  boolean state = c.enabled();
  return state;
}
public boolean pressureState(){
  boolean pressure = c.getPressureSwitchValue();
  return pressure;
}
public void Forward(){
  s.set(DoubleSolenoid.Value.kForward);
}
public void Backward(){
  s.set(DoubleSolenoid.Value.kReverse);
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new PnuematicsCommand());
    
  }
}
