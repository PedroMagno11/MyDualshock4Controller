package br.com.pedromagno.dualshock.button.analog;

public interface Analog {
    boolean isMoved(byte[] report, byte[] lastReport);
    void fire(byte[] report);
}
