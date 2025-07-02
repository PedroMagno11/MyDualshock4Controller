package br.com.pedromagno.dualshock.button.analog;

import br.com.pedromagno.dualshock.button.analog.enums.DualshockAnalogButtonEnum;
import br.com.pedromagno.dualshock.button.config.DigitalButtonConfig;
import br.com.pedromagno.dualshock.listener.analog.DualshockAnalogListener;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DualshockAnalogButton implements Analog {

    private static final Logger LOGGER = Logger.getLogger(DualshockAnalogButton.class.getName());
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private DualshockAnalogButtonEnum button;
    private DualshockAnalogListener dualshockListener;
    private volatile boolean moved = false;

    public DualshockAnalogButton(DualshockAnalogListener listener, DualshockAnalogButtonEnum analogButton) {
        this.dualshockListener = listener;
        this.button = analogButton;
    }


    @Override
    public boolean isMoved(byte[] report, byte[] lastReport) {
        return button.readValue(report) == button.readValue(lastReport);
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    @Override
    public void fire(byte[] report) {

        float value = button.readValue(report);

        if(value != 0.0){
            executorService.submit(()->{
                try {
                    Method pressed = dualshockListener.getClass().getMethod("button" + button + "Moved", float.class);
                    pressed.setAccessible(true);
                    pressed.invoke(dualshockListener, value);
                } catch (Exception ex){
                    LOGGER.log(Level.SEVERE, "Erro in button fire: " + button, ex);
                }
            });
        }

    }
}
