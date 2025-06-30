package br.com.pedromagno.dualshock.driver;

public interface Driver {

    void discoverDualshock();
    void connect();
    void disconnect();
    void startListening();
    void stopListening();
}
