package br.com.pedromagno.dualshock4.listener;

import br.com.pedromagno.dualshock4.button.AnalogButtonState;

public interface Dualshock4AnalogListener extends Dualshock4Listener {
    void buttonL2Changed(float value); // 0-255
    void buttonR2Changed(float value); // 0-255

    void onLeftStickMoved(AnalogButtonState newLeft);

    void onRightStickMoved(AnalogButtonState newRight);
}
