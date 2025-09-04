package br.com.pedromagno.sample;

import br.com.pedromagno.dualshock.button.fire.FireMode;
import br.com.pedromagno.dualshock.listener.DualshockAbstract;

public class MyDualshockSample extends DualshockAbstract<Object> {
    @Override
    public Object buttonL2Moved(float value) {
        System.out.println("L2 Moved: " + value);
        return value;
    }

    @Override
    public Object buttonR2Moved(float value) {
        System.out.println("R2 Moved: " + value);
        return value;
    }

    @Override
    public Object buttonLXMoved(float value) {
        System.out.println("LX Moved: " + value);
        return value;
    }

    @Override
    public Object buttonRXMoved(float value) {
        System.out.println("RX Moved: " + value);
        return value;
    }

    @Override
    public Object buttonLYMoved(float value) {
        System.out.println("LY Moved: " + value);
        return value;
    }

    @Override
    public Object buttonRYMoved(float value) {
        System.out.println("RY Moved: " + value);
        return value;
    }

    @Override
    public Object buttonCROSSPressed() {
        System.out.println("CROSS Pressed");
        return null;
    }

    @Override
    public Object buttonCROSSReleased() {
        System.out.println("CROSS Released");
        return null;
    }

    @Override
    public Object buttonSQUAREPressed() {
        System.out.println("SQUARE Pressed");
        return null;
    }

    @Override
    public Object buttonSQUAREReleased() {
        System.out.println("SQUARE Released");
        return null;
    }

    @Override
    public Object buttonTRIANGLEPressed() {
        System.out.println("TRIANGLE Pressed");
        return null;
    }

    @Override
    public Object buttonTRIANGLEReleased() {
        System.out.println("TRIANGLE Released");
        return null;
    }

    @Override
    public Object buttonCIRCLEPressed() {
        System.out.println("CIRCLE Pressed");
        return null;
    }

    @Override
    public Object buttonCIRCLEReleased() {
        System.out.println("CIRCLE Released");
        return null;
    }

    @Override
    public Object buttonDPAD_UPPressed() {
        System.out.println("DPAD UP Pressed");
        return null;
    }

    @Override
    public Object buttonDPAD_UPReleased() {
        System.out.println("DPAD UP Released");
        return null;
    }

    @Override
    public Object buttonDPAD_DOWNPressed() {
        System.out.println("DPAD DOWN Pressed");
        return null;
    }

    @Override
    public Object buttonDPAD_DOWNReleased() {
        System.out.println("DPAD DOWN Released");
        return null;
    }

    @Override
    public Object buttonDPAD_LEFTPressed() {
        System.out.println("DPAD LEFT Pressed");
        return null;
    }

    @Override
    public Object buttonDPAD_LEFTReleased() {
        System.out.println("DPAD LEFT Released");
        return null;
    }

    @Override
    public Object buttonDPAD_RIGHTPressed() {
        System.out.println("DPAD RIGHT Pressed");
        return null;
    }

    @Override
    public Object buttonDPAD_RIGHTReleased() {
        System.out.println("DPAD RIGHT Released");
        return null;
    }

    @Override
    public Object buttonL1Pressed() {
        System.out.println("L1 Pressed");
        return null;
    }

    @Override
    public Object buttonL1Released() {
        System.out.println("L1 Released");
        return null;
    }

    @Override
    public Object buttonR1Pressed() {
        System.out.println("R1 Pressed");
        return null;
    }

    @Override
    public Object buttonR1Released() {
        System.out.println("R1 Released");
        return null;
    }

    @Override
    public Object buttonSHAREPressed() {
        System.out.println("SHARE Pressed");
        return null;
    }

    @Override
    public Object buttonSHAREReleased() {
        System.out.println("SHARE Released");
        return null;
    }

    @Override
    public Object buttonOPTIONSPressed() {
        System.out.println("OPTIONS Pressed");
        return null;
    }

    @Override
    public Object buttonOPTIONSReleased() {
        System.out.println("OPTIONS Released");
        return null;
    }

    public MyDualshockSample(FireMode mode){
        super(mode);
    }
}
