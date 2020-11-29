package blackjack;

import blackjack.enums.CardTypes;
import blackjack.enums.Naipe;
import house.Dealer;
import house.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackjackMatch {


    private Player player;
    private Dealer dealer;

    public Player getPlayer() {
        return player;
    }
    public Dealer getDealer() {
        return dealer;
    }


    public BlackjackMatch(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
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

        player.setCards(new ArrayList<Card>());
        dealer.setSelfCards(new ArrayList<Card>());
        dealer.setDeck(deck);
        dealer.shuffleCards();
        player.setStatus(false);
        player.setBetStatus(false);
        dealer.giveCard(player.getCards());
        dealer.giveCard(dealer.getSelfCards());
        dealer.giveCard(player.getCards());
        dealer.giveCard(dealer.getSelfCards());
        dealer.setBetSum(0);
        if(player.getAmount() == 0 && dealer.getHouseAmount() == 0){
            player.setAmount(300);
            dealer.setHouseAmount(1000);
        }
    }









}
