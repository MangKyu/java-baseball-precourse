package baseball.app.ball;

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

}
