package application;

import blackjack.BlackjackMatch;
import blackjack.BlackjackMethods;
import house.Dealer;
import house.Player;

public class Program {

    public static void main(String[] args) {
        Player me = new Player();
        Dealer mrDealer = new Dealer();
        BlackjackMatch match = new BlackjackMatch(me, mrDealer);
        UI.welcomePrint();
        match.setupMatch();
        while(true){

            if(!BlackjackMethods.checkingResults(me,mrDealer)){
                System.out.println("Thanks for playing !");
                break;
            }
            UI.printGame(match);

        }
    }
}
