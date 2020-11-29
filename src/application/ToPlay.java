package application;

import blackjack.BlackjackMatch;
import blackjack.BlackjackMethods;
import house.Dealer;
import house.Player;

public interface ToPlay {

    static void playBlackjack(){
        Player me = new Player();
        Dealer mrDealer = new Dealer();
        BlackjackMatch match = new BlackjackMatch(me, mrDealer);
        UI.welcomePrint();
        match.setupMatch();
        while(true){
            if(!BlackjackMethods.checkingResults(me,mrDealer)){
                if(BlackjackMethods.checkingAmounts(me,mrDealer)){
                    match = new BlackjackMatch(me, mrDealer);
                    UI.welcomePrint();
                    match.setupMatch();
                }else{
                    UI.printResults(me.getAmount(),300);
                    System.out.println("Thanks for playing !");
                    break;
                }

            }
            UI.printGame(match);
        }
    }

}
