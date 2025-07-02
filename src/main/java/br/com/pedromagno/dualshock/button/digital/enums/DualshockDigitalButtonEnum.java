package br.com.pedromagno.dualshock.button.digital.enums;

public enum DualshockDigitalButtonEnum implements DigitalButtonEnum {
    SQUARE(5, 0x10),
    CROSS(5, 0x20),
    CIRCLE(5, 0x40),
    TRIANGLE(5, 0x80),

    DPAD_UP(5, 0x00),
    DPAD_RIGHT(5, 0x02),
    DPAD_DOWN(5, 0x04),
    DPAD_LEFT(5, 0x06),

    L1(6, 0x01),
    R1(6, 0x02);

    private final int byteIndex;
    private final int bitValue;
    private volatile boolean pressed = false;

    DualshockDigitalButtonEnum(int byteIndex, int byteValue) {
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
        if(name().startsWith("DPAD")){
            int dpad = report[byteIndex] & 0x0F;
            return dpad == bitValue;
        }
        return (report[byteIndex] & bitValue) != 0;
    }

}
