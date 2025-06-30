package br.com.pedromagno.dualshock.button.digital.enums;

public interface DigitalButtonEnum {
    int getByteIndex();
    int getBitValue();
    boolean isPressed(byte[] report);
}
