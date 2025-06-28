package br.com.pedromagno;

import br.com.pedromagno.dualshock4.driver.Dualshock4Driver;
import br.com.pedromagno.dualshock4.listener.Dualshock4Listener;


//printf("[X] ");
//                if (input.square)   printf("[■] ");
//                if (input.triangle) printf("[▲] ");
//                if (input.l1)       printf("[L1] ");
//                if (input.r1)       printf("[R1] ");
//                if (input.l2_digital) printf("[L2] ");
//                if (input.r2_digital) printf("[R2] ");
//                if (input.share)    printf("[SHARE] ");
//                if (input.options)  printf("[OPTIONS] ");
//                if (input.ps)       printf("[PS] ");
//                if (input.touchpad) printf("[TPAD] ");
//                if (input.l3)       printf("[L3] ");
//                if (input.r3)       printf("[R3] ");

public class Main {
    public static void main(String[] args) {

        Dualshock4Driver ps4 = new Dualshock4Driver(new Dualshock4Listener() {

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

            }

            @Override
            public void buttonPSPressed() {

            }

            @Override
            public void buttonTRIANGLEReleased() {

            }

            @Override
            public void buttonPSReleased() {

            }


        }, 0.0);

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