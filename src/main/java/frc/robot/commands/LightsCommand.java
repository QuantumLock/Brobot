    // Copyright (c) FIRST and other WPILib contributors.
    // Open Source Software; you can modify and/or share it under the terms of
    // the WPILib BSD license file in the root directory of this project.

    package frc.robot.commands;

    import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LightSubsystem;

    public class LightsCommand extends CommandBase {
        private final LightSubsystem lights;
        private final int r, g, b;
    public LightsCommand(LightSubsystem _lights, int _r, int _g, int _b) {
        lights = _lights;
        r = _r;
        g = _g;
        b = _b;
        
        addRequirements(_lights);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        lights.setLights(r, g, b);
        lights.seizure(r,g,b);
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
    }
