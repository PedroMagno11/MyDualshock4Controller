package br.com.pedromagno;

import br.com.pedromagno.dualshock4.button.AnalogButtonState;
import br.com.pedromagno.dualshock4.button.FireMode;
import br.com.pedromagno.dualshock4.driver.Dualshock4Driver;
import br.com.pedromagno.dualshock4.listener.Dualshock4AnalogListener;
import br.com.pedromagno.dualshock4.listener.Dualshock4Listener;

public class Main {
    public static void main(String[] args) {

        Dualshock4Driver ps4 = new Dualshock4Driver(new Dualshock4AnalogListener() {

            @Override
            public void buttonL2Changed(float value) {
                System.out.println("L2: " + value);
            }

            @Override
            public void buttonR2Changed(float value) {

            }

            @Override
            public void onLeftStickMoved(AnalogButtonState newLeft) {

            }

            @Override
            public void onRightStickMoved(AnalogButtonState newRight) {

            }

            @Override
            public void buttonDPAD_NONEPressed() {

            }

            @Override
            public void buttonDPAD_NONEReleased() {

            }

            @Override
            public void buttonDPAD_UPPressed() {
                System.out.println("[↑]");
            }

            @Override
            public void buttonDPAD_UPReleased() {
                System.out.println("↑");
            }

            @Override
            public void buttonDPAD_DOWNPressed() {
                System.out.println("[↓]");
            }

            @Override
            public void buttonDPAD_DOWNReleased() {
                System.out.println("↓");
            }

            @Override
            public void buttonDPAD_LEFTPressed() {
                System.out.println("[←]");
            }

            @Override
            public void buttonDPAD_LEFTReleased() {
                System.out.println("←");
            }

            @Override
            public void buttonDPAD_RIGHTPressed() {
                System.out.println("[→]");
            }

            @Override
            public void buttonDPAD_RIGHTReleased() {
                System.out.println("→");
            }

            @Override
            public void buttonCROSSPressed() {
                System.out.println("[X]");
            }

            @Override
            public void buttonCROSSReleased() {
                System.out.println("X");
            }

            @Override
            public void buttonCIRCLEPressed() {
                System.out.println("[O]");
            }

            @Override
            public void buttonCIRCLEReleased() {
                System.out.println("O");
            }

            @Override
            public void buttonSQUAREPressed() {
                System.out.println("[■]");
            }

            @Override
            public void buttonSQUAREReleased() {
                System.out.println("■");
            }

            @Override
            public void buttonTRIANGLEPressed() {
                System.out.println("[▲]");
            }
            @Override
            public void buttonTRIANGLEReleased() {
                System.out.println("▲");
            }
            @Override
            public void buttonPSPressed() {
                System.out.println("[PS]");
            }

            @Override
            public void buttonSHAREPressed() {
                System.out.println("[SHARE]");
            }

            @Override
            public void buttonOPTIONSPressed() {
                System.out.println("[OPTIONS]");
            }

            @Override
            public void buttonTOUCHPADPressed() {
                System.out.println("[TOUCHPAD]");
            }

            @Override
            public void buttonL2_DIGITALPressed() {
                System.out.println("[L2]");
            }

            @Override
            public void buttonR2_DIGITALPressed() {
                System.out.println("[R2]");
            }

            @Override
            public void buttonPSReleased() {
                System.out.println("PS");
            }

            @Override
            public void buttonSHAREReleased() {
                System.out.println("SHARE");
            }

            @Override
            public void buttonOPTIONSReleased() {
                System.out.println("OPTIONS");
            }

            @Override
            public void buttonTOUCHPADReleased() {
                System.out.println("TOUCHPAD");
            }

            @Override
            public void buttonL2_DIGITALReleased() {
                System.out.println("L2");
            }

            @Override
            public void buttonR2_DIGITALReleased() {
                System.out.println("R2");
            }


        }, FireMode.CONTINUOUS);

        ps4.connect();
        ps4.startListening();
        while(ps4.isRunning()){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        ps4.stopListening();
    }

}