package br.com.pedromagno.dualshock.listener.analog;

public interface DualshockAnalogListener<E> {


    E buttonL2Moved(float value);
    E buttonR2Moved(float value);
    E buttonLXMoved(float value);
    E buttonRXMoved(float value);
    E buttonLYMoved(float value);
    E buttonRYMoved(float value);

}
