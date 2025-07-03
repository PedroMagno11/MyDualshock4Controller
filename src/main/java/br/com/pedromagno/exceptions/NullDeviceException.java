package br.com.pedromagno.exceptions;

public class NullDeviceException extends RuntimeException {
    public NullDeviceException(String message) {
        super(message);
    }
}
