package racinggame.domains;

public class Car {
    private String name;
    private int position;

    public Car() {
        this.name = "";
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
