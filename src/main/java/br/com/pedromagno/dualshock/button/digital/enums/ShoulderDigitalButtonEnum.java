package br.com.pedromagno.dualshock.button.digital.enums;

public enum ShoulderDigitalButtonEnum implements DigitalButtonEnum {
    L1(6, 0x01),
    R1(6, 0x02),
    L2_DIGITAL(6, 0x04),
    R2_DIGITAL(6, 0x08);

    private final int byteIndex;
    private final int bitValue;
    private volatile boolean pressed;

    ShoulderDigitalButtonEnum(int byteIndex, int bitValue) {
        this.byteIndex = byteIndex;
        this.bitValue = bitValue;
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
