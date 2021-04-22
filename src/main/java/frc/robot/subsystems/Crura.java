// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Crura extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final WPI_VictorSPX 
    rTalon,
    lTalon;
    private final DifferentialDrive diffDrive;
  public Crura() {
      rTalon = new WPI_VictorSPX(Constants.rTalon);
      lTalon = new WPI_VictorSPX(Constants.lTalon);
      diffDrive = new DifferentialDrive(lTalon, rTalon);
      diffDrive.setSafetyEnabled(false);
      diffDrive.setMaxOutput(Constants.maxSpeed);
  }
  public void arcadeDrive(double xSpeed, double zRotation){
      diffDrive.arcadeDrive(xSpeed, zRotation);
  }
  public void stop(){
      rTalon.set(0);
      lTalon.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
