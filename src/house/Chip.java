package house;

import house.enums.ChipColor;

public class Chip {

    private ChipColor color;
    private int value = color.getValue();

    public ChipColor getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    public void setColor(ChipColor color) {
        this.color = color;
    }

    public Chip(ChipColor color) {
        this.color = color;
    }


}
