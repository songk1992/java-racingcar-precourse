package racinggame.views;

import racinggame.controllers.GameController;

public class GameView {

    private final GameController gameController;

    public GameView() {
        this.gameController = new GameController();
    }

    public void startGame() {
        userInputCarNames();
        userInputTryNum();
        processResult();
    }

    private void processResult() {
        System.out.println("실행결과");
        gameController.processResult();
    }

    private void userInputCarNames() {
        System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
        gameController.userInputCarNames();
    }

    private void userInputTryNum() {
        System.out.println("시도할회수는몇회인가요?");
        gameController.userInputTryNum();
    }
}
