package br.com.pedromagno.dualshock.listener.analog;

public interface DualshockAnalogListener {


    void buttonL2Moved(float value);
    void buttonR2Moved(float value);
    void buttonLXMoved(float value);
    void buttonRXMoved(float value);
    void buttonLYMoved(float value);
    void buttonRYMoved(float value);

}
