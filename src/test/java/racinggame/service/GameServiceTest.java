package racinggame.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domains.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private List<Car> com;
    private GameService gameService;


    @BeforeEach
    void setUp() {
        gameService = new GameService();

        com = new ArrayList<>();
        Car car1 = new Car();
        car1.setName("pobi");
        Car car2 = new Car();
        car2.setName("crong");
        Car car3 = new Car();
        car3.setName("honux");
        com.add(car1);
        com.add(car2);
        com.add(car3);
    }


    @Test
    @DisplayName("레이싱 게임 입력 테스트 스트링 , 분할 테스트")
    void nameInputStringEqualityTest() {
        List<Car> carList = gameService.makeCarList("pobi,crong,honux");
        assertThat(carList.get(0).getName()).isEqualTo(com.get(0).getName());
        assertThat(carList.get(1).getName()).isEqualTo(com.get(1).getName());
        assertThat(carList.get(2).getName()).isEqualTo(com.get(2).getName());
    }

    @Test
    @DisplayName("레이싱 게임 입력 테스트 스트링 , 이름_숫자_테스트")
    void nameInputStringCountTest() {
        List<Car> carList = gameService.makeCarList("pobi,crong,honux");
        assertThat(carList.size()).isEqualTo(com.size());
    }

    @Test
    @DisplayName("레이싱 게임 입력 테스트 스트링 , 이름_길이_테스트")
    void nameInputStringLengthTest() {
        Car car4 = new Car();
        car4.setName("honux123");
        com.add(car4);
        assertThat(gameService.ListIsValid(com)).isFalse();

        com.remove(3);
        assertThat(gameService.ListIsValid(com)).isTrue();
    }

    @Test
    @DisplayName("레이싱 게임 입력 테스트 숫자 , 숫자_입력_테스트")
    void tryNumInputTest() {
        assertThat(gameService.makeTryNum("1")).isEqualTo(1);
        assertThat(gameService.makeTryNum("-1")).isEqualTo(-1);
        assertThat(gameService.makeTryNum("숫자가아닌스트링")).isEqualTo(-1);
        assertThat(gameService.makeTryNum("2147483647")).isEqualTo(2147483647);
        assertThat(gameService.makeTryNum("2147483648")).isEqualTo(-1);
    }

    @Test
    @DisplayName("레이싱 차움직임 리스트 정상리턴 테스트")
    void moveCars() {
        List<Car> tempCom = gameService.moveCars(com);
        for (int i = 0; i < com.size(); i++) {
            assertThat(com.get(i).getName()).isEqualTo(tempCom.get(i).getName());
            assertThat(tempCom.get(i).getName()).isGreaterThanOrEqualTo(com.get(i).getName());
        }
    }


}