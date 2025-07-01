package br.com.pedromagno.dualshock.driver;

import br.com.pedromagno.dualshock.button.digital.DigitalButton;
import br.com.pedromagno.dualshock.button.digital.enums.DigitalFaceButtonEnum;
import br.com.pedromagno.dualshock.button.digital.enums.DigitalButtonEnum;
import br.com.pedromagno.dualshock.button.fire.FireMode;
import br.com.pedromagno.dualshock.listener.Dualshock;
import br.com.pedromagno.exceptions.Dualshock4NotFoundException;
import br.com.pedromagno.exceptions.NullDeviceException;
import org.hid4java.HidDevice;
import org.hid4java.HidServices;

import java.util.HashMap;
import java.util.Map;

public class DualshockDriver implements Driver{

    private HidDevice device;
    private Dualshock listener;
    private boolean running;
    private HashMap<DigitalFaceButtonEnum, DigitalButton> digitalButtons = new HashMap<>();


    public DualshockDriver(Dualshock listener) {;
        this.listener = listener;
        this.running = false;

        for(DigitalFaceButtonEnum digitalButton: DigitalFaceButtonEnum.values()) {
            digitalButtons.put(digitalButton, new DigitalButton(listener, digitalButton));
        }

    }

    @Override
    public void discoverDualshock() {
        HidServices hidServices = new HidServices();
        for (HidDevice d : hidServices.getAttachedHidDevices()){
            if(d.getManufacturer().equalsIgnoreCase("Sony Interactive Entertainment") &&
                    d.getProduct().equalsIgnoreCase("Wireless Controller")
            ){
                device = d;
                System.out.printf("Dualshock 4 found.\nProduct ID: 0x%04X\nVendor ID: 0x%04X\n", device.getProductId(), device.getVendorId());
                return;
            }
        }
        throw new Dualshock4NotFoundException("Dualshock 4 not found");
    }

    @Override
    public void connect() {
        if(this.device == null){
            throw new NullDeviceException("The device is not discovered.");
        }
        device.open();
    }

    @Override
    public void disconnect() {
        if(!device.isClosed() && device != null){
            device.close();
            System.out.println("Dualshock 4 disconnected.");
        }
    }

    @Override
    public void startListening() {
        this.running = true;
        Thread startListeningThread = new Thread(this::startReadLoop);
        startListeningThread.setName("Dualshock 4 Listening Thread");
        startListeningThread.start();
    }

    private void startReadLoop(){
        byte[] report = new byte[64];
        byte[] lastReport = new byte[64];

        int counter = 0; // Monitora a quantidade de execuções
        while(running){
            int bytesRead = device.read(report, 100);

            if(bytesRead == -1){
                stopListening();
            }

            if(bytesRead > 0){
                processDigitalButton(report, lastReport, counter);
                System.arraycopy(report, 0, lastReport, 0, report.length);
            }
            counter += 1;
        }
    }

    private void processDigitalButton(byte[] report, byte[] lastReport, int counter) {
        for(Map.Entry<DigitalFaceButtonEnum, DigitalButton> entry: digitalButtons.entrySet()){
            DigitalFaceButtonEnum b = entry.getKey();
            DigitalButton button = entry.getValue();

            boolean wasPressed = b.isPressed(lastReport);
            boolean pressed = b.isPressed(report);

            if(listener.getButtonFireMode().equals(FireMode.CONSTANT_FIRE)){

                if(counter > 0){
                    if(wasPressed && pressed) {
                        button.setPressed(true);
                        button.fire();
                    }

                    if (wasPressed && !pressed) {
                        button.setPressed(false);
                        button.fire();
                    }
                }
            }

            else if (listener.getButtonFireMode().equals(FireMode.TIMED_FIRE)){
                if(!wasPressed && pressed){
                    button.setPressed(true);
                    button.fire();
                }else{
                    button.setPressed(false);
                }
            }
        }
    }

    @Override
    public void stopListening() {
        running = false;
    }

    public boolean isRunning(){
        return running;
    }

}
