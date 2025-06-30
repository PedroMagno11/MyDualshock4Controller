package br.com.pedromagno.dualshock.listener.digital;

import br.com.pedromagno.dualshock.button.fire.FireMode;
import br.com.pedromagno.dualshock.listener.Dualshock;

public abstract class DualshockDigital implements Dualshock {

    private FireMode fireMode;

    public DualshockDigital(FireMode fireMode) {
        this.fireMode = fireMode;
    }

    public abstract void buttonCROSSPressed();
    public abstract void buttonCROSSReleased();


    @Override
    public FireMode getButtonFireMode() {
        return fireMode;
    }
}
