    // Copyright (c) FIRST and other WPILib contributors.
    // Open Source Software; you can modify and/or share it under the terms of
    // the WPILib BSD license file in the root directory of this project.

    package frc.robot.subsystems;

    import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

    public class Manibus extends SubsystemBase {
    private final WPI_VictorSPX aLifter, bLifter;
    public Manibus() { 
        aLifter = new WPI_VictorSPX(Constants.aLifter);
        bLifter = new WPI_VictorSPX(Constants.bLifter);
        
    }
    public void forward(){
       aLifter.set(0.5);
       bLifter.set(0.5);
    }
    public void backwards(){
        aLifter.set(-0.5);
        bLifter.set(-0.5);
    }
    public void stop(){
        aLifter.set(0);
        bLifter.set(0);
    }
       
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
    }
