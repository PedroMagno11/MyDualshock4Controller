package br.com.pedromagno.dualshock4.button;

/**
 * Enum to map DualShock buttons.
 *
 * @author Pedro Magno <pedromagnopro@gmail.com>
 */

public enum ButtonEnum {
    SQUARE(5, 0x10),
    CROSS(5, 0x20),
    CIRCLE(5, 0x40),
    TRIANGLE(5, 0x80),

    L1(6, 0x01),
    R1(6, 0x02),
    L2_DIGITAL(6, 0x04),
    R2_DIGITAL(6, 0x08),

    SHARE(6, 0x10),
    OPTIONS(6, 0x20),
    L3(6, 0x40),
    R3(6, 0x80),

    PS(7, 0x01),
    TOUCHPAD(7, 0x02),

    DPAD_UP(5, 0x00),
    DPAD_RIGHT(5, 0x02),
    DPAD_DOWN(5, 0x04),
    DPAD_LEFT(5, 0x06),
    DPAD_NONE(5, 0x08);

    private final int byteIndex;
    private final int bitMaskOrValue;

    ButtonEnum(int byteIndex, int bitMaskOrValue) {
        this.byteIndex = byteIndex;
        this.bitMaskOrValue = bitMaskOrValue;
    }

    public boolean isPressed(byte[] report){
        if(name().startsWith("DPAD")){
            int dpad = report[byteIndex] & 0x0F;
            return dpad == bitMaskOrValue;
        }
        return (report[byteIndex] & bitMaskOrValue) != 0;
    }

    public int getByteIndex() {
        return byteIndex;
    }

    public int getBitMaskOrValue() {
        return bitMaskOrValue;
    }
}
