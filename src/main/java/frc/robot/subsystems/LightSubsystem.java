package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LightSubsystem extends SubsystemBase {
    private AddressableLED strip;
    private AddressableLEDBuffer buffer;
    
    public LightSubsystem() {
        strip = new AddressableLED(2);
        strip.setLength(Constants.lightNum);
        buffer = new AddressableLEDBuffer(Constants.lightNum);
        strip.start();
    }
      
    public void setLights(int r, int g, int b){
        for(int light=0; light<Constants.lightNum; light += 1){
            buffer.setRGB(light, r, g, b);
        }
        strip.setData(buffer);
    }
  
    public void seizure(int r, int g, int b){
        for(int kill=0; kill<Constants.lightNum; kill += 1){
            buffer.setRGB(kill, r, g, b);
            strip.setData(buffer);
            buffer.setRGB(kill, 0, 0, 0);
            strip.setData(buffer);
        }

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
