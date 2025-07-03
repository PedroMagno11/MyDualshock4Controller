package br.com.pedromagno;


import br.com.pedromagno.sample.MyDualshockSample;
import br.com.pedromagno.dualshock.button.fire.FireMode;
import br.com.pedromagno.dualshock.driver.DualshockDriver;


public class Main {
    public static void main(String[] args) {

        DualshockDriver ps4 = new DualshockDriver(new MyDualshockSample(FireMode.CONSTANT_FIRE));
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