package racinggame.service;

import nextstep.utils.Console;
import nextstep.utils.Randoms;
import racinggame.domains.Car;

import java.util.ArrayList;
import java.util.List;

public class GameService {


    public static final int RAND_NUM_SEED_RANGE_START = 0;
    public static final int RAND_NUM_SEED_RANGE_END = 9;
    public static final int RANDOM_MODIFIER = 3;
    public static final int MAX_NAME_LENGTH = 5;

    public List<Car> generateCarList() {
        List<Car> carList = makeCarList(Console.readLine());
        return ListIsValid(carList) ? carList : null;
    }

    public List<Car> makeCarList(String inputStr) {
        List<Car> carList = new ArrayList<>();
        String[] carNameArr = inputStr.split(",");
        for (String s : carNameArr) {
            Car car = new Car();
            car.setName(s);
            carList.add(car);
        }
        return carList;
    }

    public boolean ListIsValid(List<Car> carList) {
        return carList.stream().noneMatch(car -> car.getName().length() > MAX_NAME_LENGTH);
    }

    public int generateTryNum() {
        return makeTryNum(Console.readLine());
    }

    public int makeTryNum(String inputStr) {
        int tryNum;
        try {
            tryNum = Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            tryNum = -1;
        }
        if (tryNum < 0) {
            tryNum = -1;
        }
        return tryNum;
    }


    public List<Car> moveCars(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            int curPosition = car.getPosition() + addMovement();
            car.setPosition(curPosition);
            carList.set(i, car);
        }
        return carList;
    }

    private int addMovement() {
        return (Randoms.pickNumberInRange(RAND_NUM_SEED_RANGE_START, RAND_NUM_SEED_RANGE_END) > RANDOM_MODIFIER) ? 1 : 0;
    }

    public int findMaxMove(List<Car> carList) {
        int retVal = 0;
        for (Car car : carList) retVal = Math.max(retVal, car.getPosition());
        return retVal;
    }
}
