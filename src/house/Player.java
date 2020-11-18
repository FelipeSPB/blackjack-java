package house;

import blackjack.Card;

import java.util.ArrayList;

public class Player {

    ArrayList<Chip> chips = new ArrayList<Chip>();
    ArrayList<Card> cards = new ArrayList<Card>();

    public Player(){
    }

    public void putBet(ArrayList<Chip> chipsBet){
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
