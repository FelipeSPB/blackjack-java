package house;


import blackjack.Card;
import house.enums.ChipColor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static blackjack.BlackjackMethods.countValues;

public class Dealer {

   private ArrayList<Card> selfCards = new ArrayList<Card>();
   private ArrayList<Card> deck;
   private ArrayList<Chip> chipsHouse;
   private ArrayList<Chip> chipsBet;
   private Boolean status = false;


    public Dealer() {
    }



    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Card> getSelfCards() {
        return selfCards;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public void dealerTurn(int sumHisCards) {
        if(status){
            System.out.println("The dealer is waiting for you !");
        }
        else{
            String[] choices = new String[]{"dunce", "conservative", "aggressive"};
            int randomIndex = new Random().nextInt(3);
            if (choices[randomIndex].equals("dunce")) {
                dunceBehavior(sumHisCards);

            }
            if (choices[randomIndex].equals("conservative")) {
                conservativeBehavior(sumHisCards);
            }
            if (choices[randomIndex].equals("aggresive")) {
                aggressiveBehavior(sumHisCards);
            }
        }
    }

    private void dunceBehavior(int sumHisCards) {
        boolean amoebaThinking = sumHisCards >= 11 && sumHisCards < 17;
        if (!amoebaThinking && 21 > sumHisCards) {
            giveCard(selfCards);
            System.out.println("The dealer added a card for his hand.");
        }
        else{
            setStatus(true);
            System.out.println("The Dealer Stands!");
        }
    }

    private void conservativeBehavior(int sumHisCards) {
        boolean conservativeMind = sumHisCards >= 17 && 21 > sumHisCards;
        if (!conservativeMind) {
            giveCard(selfCards);
            System.out.println("The dealer added a card for his hand.");
        }
        else{
            setStatus(true);
            System.out.println("The Dealer Stands!");
        }
    }

    private void aggressiveBehavior(int sumHisCards){
        boolean blackjackOrDeath = sumHisCards == 20;
        if(!blackjackOrDeath){
            giveCard(selfCards);
            System.out.println("The dealer added a card for his hand.");
        }
        else {
            setStatus(true);
            System.out.println("The Dealer Stands!");
        }
    }

    public int getSumCard(ArrayList<Card> cards){
        return countValues(cards);
    }

};


