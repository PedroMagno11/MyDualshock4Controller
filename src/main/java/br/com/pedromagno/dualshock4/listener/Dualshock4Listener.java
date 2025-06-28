package br.com.pedromagno;

public interface Dualshock4Listener {

    // Pressed
    public void buttonDPAD_NONEPressed();
    public void buttonDPAD_UPPressed();
    public void buttonDPAD_DOWNPressed();
    public void buttonDPAD_LEFTPressed();
    public void buttonDPAD_RIGHTPressed();
    public void buttonCROSSPressed();
    public void buttonCIRCLEPressed();
    public void buttonSQUAREPressed();
    public void buttonTRIANGLEPressed();


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

}
