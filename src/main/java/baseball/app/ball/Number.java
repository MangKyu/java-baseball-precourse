package baseball.app.ball;

public class Number {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private final int value;

    public Number(final int value) {
        this.value = value;
        if (this.value < MIN_NUMBER || this.value > MAX_NUMBER) {
            throw new IllegalArgumentException("Input number is not in range: " + value);
        }
    }

    public int getValue() {
        return value;
    }

}
