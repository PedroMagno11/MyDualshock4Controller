package br.com.pedromagno.dualshock4.listener;

public interface Dualshock4Listener {

    // Pressed
    void buttonDPAD_NONEPressed();
    void buttonDPAD_UPPressed();
    void buttonDPAD_DOWNPressed();
    void buttonDPAD_LEFTPressed();
    void buttonDPAD_RIGHTPressed();
    void buttonCROSSPressed();
    void buttonCIRCLEPressed();
    void buttonSQUAREPressed();
    void buttonTRIANGLEPressed();
    void buttonPSPressed();
    void buttonSHAREPressed();
    void buttonOPTIONSPressed();
    void buttonTOUCHPADPressed();

    // Released
    void buttonDPAD_NONEReleased();
    void buttonDPAD_UPReleased();
    void buttonDPAD_DOWNReleased();
    void buttonDPAD_LEFTReleased();
    void buttonDPAD_RIGHTReleased();
    void buttonCROSSReleased();
    void buttonCIRCLEReleased();
    void buttonSQUAREReleased();
    void buttonTRIANGLEReleased();
    void buttonPSReleased();
    void buttonSHAREReleased();
    void buttonOPTIONSReleased();
    void buttonTOUCHPADReleased();

}
