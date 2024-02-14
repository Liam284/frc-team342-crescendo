// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.OperatorConstants.*;

import javax.swing.plaf.synth.ColorType;

public class LEDSubsystem extends SubsystemBase {
  /** Creates a new LEDSubsystem. */

  private final AddressableLED LED;
  private final AddressableLEDBuffer LEDBuffer;

  public LEDSubsystem() {
    LED = new AddressableLED(0);
    LEDBuffer = new AddressableLEDBuffer(LENGTH);
    LED.setLength(LEDBuffer.getLength());
    LED.setData(LEDBuffer);
    LED.start();
  }

  public void allOff(){
    for(int i = 0; i < LEDBuffer.getLength(); i++){
        LEDBuffer.setHSV(i,0, 0, 0);
    }
    LED.setData(LEDBuffer);
  }

  public void hasGamePiece(){
    for(int i= 0; i < LENGTH; i++){
        LEDBuffer.setHSV(i, BLUE_H, BLUE_S, BLUE_V);
    }
    LED.setData(LEDBuffer);
  }

  public void canScore(){
    for(int i= LENGTH; i< LEDBuffer.getLength(); i++){
      LEDBuffer.setHSV(i, RED_H, RED_S, RED_V);
    }
    LED.setData(LEDBuffer);
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
