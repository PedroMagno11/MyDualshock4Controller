package br.com.pedromagno.dualshock.button.digital;

public interface Button {
    boolean isPressed();
    boolean isReleased();
    void fire();
    void fireReleased();
}
