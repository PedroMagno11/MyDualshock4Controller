package br.com.pedromagno.dualshock.button.analog.enums;

public interface AnalogButtonEnum {
    float readValue(byte[] report);
    int readRaw(byte[] report);
}
