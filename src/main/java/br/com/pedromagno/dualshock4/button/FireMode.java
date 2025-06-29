package br.com.pedromagno.dualshock4.button;

public enum FireMode {
    TIMED, // Respeita um intervalo mínimo para poder chamar o released automaticamente
    INSTANT, // Evento único por pressão chama o released logo após ser apertado
    CONTINUOUS // Evento contínuo enquanto pressionado
}
