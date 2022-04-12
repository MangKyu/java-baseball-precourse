package baseball.app.ball;

public class Ball {

    private final Integer number;

    public Ball(final String input) {
        this.number = Integer.parseInt(input);
    }

    public int getNumber() {
        return number;
    }
}
