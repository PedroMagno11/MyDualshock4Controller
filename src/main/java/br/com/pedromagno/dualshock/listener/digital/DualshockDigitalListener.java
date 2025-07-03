package br.com.pedromagno.dualshock.listener.digital;


public interface DualshockDigitalListener {
    void buttonCROSSPressed();
    void buttonCROSSReleased();
    void buttonSQUAREPressed();
    void buttonSQUAREReleased();
    void buttonTRIANGLEPressed();
    void buttonTRIANGLEReleased();
    void buttonCIRCLEPressed();
    void buttonCIRCLEReleased();

    void buttonDPAD_UPPressed();
    void buttonDPAD_UPReleased();
    void buttonDPAD_DOWNPressed();
    void buttonDPAD_DOWNReleased();
    void buttonDPAD_LEFTPressed();
    void buttonDPAD_LEFTReleased();
    void buttonDPAD_RIGHTPressed();
    void buttonDPAD_RIGHTReleased();

    void buttonL1Pressed();
    void buttonL1Released();
    void buttonR1Pressed();
    void buttonR1Released();

    void buttonSHAREPressed();
    void buttonSHAREReleased();

    void buttonOPTIONSPressed();
    void buttonOPTIONSReleased();
}
