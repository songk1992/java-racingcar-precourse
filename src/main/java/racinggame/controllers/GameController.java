package racinggame.controllers;

import racinggame.domains.Car;
import racinggame.service.GameService;

import java.util.List;

public class GameController {
    GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public List<Car> generateCarList() {
        return gameService.generateCarList();
    }

    public int generateTryNum() {
        return gameService.generateTryNum();
    }

    public void processResult() {
    }
}
