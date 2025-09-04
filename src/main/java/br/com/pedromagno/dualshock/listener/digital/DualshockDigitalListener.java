package br.com.pedromagno.dualshock.listener.digital;


public interface DualshockDigitalListener<E> {
    E buttonCROSSPressed();
    E buttonCROSSReleased();
    E buttonSQUAREPressed();
    E buttonSQUAREReleased();
    E buttonTRIANGLEPressed();
    E buttonTRIANGLEReleased();
    E buttonCIRCLEPressed();
    E buttonCIRCLEReleased();

    E buttonDPAD_UPPressed();
    E buttonDPAD_UPReleased();
    E buttonDPAD_DOWNPressed();
    E buttonDPAD_DOWNReleased();
    E buttonDPAD_LEFTPressed();
    E buttonDPAD_LEFTReleased();
    E buttonDPAD_RIGHTPressed();
    E buttonDPAD_RIGHTReleased();

    E buttonL1Pressed();
    E buttonL1Released();
    E buttonR1Pressed();
    E buttonR1Released();

    E buttonSHAREPressed();
    E buttonSHAREReleased();

    E buttonOPTIONSPressed();
    E buttonOPTIONSReleased();
}
