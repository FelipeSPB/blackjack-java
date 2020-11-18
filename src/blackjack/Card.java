package blackjack;

import blackjack.enums.CardNames;
import blackjack.enums.Naipe;

public class Card {

    Naipe naipe;
    CardNames type;
    int value;

    public Card(Naipe naipe, CardNames type) {
        this.naipe = naipe;
        this.type = type;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public CardNames getName() {
        return type;
    }

    public int getValue() {
        return type.getValue();
    }

    @Override
    public String toString() {
        return type + " of " + naipe;
    }
}
