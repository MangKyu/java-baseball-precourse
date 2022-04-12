package baseball.app.ball;

public enum BallJudgeStatus {

    BALL("볼", true),
    STRIKE("스트라이크", true),
    NOTHING("낫싱", false),
    ;

    private final String printName;
    private final boolean appendView;

    BallJudgeStatus(final String printName, final boolean appendView) {
        this.printName = printName;
        this.appendView = appendView;
    }

    public String getPrintName() {
        return printName;
    }

    public boolean isAppendView() {
        return appendView;
    }
}
