// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Digitos;

import java.util.function.BooleanSupplier;

public class DigitosImperium extends CommandBase {
  private final Digitos digitos;
  private final BooleanSupplier rightPressed;
  private final BooleanSupplier leftPressed;
  public DigitosImperium(Digitos _digitos, BooleanSupplier _rightPressed, BooleanSupplier _leftPressed) {
    // Use addRequirements() here to declare subsystem dependencies.
    digitos = _digitos;
    rightPressed = _rightPressed;
    leftPressed = _leftPressed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      digitos.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      final boolean pressedRight = rightPressed.getAsBoolean();
      final boolean pressedLeft = leftPressed.getAsBoolean();
      if(pressedRight && !pressedLeft){
          digitos.right();
      } else if(!pressedRight && pressedLeft){
          digitos.left();
      } else if(!pressedRight && !pressedLeft){
          digitos.stop();
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      digitos.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
