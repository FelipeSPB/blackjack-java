package application;

import blackjack.BlackjackMatch;
import house.Dealer;
import house.Player;

public class Program {

    public static void main(String[] args) {
        Player me = new Player();
        Dealer mrDealer = new Dealer();
        BlackjackMatch match = new BlackjackMatch(me, mrDealer);
        match.setupMatch();
        while(true){
            UI.printGame(match);
            mrDealer.dealerTurn(match.countValues(mrDealer.getSelfCards()));
        }
    }
}
