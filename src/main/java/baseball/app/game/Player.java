package baseball.app.game;

import baseball.app.ball.Balls;
import baseball.app.ball.generator.BallsGenerator;
import baseball.app.printer.GameView;
import camp.nextstep.edu.missionutils.Console;

public class Player {

    private final BallsGenerator ballsGenerator;

    public Player(final BallsGenerator ballsGenerator) {
        this.ballsGenerator = ballsGenerator;
    }

    public Balls inputBalls() {
        GameView.printInputNumber();
        return ballsGenerator.generate();
    }

    public GameMenu inputGameMenu() {
        GameView.printMenu();

        final String input = Console.readLine();
        try {
            final int menu = Integer.parseInt(input);
            return GameMenu.of(menu);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("Input is not an integer: " + input, e);
        }
    }

}
