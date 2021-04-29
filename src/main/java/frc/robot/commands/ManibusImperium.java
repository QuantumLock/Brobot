// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Manibus;

public class ManibusImperium extends CommandBase {
    private final Manibus manibus;
    private final BooleanSupplier forwPressed;
    private final BooleanSupplier backPressed;
  /** Creates a new ManibusImperium. */
  public ManibusImperium(Manibus _subsystem, BooleanSupplier _forPressed, BooleanSupplier _backPressed) {
      manibus=_subsystem;
      forwPressed=_forPressed;
      backPressed=_backPressed;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      manibus.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      final boolean forwardPressed = forwPressed.getAsBoolean();
      final boolean backwardPressed = backPressed.getAsBoolean();
      if (forwardPressed && !backwardPressed){
          manibus.forward();
      } else if(backwardPressed && !forwardPressed){
          manibus.backwards();
      } else if(!backwardPressed && !forwardPressed){
            manibus.stop();
        }
        
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      manibus.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
