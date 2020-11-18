package application;

import blackjack.BlackjackMatch;
import house.Dealer;
import house.Player;

import java.util.Scanner;

public interface UI {

    static void printGame(BlackjackMatch match){
        System.out.println("You have these cards: " + match.getPlayer().getCards());
        System.out.println(" ");
        System.out.println("The sum of your cards are: "+ match.countValues(match.getPlayer().getCards()));
        System.out.println("What do you gonna do ?");
        choice(match);
    }

     static void choice(BlackjackMatch match){
        Scanner inputPlayer = new Scanner(System.in);
        System.out.println("Type 1 for add one card; type 2 to stand; type 3 to place bet");
        String choiceMade = inputPlayer.nextLine();
        if(choiceMade.equals("1")){
            match.getDealer().giveCard(match.getPlayer().getCards());
        }
        if(choiceMade.equals("2")){
            System.out.println("You Wished To Hold The Card");
        }
        if(choiceMade.equals("3")){
            System.out.println("To be implemented;");
        }
    }







}
