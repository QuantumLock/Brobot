// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class Digitos extends SubsystemBase {
    public final WPI_VictorSPX fingerOne, fingerTwo;
  /** Creates a new digitos. */
  public Digitos() {
      fingerOne = new WPI_VictorSPX(Constants.fingerOne);
      fingerTwo = new WPI_VictorSPX(Constants.fingerTwo);
  }
  public void right(){
      fingerOne.set(0.5);
      fingerTwo.set(0.5);
  }
  public void left(){
      fingerOne.set(-0.5);
      fingerTwo.set(-0.5);
  }
  public void stop(){
    fingerOne.set(0);
    fingerTwo.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
