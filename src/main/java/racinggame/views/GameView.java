package racinggame.views;

import racinggame.controllers.GameController;
import racinggame.domains.Car;

import java.util.List;
import java.util.stream.Collectors;

public class GameView {

    private final GameController gameController;
    private List<Car> carList;
    private int tryNum;

    public GameView() {
        this.gameController = new GameController();
        this.carList = null;
        this.tryNum = 0;
    }

    public void startGame() {
        generateCarList();
        generateTryNum();
        processResult();
        printWinners();
    }

    private void processResult() {
        System.out.println("실행결과");
        for (int i = 0; i < tryNum; i++) {
            carList = gameController.moveCars(carList);
            printCarPosition();
        }
    }

    private void printCarPosition() {
        for (Car car : carList) {
            StringBuilder outputStr = new StringBuilder(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                outputStr.append("-");
            }
            System.out.println(outputStr);
        }
        System.out.println();
    }

    private void printWinners() {
        int maxMovement = gameController.findMaxMove(carList);
        String outputStr = "최종 우승자는 " + carList.stream().filter(car -> car.getPosition() == maxMovement).map(Car::getName).collect(Collectors.joining(",")) +
                " 입니다.";
        System.out.println(outputStr);
    }

    private void generateCarList() {
        System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
        carList = gameController.generateCarList();
        if (carList == null) {
            System.out.println("[ERROR]");
            generateCarList();
        }
    }

    private void generateTryNum() {
        System.out.println("시도할회수는몇회인가요?");
        tryNum = gameController.generateTryNum();
        if (tryNum == -1) {
            System.out.println("[ERROR]");
            generateTryNum();
        }
    }
}
