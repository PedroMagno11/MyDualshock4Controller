package br.com.pedromagno.dualshock4.normalization;

public class HIDNormalization {
    public static float normalize(int raw){
        return (raw - 128)/127f;
    }

    public static float normalizeTrigger(int raw){
        return raw/255f;
    }
}
