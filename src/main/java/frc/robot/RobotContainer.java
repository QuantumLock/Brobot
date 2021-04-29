// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.CruraImperium;
import frc.robot.commands.LightsCommand;
import frc.robot.commands.ManibusImperium;
import frc.robot.subsystems.Crura;
import frc.robot.subsystems.LightSubsystem;
import frc.robot.subsystems.Manibus;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.commands.DigitosImperium;
import frc.robot.subsystems.Digitos;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
    private final CruraImperium cruraImperium;
    private final Crura crura;
    private final Joystick controller;
    private final LightSubsystem lights;
    private final JoystickButton redButton;
    private final JoystickButton whiteButton;
    private final JoystickButton badButton;
    private final JoystickButton offButton;
    private final ManibusImperium manibusImperium;
    private final Manibus manibus;
    private final Digitos digitos;
    private final DigitosImperium digitosImperium;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() { 
    lights = new LightSubsystem();
    manibus = new Manibus();
    controller = new Joystick(0);
    manibusImperium = new ManibusImperium(
        manibus,
        () -> controller.getRawButton(Constants.liftButton),
        () -> controller.getRawButton(Constants.lowerButton));
        manibus.setDefaultCommand(manibusImperium);
    redButton = new JoystickButton(controller, Constants.redButton);
    whiteButton = new JoystickButton(controller, Constants.whiteButton);
    badButton = new JoystickButton(controller, Constants.badButton);
    offButton = new JoystickButton(controller, Constants.offButton);
    digitos = new Digitos();
    digitosImperium = new DigitosImperium(
        digitos, 
        () -> controller.getRawButton(Constants.fingerButtonRight), 
        () -> controller.getRawButton(Constants.fingerButtonLeft));
        digitos.setDefaultCommand(digitosImperium);
    crura = new Crura();
    cruraImperium = new CruraImperium(
    crura,
    () -> controller.getRawAxis(Constants.speedJoystick)*Constants.speedJoystickScalar,
    () -> controller.getRawAxis(Constants.rotationJoystick)*Constants.rotationJoystickScalar);
    crura.setDefaultCommand(cruraImperium);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
      redButton.whileHeld(new LightsCommand(lights, 255, 0, 0));
      whiteButton.whileHeld(new LightsCommand(lights, 255, 255, 255));
      badButton.whileHeld(new LightsCommand(lights, 0, 255, 0));
      offButton.whileHeld(new LightsCommand(lights, 0, 0, 0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
    
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
    }
}
    

