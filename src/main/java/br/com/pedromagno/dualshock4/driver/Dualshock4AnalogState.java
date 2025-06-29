package br.com.pedromagno.dualshock4.driver;

import br.com.pedromagno.dualshock4.button.AnalogButtonState;

public class Dualshock4AnalogState {
    private AnalogButtonState leftStick = new AnalogButtonState(128, 128);
    private AnalogButtonState rightStick = new AnalogButtonState(128,128);
    private int l2Value = 0;
    private int r2Value = 0;

    public AnalogButtonState getLeftStick() {
        return leftStick;
    }

    public void setLeftStick(AnalogButtonState leftStick) {
        this.leftStick = leftStick;
    }

    public AnalogButtonState getRightStick() {
        return rightStick;
    }

    public void setRightStick(AnalogButtonState rightStick) {
        this.rightStick = rightStick;
    }

    public int getL2Value() {
        return l2Value;
    }

    public void setL2Value(int l2Value) {
        this.l2Value = l2Value;
    }

    public int getR2Value() {
        return r2Value;
    }

    public void setR2Value(int r2Value) {
        this.r2Value = r2Value;
    }

}
