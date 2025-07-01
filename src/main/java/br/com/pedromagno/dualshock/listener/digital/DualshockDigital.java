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
    public abstract void buttonSQUAREPressed();
    public abstract void buttonSQUAREReleased();
    public abstract void buttonTRIANGLEPressed();
    public abstract void buttonTRIANGLEReleased();
    public abstract void buttonCIRCLEPressed();
    public abstract void buttonCIRCLEReleased();

    public abstract void buttonDPAD_UPPressed();
    public abstract void buttonDPAD_UPReleased();
    public abstract void buttonDPAD_DOWNPressed();
    public abstract void buttonDPAD_DOWNReleased();
    public abstract void buttonDPAD_LEFTPressed();
    public abstract void buttonDPAD_LEFTReleased();
    public abstract void buttonDPAD_RIGHTPressed();
    public abstract void buttonDPAD_RIGHTReleased();


    @Override
    public FireMode getButtonFireMode() {
        return fireMode;
    }
}
