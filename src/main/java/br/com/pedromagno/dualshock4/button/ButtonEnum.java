package br.com.pedromagno.dualshock4.button;

/**
 * Enum to map DualShock buttons and analog components.
 *
 * Each entry represents a specific input on the DualShock 4 controller,
 * including digital buttons, D-Pad directions, triggers, and analog sticks.
 *
 * Author: Pedro Magno <pedromagnopro@gmail.com>
 */
public enum ButtonEnum {
    // Digital face buttons
    SQUARE(5, 0x10),
    CROSS(5, 0x20),
    CIRCLE(5, 0x40),
    TRIANGLE(5, 0x80),

    // Shoulder buttons
    L1(6, 0x01),
    R1(6, 0x02),
    L2_DIGITAL(6, 0x04),
    R2_DIGITAL(6, 0x08),

    // System buttons
    SHARE(6, 0x10),
    OPTIONS(6, 0x20),
    L3(6, 0x40),
    R3(6, 0x80),
    PS(7, 0x01),
    TOUCHPAD(7, 0x02),

    // D-Pad directions
    DPAD_UP(5, 0x00),
    DPAD_RIGHT(5, 0x02),
    DPAD_DOWN(5, 0x04),
    DPAD_LEFT(5, 0x06),
    DPAD_NONE(5, 0x08),

    // Analog triggers and sticks (non-digital)
    L2_ANALOG(-1, -1),
    R2_ANALOG(-1, -1),
    LEFT_STICK(-1, -1),
    RIGHT_STICK(-1, -1);

    private final int byteIndex;
    private final int bitMaskOrValue;

    ButtonEnum(int byteIndex, int bitMaskOrValue) {
        this.byteIndex = byteIndex;
        this.bitMaskOrValue = bitMaskOrValue;
    }

    public boolean isPressed(byte[] report) {
        if (!isDigital()) return false;
        if (name().startsWith("DPAD")) {
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

    public boolean isAnalogTrigger() {
        return this == L2_ANALOG || this == R2_ANALOG;
    }

    public boolean isStick() {
        return this == LEFT_STICK || this == RIGHT_STICK;
    }

    public boolean isDigital() {
        return byteIndex >= 0;
    }

    public boolean isFaceButton() {
        return this == SQUARE || this == CROSS || this == CIRCLE || this == TRIANGLE;
    }

    public boolean isShoulderButton() {
        return this == L1 || this == R1 || this == L2_DIGITAL || this == R2_DIGITAL;
    }

    public boolean isSystemButton() {
        return this == SHARE || this == OPTIONS || this == PS || this == TOUCHPAD;
    }

    public boolean isDpad() {
        return name().startsWith("DPAD");
    }
}
