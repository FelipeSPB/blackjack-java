package house;


import blackjack.Card;
import house.enums.ChipColor;
import java.util.ArrayList;
import java.util.Collections;

public class Dealer {

    ArrayList<Card> selfCards = new ArrayList<Card>();
    ArrayList<Card> deck;
    ArrayList<Chip> chipsHouse;
    ArrayList<Chip> chipsBet;

    public Dealer() {}


    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Card> getSelfCards() {
        return selfCards;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    protected ArrayList<Chip> exchangeChip(Chip chipToExchange, ChipColor option, ArrayList<Chip> chips) {
        for (int qtdChips = chipToExchange.getValue() / option.getValue(); qtdChips > 0; qtdChips--) {
            chips.add(new Chip(option));
        }
        for (Chip indexChip : chips) {
            if (indexChip == chipToExchange) {
                chips.remove(chipToExchange);
            }
        }
        return chips;
    }

    public void shuffleCards(){
        Collections.shuffle(deck);
    }

    public void giveCard(ArrayList<Card> cards){
        if(deck.size() > 0){
                cards.add(deck.get(0));
                deck.remove(0);
        }
    }




}

