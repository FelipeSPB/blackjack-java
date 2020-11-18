package blackjack;

import blackjack.enums.CardTypes;
import blackjack.enums.Naipe;
import house.Dealer;
import house.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackjackMatch {

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    private Player player;
    private Dealer dealer;

    public BlackjackMatch(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }

    public int countValues(ArrayList<Card> cards){
        int totalValue = 0;
        for (Card indexCard: cards) {
            totalValue += indexCard.getValue();
        }
        return totalValue;
    }


    public void setupMatch(){
        ArrayList<Card> deck = new ArrayList<Card>();
        List<Naipe> naipes = Arrays.asList(Naipe.values());
        List<CardTypes> cardTypes = Arrays.asList(CardTypes.values());
        for (int i = 0; i < naipes.size(); i++) {
            for (int j = 0; j < cardTypes.size(); j++) {
                deck.add(new Card(naipes.get(i),cardTypes.get(j)));

            }
        }
        dealer.setDeck(deck);
        dealer.shuffleCards();

        //testing the deck

        System.out.println(dealer.getDeck());

        dealer.giveCard(player.getCards());
        dealer.giveCard(dealer.getSelfCards());
        dealer.giveCard(player.getCards());
        dealer.giveCard(dealer.getSelfCards());
    }







}
