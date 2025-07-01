package br.com.pedromagno;


import br.com.pedromagno.dualshock.button.fire.FireMode;
import br.com.pedromagno.dualshock.driver.DualshockDriver;
import br.com.pedromagno.dualshock.listener.digital.DualshockDigital;


public class Main {
    public static void main(String[] args) {

        DualshockDriver ps4 = new DualshockDriver(new DualshockDigital(FireMode.CONSTANT_FIRE) {
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
            public FireMode getButtonFireMode() {
                return super.getButtonFireMode();
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