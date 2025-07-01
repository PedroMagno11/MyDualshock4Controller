package br.com.pedromagno.dualshock.button.digital;

import br.com.pedromagno.dualshock.button.config.DigitalButtonConfig;
import br.com.pedromagno.dualshock.button.digital.enums.DigitalButtonEnum;
import br.com.pedromagno.dualshock.button.fire.FireMode;
import br.com.pedromagno.dualshock.listener.Dualshock;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DigitalButton implements Button {
    private static final Logger LOGGER = Logger.getLogger(DigitalButton.class.getName());
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    private DigitalButtonEnum button;
    private Dualshock dualshockListener;
    private volatile boolean pressed = false;
    private FireMode fireMode;
    private long lastTimestamp = 0;

    public DigitalButton(Dualshock dualshockListener, DigitalButtonEnum button) {
        this.button = button;
        this.dualshockListener = dualshockListener;
        this.fireMode = dualshockListener.getButtonFireMode();
    }


    @Override
    public boolean isPressed() {
        return pressed;
    }

    @Override
    public boolean isReleased() {
        return !pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    @Override
    public void fire() {
        long now = System.currentTimeMillis();


        if(fireMode == FireMode.TIMED_FIRE){
            if((now - lastTimestamp) < DigitalButtonConfig.INTERVAL){
                return;
            }

            lastTimestamp = now;

            executorService.submit(()->{
                try {
                    Method pressed = dualshockListener.getClass().getMethod("button" + button + "Pressed");
                    pressed.setAccessible(true);
                    pressed.invoke(dualshockListener);

                    Thread.sleep(DigitalButtonConfig.INTERVAL);

                    Method released = dualshockListener.getClass().getMethod("button" + button + "Released");
                    released.setAccessible(true);
                    this.pressed = false;
                    released.invoke(dualshockListener);
                } catch (Exception ex){
                    LOGGER.log(Level.SEVERE, "Erro in button fire: " + button, ex);
                }
            });
        }

        if(fireMode == FireMode.CONSTANT_FIRE){
            if(isReleased()){
                fireReleased();
            }

            long elapsed = now - lastTimestamp;

            if(elapsed >= DigitalButtonConfig.INTERVAL){
                lastTimestamp = now;
                constantFire();
            }
        }

    }

    @Override
    public void constantFire() {
        executorService.submit(()->{
            try {
                Method pressed = dualshockListener.getClass().getMethod("button" + button + "Pressed");
                pressed.setAccessible(true);
                pressed.invoke(dualshockListener);
            } catch (Exception ex){
                LOGGER.log(Level.SEVERE, "Erro in button fire: " + button, ex);
            }
        });
    }

    @Override
    public void fireReleased() {
        executorService.submit(()->{
            try {
                Method released = dualshockListener.getClass().getMethod("button" + button + "Released");
                released.setAccessible(true);
                this.pressed = false;
                released.invoke(dualshockListener);
            } catch (Exception ex){
                LOGGER.log(Level.SEVERE, "Erro in button fire released: " + button, ex);
            }
        });
    }
}
