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


    // Released
    public void buttonDPAD_NONEReleased();
    public void buttonDPAD_UPReleased();
    public void buttonDPAD_DOWNReleased();
    public void buttonDPAD_LEFTReleased();
    public void buttonDPAD_RIGHTReleased();
    public void buttonCROSSReleased();
    public void buttonCIRCLEReleased();
    public void buttonSQUAREReleased();
    public void buttonTRIANGLEReleased();
    public void buttonPSReleased();

}
