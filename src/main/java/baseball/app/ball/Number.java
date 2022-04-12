package baseball.app.ball;

import java.util.Objects;

import static baseball.constants.GameConstants.MAX_NUMBER;
import static baseball.constants.GameConstants.MIN_NUMBER;

public class Number {

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
