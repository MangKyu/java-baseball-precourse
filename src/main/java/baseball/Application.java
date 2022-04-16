package baseball;

import baseball.app.ball.generator.AutoBallsGenerator;
import baseball.app.ball.generator.ManualBallsGenerator;
import baseball.app.participant.Computer;
import baseball.app.game.Game;
import baseball.app.participant.Player;

public class Application {
    public static void main(String[] args) {
        final Game game = new Game(new Player(new ManualBallsGenerator()), new Computer(new AutoBallsGenerator()));
        game.start();
    }
}
