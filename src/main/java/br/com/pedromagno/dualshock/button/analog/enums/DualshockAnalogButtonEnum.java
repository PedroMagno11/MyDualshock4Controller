package br.com.pedromagno.dualshock.button.analog.enums;

public enum DualshockAnalogButtonEnum implements AnalogButtonEnum {
    LX(1, false),
    LY(2, false),
    RX(3, false),
    RY(4, false),
    L2(8, true),
    R2(9, true);

    private final int byteIndex;
    private final boolean isTrigger;

    DualshockAnalogButtonEnum(int byteIndex, boolean trigger) {
        this.byteIndex = byteIndex;
        this.isTrigger = trigger;
    }

    @Override
    public float readValue(byte[] report) {
        int raw = Byte.toUnsignedInt(report[byteIndex]);

        if(isTrigger){
            return raw/255f;
        }

        float normalized = (raw - 127.5f) / 127.5f;
        return Math.abs(normalized) < 0.05f ? 0f : normalized;
    }

    @Override
    public int readRaw(byte[] report) {
        return Byte.toUnsignedInt(report[byteIndex]);
    }

    public boolean isTrigger() {
        return isTrigger;
    }
}
