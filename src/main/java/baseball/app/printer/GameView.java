package baseball.app.printer;

import baseball.app.ball.BallsResult;

public final class GameView {

    private GameView() {
        throw new UnsupportedOperationException("Cannot create new Object");
    }

    public static void printInputNumber() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public static void printBallsResult(final BallsResult ballsResult) {
        System.out.println("결과: " + ballsResult.toString());
    }

    public static void printMenu() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
