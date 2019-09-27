
package frc.core.components;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import edu.wpi.first.wpilibj.Encoder;

public class GearBox{
    private BaseMotorController motorOne, motorTwo;
    private Encoder encoder;
    
    public GearBox(BaseMotorController motorOne, BaseMotorController motorTwo, Encoder encoder, boolean isMotorOneInverted, boolean isMotorTwoIsInverted, double distancePerPulse) {
        this.motorOne = motorOne;
        this.motorTwo = motorTwo;
        this.encoder = encoder;

        motorOne.setInverted(isMotorOneInverted);

        if(motorTwo != null) motorTwo.setInverted(isMotorTwoIsInverted);

        if(encoder != null) this.configureEncoder(distancePerPulse);
    }

    public GearBox(BaseMotorController motorOne, BaseMotorController motorTwo, Encoder encoder, double distancePerPulse){
        this(motorOne, motorTwo, encoder, false, false, distancePerPulse);
    }

    public GearBox(BaseMotorController motorOne, boolean isMotorOneInverted, Encoder encoder, double distancePerPulse){
        this(motorOne, null, encoder, isMotorOneInverted, false, distancePerPulse);
    }
    
    public GearBox(BaseMotorController motorOne, Encoder encoder, double distancePerPulse){
        this(motorOne, null, encoder, false, false, distancePerPulse);
    }

    public GearBox(BaseMotorController motorOne, BaseMotorController motorTwo){
        this(motorOne, motorTwo, null, false, false, 0);
    }

    public GearBox(BaseMotorController motorOne, boolean isMotorOneInverted){
        this(motorOne, null, null, isMotorOneInverted, false, 0);
    }
    
    public GearBox(BaseMotorController motorOne){
        this(motorOne, null, null, false, false, 0);
    }

    public GearBox(BaseMotorController motorOne, BaseMotorController motorTwo, boolean isMotorOneInverted, boolean isMotorTwoIsInverted){
        this(motorOne, motorTwo, null, isMotorOneInverted, isMotorTwoIsInverted, 0);
    }

    private void configureEncoder(double distancePerPulse){
        encoder.setDistancePerPulse(distancePerPulse);
    }

    public void setEncoderInverted(boolean reverseDirection){
        encoder.setReverseDirection(reverseDirection);
    }

    public void setSpeed(double speed){
        motorOne.set(ControlMode.PercentOutput, speed);

        if(motorTwo != null) motorTwo.set(ControlMode.PercentOutput, speed);
    }

    public void resetEncoder(){
        encoder.reset();
    }

    public double getEncoderPulses(){
        return encoder.get();
    }

    public double getEncoderDistance(){
        return encoder.getDistance();
    }
}