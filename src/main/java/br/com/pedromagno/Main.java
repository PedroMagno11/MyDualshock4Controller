package br.com.pedromagno;


import br.com.pedromagno.dualshock.button.fire.FireMode;
import br.com.pedromagno.dualshock.driver.DualshockDriver;
import br.com.pedromagno.dualshock.listener.analog.DualshockAnalogListener;
import br.com.pedromagno.dualshock.listener.digital.DualshockDigitalListener;


public class Main {
    public static void main(String[] args) {

        DualshockDriver ps4 = new DualshockDriver(new DualshockDigitalListener(FireMode.TIMED_FIRE) {

            @Override
            public void buttonCROSSPressed() {
                System.out.println("CROSS PRESSED");
            }

            @Override
            public void buttonCROSSReleased() {
                System.out.println("CROSS RELEASED");
            }

            @Override
            public void buttonSQUAREPressed() {
                System.out.println("SQUARE PRESSED");
            }

            @Override
            public void buttonSQUAREReleased() {
                System.out.println("SQUARE RELEASED");
            }

            @Override
            public void buttonTRIANGLEPressed() {
                System.out.println("TRIANGLE PRESSED");
            }

            @Override
            public void buttonTRIANGLEReleased() {
                System.out.println("TRIANGLE RELEASED");
            }

            @Override
            public void buttonCIRCLEPressed() {
                System.out.println("CIRCLE PRESSED");
            }

            @Override
            public void buttonCIRCLEReleased() {
                System.out.println("CIRCLE RELEASED");
            }

            @Override
            public void buttonDPAD_UPPressed() {
                System.out.println("DPAD_UP PRESSED");
            }

            @Override
            public void buttonDPAD_UPReleased() {
                System.out.println("DPAD_UP RELEASED");
            }

            @Override
            public void buttonDPAD_DOWNPressed() {
                System.out.println("DPAD_DOWN PRESSED");
            }

            @Override
            public void buttonDPAD_DOWNReleased() {
                System.out.println("DPAD_DOWN RELEASED");
            }

            @Override
            public void buttonDPAD_LEFTPressed() {
                System.out.println("DPAD_LEFT PRESSED");
            }

            @Override
            public void buttonDPAD_LEFTReleased() {
                System.out.println("DPAD_LEFT RELEASED");
            }

            @Override
            public void buttonDPAD_RIGHTPressed() {
                System.out.println("DPAD_RIGHT PRESSED");
            }

            @Override
            public void buttonDPAD_RIGHTReleased() {
                System.out.println("DPAD_RIGHT RELEASED");
            }

        }, new DualshockAnalogListener() {
            @Override
            public void buttonL2Moved(float value) {
                System.out.println("L2 MOVED: " + value);
            }
        });

        try{
            ps4.discoverDualshock();
            ps4.connect();
            ps4.startListening();
            while (ps4.isRunning()){
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            ps4.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }


    }

}