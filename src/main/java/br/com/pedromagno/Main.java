package br.com.pedromagno;


import br.com.pedromagno.dualshock.button.fire.FireMode;
import br.com.pedromagno.dualshock.driver.DualshockDriver;
import br.com.pedromagno.dualshock.listener.digital.DualshockDigital;


public class Main {
    public static void main(String[] args) {

        DualshockDriver ps4 = new DualshockDriver(new DualshockDigital(FireMode.CONSTANT_FIRE) {
            @Override
            public void buttonCROSSPressed() {
                System.out.println("\nCROSS PRESSED");
            }

            @Override
            public void buttonCROSSReleased() {
                System.out.println("CROSS RELEASED");
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