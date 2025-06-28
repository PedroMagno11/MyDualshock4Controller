package br.com.pedromagno.driver;

import br.com.pedromagno.Button;
import br.com.pedromagno.ButtonEnum;
import br.com.pedromagno.Dualshock4Listener;
import br.com.pedromagno.Model;
import br.com.pedromagno.exceptions.Dualshock4NotConnectedException;
import br.com.pedromagno.exceptions.Dualshock4NotFoundException;
import br.com.pedromagno.exceptions.InvalidDeviceException;
import org.hid4java.HidDevice;
import org.hid4java.HidServices;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Main entry point for interacting with the DualShock 4 controller.
 *
 * This class manages the connection to the DualShock 4 via the USB HID,
 * using the hid4java library as a backend for low-level communication.
 *
 * Communication with the DualShock 4 controller is based on its HID report structure,
 * which has been partially documented through community-driven efforts and reverse engineering.
 * For general information on HID access in Java, refer to the HID4Java project:
 * https://github.com/gary-rowe/hid4java

 * This library depends on hid4java — a Java wrapper for HID devices.
 *
 * @author Pedro Magno <pedromagnopro@gmail.com>
 */

public class Dualshock4Driver {

    /**
     * The object that represents the physical device to dualshock 4.
     */
    private HidDevice device;

    /**
     * Represents the client of the library. Every event occured will be notified to this listener.
     */
    private Dualshock4Listener listener;


    private volatile boolean running = false;


    private HashMap<ButtonEnum, Button> buttonMap = new HashMap<>();



    private double sensitivity;



    public Dualshock4Driver(Dualshock4Listener listener, double sensitivity){
        this.listener = listener;
        this.sensitivity = sensitivity;
        for(ButtonEnum button : ButtonEnum.values()){
            buttonMap.put(button, new Button(listener, button));
        }
    }

    /**
     * Method to find the Dualshock 4
     */
    public void discover() throws InvalidDeviceException {
        HidServices services = new HidServices();
        for (HidDevice device : services.getAttachedHidDevices()) {
            if (device.getManufacturer().equalsIgnoreCase("Sony Interactive Entertainment") && device.getProduct().equalsIgnoreCase("Wireless Controller")) {
                defineDevice(device);
                return;
            }
        }
        throw new Dualshock4NotFoundException("Dualshock 4 not found");
    }

    private void defineDevice(HidDevice device) throws InvalidDeviceException {
        // if the device is not a Dualshock 4 (and a valid model), it will throw a exception.
        if(!isValid(device.getVendorId())){
            throw new InvalidDeviceException(device.getProduct() + "is not a valid device");
        }

        System.out.printf("Dualshock 4 found.\nProduct ID: 0x%04X\nVendor ID: 0x%04X", device.getProductId(), device.getVendorId());
        this.device = device;
    }


    private boolean isValid(int vendorId){
        return Arrays.stream(Model.values()).anyMatch((t) -> t.getVendorId() == vendorId);
    }

    public void connect() {
        try {
            discover();
            device.open();
            return;
        } catch (InvalidDeviceException e) {
            System.err.println("Invalid device detected!\nERROR: " + e.getMessage());
        }
        catch (Dualshock4NotFoundException | Dualshock4NotConnectedException e){
            System.err.println("ERROR: " + e.getMessage());
        }
        device.isClosed();
    }

    public void disconnect() {
        device.close();
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
            int bytesRead = device.read(report,100);

            if(bytesRead > 0){
                for(Map.Entry<ButtonEnum, Button> entry: buttonMap.entrySet()){
                    ButtonEnum b = entry.getKey();
                    Button button = entry.getValue();

                    boolean wasPressed = b.isPressed(lastReport);
                    boolean isPressed = b.isPressed(report);

                    if(!wasPressed && isPressed){
                        button.fire();
                    }
                }

                System.arraycopy(report,0,lastReport,0,report.length);
            }
        }

    }


    public HidDevice getDevice() {
        return device;
    }

    public void setDevice(HidDevice device) {
        this.device = device;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}
