package racinggame.views;

import racinggame.controllers.GameController;
import racinggame.domains.Car;

import java.util.List;

public class GameView {

    private final GameController gameController;
    private List<Car> carList;
    private int tryNum;

    public GameView() {
        this.gameController = new GameController();
    }

    public void startGame() {
        generateCarList();
        generateTryNum();
        processResult();
    }

    private void processResult() {
        System.out.println("실행결과");
        gameController.processResult();
    }

    private void generateCarList() {
        System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
        carList = gameController.generateCarList();
        if(carList == null){
            System.out.println("[ERROR]");
            generateCarList();
        }
    }

    private void generateTryNum() {
        System.out.println("시도할회수는몇회인가요?");
        tryNum = gameController.generateTryNum();
        if(tryNum == -1){
            System.out.println("[ERROR]");
            generateTryNum();
        }
    }
}
