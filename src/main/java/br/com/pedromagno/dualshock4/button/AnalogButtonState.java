package br.com.pedromagno.dualshock4.button;

public class AnalogButtonState {
    private final int x;
    private final int y;

    public AnalogButtonState(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public double distanceTo(AnalogButtonState otherState) {
        int dx = x - otherState.getX();
        int dy = y - otherState.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "Analog Button State: { x = " + x + ", y = " + y + " }";
    }
}
