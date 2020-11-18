package blackjack;

import blackjack.enums.CardTypes;
import blackjack.enums.Naipe;

public class Card {

    Naipe naipe;
    CardTypes type;
    int value;

    public Card(Naipe naipe, CardTypes type) {
        this.naipe = naipe;
        this.type = type;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public CardTypes getName() {
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
