package house.enums;

public enum ChipColor {
    BLUE(5),
    GREEN(10),
    RED(15),
    PURPLE(20),
    ORANGE(25),
    YELLOW(50),
    WHITE(75),
    BLACK(100);


    private int value;

    ChipColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
