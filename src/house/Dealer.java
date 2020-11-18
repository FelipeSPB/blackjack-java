package house;


import blackjack.Card;
import house.enums.ChipColor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dealer {

    ArrayList<Card> selfCards = new ArrayList<Card>();
    ArrayList<Card> deck;
    ArrayList<Chip> chipsHouse;
    ArrayList<Chip> chipsBet;

    public Dealer() {
    }


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

    public void shuffleCards() {
        Collections.shuffle(deck);
    }

    public void giveCard(ArrayList<Card> cards) {
        if (deck.size() > 0) {
            cards.add(deck.get(0));
            deck.remove(0);
        }
    }
;
    public void dealerTurn(int sumHisCards) {
        if (sumHisCards < 11) {
            giveCard(selfCards);
        }
        String[] choices = new String[]{"dunce", "conservative", "aggressive"};
        int randomIndex = new Random().nextInt(3);
        System.out.println("The dealer was: " + choices[randomIndex]);
        if (choices[randomIndex].equals("dunce")) {
                dunceBehavior(sumHisCards);

            }
            if (choices[randomIndex].equals("conservative")) {
                conservativeBehavior(sumHisCards);
            }
            if (choices[randomIndex].equals("aggresive")) {
                aggressiveBehavior(sumHisCards);
            }
        System.out.println(selfCards);
    }


    private void dunceBehavior(int sumHisCards) {
        boolean amoebaThinking = sumHisCards >= 11 && sumHisCards < 17;
        if (!amoebaThinking && sumHisCards < 21) {
            giveCard(selfCards);
        }
    }

    private void conservativeBehavior(int sumHisCards) {
        boolean conservativeMind = sumHisCards >= 17 && 21 > sumHisCards;
        if (!conservativeMind) {
            giveCard(selfCards);
        }
    }

    private void aggressiveBehavior(int sumHisCards){
        boolean blackjackOrDeath = sumHisCards == 20;
        if(!blackjackOrDeath){
            giveCard(selfCards);
        }
    }


};


