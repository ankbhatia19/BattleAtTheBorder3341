/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 * Add your docs here.
 */
public class DriveTrainSubystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
private WPI_TalonSRX leftTalon;
private WPI_TalonSRX rightTalon;
private DifferentialDrive drive;
public DriveTrainSubystem(){
  leftTalon= new WPI_TalonSRX(2);
  rightTalon = new WPI_TalonSRX(3);
  drive = new DifferentialDrive(leftTalon, rightTalon);
}
public void TankDrive( double Lval, double Rval){
  drive.tankDrive(Lval, Rval);
}
public void rotateL(){
rightTalon.set(ControlMode.PercentOutput, -0.5);
leftTalon.set(ControlMode.PercentOutput,0.5);
}
public void rotateR(){
  rightTalon.set(ControlMode.PercentOutput, 0.5);
  leftTalon.set(ControlMode.PercentOutput,-0.5);
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveTrainCommand());
  }
}
