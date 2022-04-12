package baseball.app.ball;

import java.util.Objects;

public class Ball {

    private final Number number;

    public Ball(final String input) {
        try {
            this.number = new Number(Integer.parseInt(input));
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("Input is not an integer: " + input, e);
        }
    }

    public int getNumber() {
        return number.getValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ball ball = (Ball) o;
        return Objects.equals(number, ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
