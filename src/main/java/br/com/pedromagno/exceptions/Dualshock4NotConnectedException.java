package br.com.pedromagno.exceptions;

public class Dualshock4NotConnected extends RuntimeException {
  public Dualshock4NotConnected(String message) {
    super(message);
  }
}
