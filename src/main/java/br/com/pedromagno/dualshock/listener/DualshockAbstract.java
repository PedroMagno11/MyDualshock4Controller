package br.com.pedromagno.dualshock.listener;


import br.com.pedromagno.dualshock.button.fire.FireMode;
import br.com.pedromagno.dualshock.listener.analog.DualshockAnalogListener;
import br.com.pedromagno.dualshock.listener.digital.DualshockDigitalListener;

public abstract class DualshockAbstract<E> implements DualshockDigitalListener<E>, DualshockAnalogListener<E> {

    private final FireMode fireMode;

    public DualshockAbstract(FireMode fireMode) {
        this.fireMode = fireMode;
    }

    public FireMode getFireMode() {
        return fireMode;
    }
}
