package blackjack;

import blackjack.enums.CardNames;
import blackjack.enums.Naipe;
import house.Dealer;
import house.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackjackMatch {

    private Player player;
    private Dealer dealer;

    public BlackjackMatch(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }

    public void setupMatch(){
        ArrayList<Card> deck = new ArrayList<Card>();
        List<Naipe> naipes = Arrays.asList(Naipe.values());
        List<CardNames> cardTypes = Arrays.asList(CardNames.values());
        for (int i = 0; i < naipes.size(); i++) {
            for (int j = 0; j < cardTypes.size(); j++) {
                deck.add(new Card(naipes.get(i),cardTypes.get(j)));

            }
        }
        dealer.setDeck(deck);
        dealer.shuffleCards();
        System.out.println(dealer.getDeck());
        dealer.giveCard(player.getCards());
        dealer.giveCard(player.getCards());
        dealer.giveCard(dealer.getSelfCards());
        dealer.giveCard(dealer.getSelfCards());
        System.out.println(dealer.getSelfCards());
        System.out.println(player.getCards());

    }







}
