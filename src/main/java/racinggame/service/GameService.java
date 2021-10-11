package racinggame.service;

import nextstep.utils.Console;
import nextstep.utils.Randoms;
import racinggame.domains.Car;

import java.util.ArrayList;
import java.util.List;

public class GameService {


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
        boolean retBool = true;

        for (Car car : carList) {
            if (car.getName().length() > 5) {
                retBool = false;
                break;
            }
        }
        return retBool;
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
        return (Randoms.pickNumberInRange(0, 9) > 3) ? 1 : 0;
    }

}
