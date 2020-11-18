package house;

import house.enums.ChipColor;

public class Chip {

    ChipColor color;
    int value = color.getValue();

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
