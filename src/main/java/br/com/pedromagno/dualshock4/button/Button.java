package br.com.pedromagno.dualshock4.button;

import br.com.pedromagno.dualshock4.listener.Dualshock4Listener;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Button {

    private static final Logger LOGGER = Logger.getLogger(Button.class.getName());
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    private final ButtonEnum button;
    private final Dualshock4Listener listener;
    private final FireMode fireMode;
    private final long interval;
    private long lastTimestamp = 0;

    public Button(Dualshock4Listener listener, ButtonEnum button, FireMode fireMode) {
        this(listener, button, fireMode, 255);
    }

    public Button(Dualshock4Listener listener, ButtonEnum button, FireMode fireMode, long interval) {
        this.listener = listener;
        this.button = button;
        this.fireMode = fireMode;
        this.interval = interval;
    }


    public void fire(){
        if(fireMode == FireMode.CONTINUOUS && button.isAnalog()){
            return;
        }

        long now = System.currentTimeMillis();

        if(fireMode == FireMode.TIMED && (now - lastTimestamp) < interval){
            return;
        }

        lastTimestamp = now;


        executor.submit(()->{

            try{
                Method pressed = listener.getClass().getMethod("button"+button+"Pressed");
                pressed.setAccessible(true);
                pressed.invoke(listener);

                if(fireMode != FireMode.INSTANT){
                    Thread.sleep(interval);
                    Method released = listener.getClass().getMethod("button"+button+"Released");
                    released.setAccessible(true);
                    released.invoke(listener);
                }
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Erro in button fire: " + button, ex);
            }
        });
    }

    public void fireAnalog(float value){
        lastTimestamp = System.currentTimeMillis();
        if(fireMode == FireMode.CONTINUOUS){
            executor.submit(()->{
                try{
                    Method changed = listener.getClass().getMethod("button"+button+"Changed", float.class);
                    changed.setAccessible(true);

                    while(true){
                        changed.invoke(listener, value);
                        Thread.sleep(50);
                    }
                } catch (Exception ex) {
                    LOGGER.log(Level.SEVERE, "Erro in analog fire: " + button, ex);
                }
            });
        }
    }


    public ButtonEnum getButton() {
        return button;
    }
}
