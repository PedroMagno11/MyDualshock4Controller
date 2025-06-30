package br.com.pedromagno.dualshock.button.digital.enums;

public enum DPadDigitalButtonEnum implements DigitalButtonEnum {
    DPAD_UP(5, 0x00),
    DPAD_RIGHT(5, 0x02),
    DPAD_DOWN(5, 0x04),
    DPAD_LEFT(5, 0x06),
    DPAD_NONE(5, 0x08);

    private final int byteIndex;
    private final int bitValue;
    private volatile boolean pressed = false;


    DPadDigitalButtonEnum(int byteIndex, int byteValue) {
        this.byteIndex = byteIndex;
        this.bitValue = byteValue;
    }

    @Override
    public int getByteIndex() {
        return byteIndex;
    }

    @Override
    public int getBitValue() {
        return bitValue;
    }

    @Override
    public boolean isPressed(byte[] report) {
        return pressed;
    }
}
