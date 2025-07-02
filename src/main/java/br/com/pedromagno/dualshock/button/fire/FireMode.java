package br.com.pedromagno.dualshock.button.fire;

public enum FireMode {
    /**
     * Dispara o botão uma vez e chama automaticamente o método released após um intervalo.
     */
    TIMED_FIRE,

    /**
     * Dispara automaticamente o método fire enquanto o botão estiver pressionado.
     */
    CONSTANT_FIRE,
}
