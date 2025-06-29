package br.com.pedromagno.dualshock4.driver;

import br.com.pedromagno.dualshock4.button.AnalogButtonState;
import br.com.pedromagno.dualshock4.button.Button;
import br.com.pedromagno.dualshock4.button.ButtonEnum;
import br.com.pedromagno.dualshock4.button.FireMode;
import br.com.pedromagno.dualshock4.listener.Dualshock4AnalogListener;
import br.com.pedromagno.dualshock4.listener.Dualshock4Listener;
import br.com.pedromagno.dualshock4.model.Model;
import br.com.pedromagno.exceptions.Dualshock4NotConnectedException;
import br.com.pedromagno.exceptions.Dualshock4NotFoundException;
import br.com.pedromagno.exceptions.InvalidDeviceException;
import org.hid4java.HidDevice;
import org.hid4java.HidServices;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dualshock4Driver {

    private HidDevice device;
    private Dualshock4Listener listener;
    private HashMap<ButtonEnum, Button> buttonMap = new HashMap<>();
    private final Dualshock4AnalogState lastState = new Dualshock4AnalogState();
    private volatile boolean running = false;

    public Dualshock4Driver(Dualshock4Listener listener, FireMode fireMode) {
        this.listener = listener;
        for(ButtonEnum button : ButtonEnum.values()){
            buttonMap.put(button, new Button(listener, button, fireMode));
        }
    }

    public void discover() throws InvalidDeviceException {
        HidServices services = new HidServices();
        for (HidDevice device : services.getAttachedHidDevices()) {
            if (device.getManufacturer().equalsIgnoreCase("Sony Interactive Entertainment") && device.getProduct().equalsIgnoreCase("Wireless Controller")) {
                if(!isValid(device.getVendorId())){
                    throw new InvalidDeviceException(device.getProduct() + "is not a valid device");
                }
                this.device = device;
                System.out.printf("Dualshock 4 found.\nProduct ID: 0x%04X\nVendor ID: 0x%04X", device.getProductId(), device.getVendorId());
                return;
            }
        }
        throw new Dualshock4NotFoundException("Dualshock 4 not found");
    }

    private boolean isValid(int vendorId){
        return Arrays.stream(Model.values()).anyMatch((t) -> t.getVendorId() == vendorId);
    }

    public void connect() {
        try {
            discover();
            device.open();

        } catch (InvalidDeviceException e) {
            System.err.println("Invalid device detected!\nERROR: " + e.getMessage());
        }
    }

    public void disconnect() {
        if(device != null && !device.isClosed()){
            device.close();
        }
    }

    public void startListening(){
        running = true;
        new Thread(this::startReadLoop).start();
    }

    public void stopListening(){
        running = false;
    }

    private void startReadLoop(){
        byte[] report = new byte[64];
        byte[] lastReport = new byte[64];

        while(running){
            if(device.read(report,100) > 0) {
                processButtons(report, lastReport);
                if(listener instanceof Dualshock4AnalogListener analogListener) {
                    processAnalogs(report, analogListener);
                }

                System.arraycopy(report,0,lastReport,0,report.length);
            }
        }
    }

    private void processButtons(byte[] report, byte[] lastReport){
        for(Map.Entry<ButtonEnum, Button> entry : buttonMap.entrySet()){
            ButtonEnum b = entry.getKey();
            Button button = entry.getValue();

            boolean wasPressed = b.isPressed(lastReport);
            boolean isPressed = b.isPressed(report);
            if(!wasPressed && isPressed){
                button.fire();
            }
        }
    }
    private void processAnalogs(byte[] report, Dualshock4AnalogListener analogListener) {
        AnalogButtonState newLeft = new AnalogButtonState(report[1] & 0xFF, report[2] & 0xFF);
        AnalogButtonState newRight = new AnalogButtonState(report[3] & 0xFF, report[4] & 0xFF);
        int newL2 = report[8] & 0xFF;
        int newR2 = report[9] & 0xFF;

        if(newLeft.distanceTo(lastState.getLeftStick()) > 0){
            analogListener.onLeftStickMoved(newLeft);
        }

        if(newRight.distanceTo(lastState.getRightStick()) > 0){
            analogListener.onRightStickMoved(newRight);
        }

        if (Math.abs(newL2 - lastState.getL2Value()) > 1) {
            analogListener.buttonL2Changed(newL2);
        }

        if (Math.abs(newR2 - lastState.getR2Value()) > 1) {
            analogListener.buttonR2Changed(newR2);
        }

        lastState.setLeftStick(newLeft);
        lastState.setRightStick(newRight);
        lastState.setL2Value(newL2);
        lastState.setR2Value(newR2);
    }


    public HidDevice getDevice() {
        return device;
    }

    public boolean isRunning() {
        return running;
    }


}
