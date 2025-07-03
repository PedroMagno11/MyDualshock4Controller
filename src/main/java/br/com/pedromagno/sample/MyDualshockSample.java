package br.com.pedromagno.sample;

import br.com.pedromagno.dualshock.button.fire.FireMode;
import br.com.pedromagno.dualshock.listener.DualshockAbstract;

public class MyDualshockSample extends DualshockAbstract {
    @Override
    public void buttonL2Moved(float value) {
        System.out.println("L2 Moved: " + value);
    }

    @Override
    public void buttonR2Moved(float value) {
        System.out.println("R2 Moved: " + value);
    }

    @Override
    public void buttonLXMoved(float value) {
        System.out.println("LX Moved: " + value);
    }

    @Override
    public void buttonRXMoved(float value) {
        System.out.println("RX Moved: " + value);
    }

    @Override
    public void buttonLYMoved(float value) {
        System.out.println("LY Moved: " + value);
    }

    @Override
    public void buttonRYMoved(float value) {
        System.out.println("RY Moved: " + value);
    }

    @Override
    public void buttonCROSSPressed() {
        System.out.println("CROSS Pressed");
    }

    @Override
    public void buttonCROSSReleased() {
        System.out.println("CROSS Released");
    }

    @Override
    public void buttonSQUAREPressed() {
        System.out.println("SQUARE Pressed");
    }

    @Override
    public void buttonSQUAREReleased() {
        System.out.println("SQUARE Released");
    }

    @Override
    public void buttonTRIANGLEPressed() {
        System.out.println("TRIANGLE Pressed");
    }

    @Override
    public void buttonTRIANGLEReleased() {
        System.out.println("TRIANGLE Released");
    }

    @Override
    public void buttonCIRCLEPressed() {
        System.out.println("CIRCLE Pressed");
    }

    @Override
    public void buttonCIRCLEReleased() {
        System.out.println("CIRCLE Released");
    }

    @Override
    public void buttonDPAD_UPPressed() {
        System.out.println("DPAD UP Pressed");
    }

    @Override
    public void buttonDPAD_UPReleased() {
        System.out.println("DPAD UP Released");
    }

    @Override
    public void buttonDPAD_DOWNPressed() {
        System.out.println("DPAD DOWN Pressed");
    }

    @Override
    public void buttonDPAD_DOWNReleased() {
        System.out.println("DPAD DOWN Released");
    }

    @Override
    public void buttonDPAD_LEFTPressed() {
        System.out.println("DPAD LEFT Pressed");
    }

    @Override
    public void buttonDPAD_LEFTReleased() {
        System.out.println("DPAD LEFT Released");
    }

    @Override
    public void buttonDPAD_RIGHTPressed() {
        System.out.println("DPAD RIGHT Pressed");
    }

    @Override
    public void buttonDPAD_RIGHTReleased() {
        System.out.println("DPAD RIGHT Released");
    }

    @Override
    public void buttonL1Pressed() {
        System.out.println("L1 Pressed");
    }

    @Override
    public void buttonL1Released() {
        System.out.println("L1 Released");
    }

    @Override
    public void buttonR1Pressed() {
        System.out.println("R1 Pressed");
    }

    @Override
    public void buttonR1Released() {
        System.out.println("R1 Released");
    }

    @Override
    public void buttonSHAREPressed() {
        System.out.println("SHARE Pressed");
    }

    @Override
    public void buttonSHAREReleased() {
        System.out.println("SHARE Released");
    }

    @Override
    public void buttonOPTIONSPressed() {
        System.out.println("OPTIONS Pressed");
    }

    @Override
    public void buttonOPTIONSReleased() {
        System.out.println("OPTIONS Released");
    }

    public MyDualshockSample(FireMode mode){
        super(mode);
    }
}
