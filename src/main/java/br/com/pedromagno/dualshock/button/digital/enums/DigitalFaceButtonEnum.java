package br.com.pedromagno.dualshock.button.digital.enums;

public enum DigitalFaceButtonEnum implements DigitalButtonEnum {
    SQUARE(5, 0x10),
    CROSS(5, 0x20),
    CIRCLE(5, 0x40),
    TRIANGLE(5, 0x80);

    private final int byteIndex;
    private final int bitValue;
    private volatile boolean pressed = false;

    DigitalFaceButtonEnum(int byteIndex, int byteValue) {
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
        return (report[byteIndex] & bitValue) != 0;
    }

}
