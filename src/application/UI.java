package application;

import blackjack.BlackjackMatch;
import house.Dealer;
import house.Player;

import java.util.Scanner;

public interface UI {

    static void welcomePrint(){
        System.out.println("--------------------------------------------------");
        System.out.println("Welcome to our cassino !");
        System.out.println("--------------------------------------------------");
    }

    static void printGame(BlackjackMatch match){
        System.out.println("You have these cards: " + match.getPlayer().getCards());
        System.out.println("The sum of your cards are: "+ match.getPlayer().getSumCard(match.getPlayer().getCards()));
        System.out.println("What do you gonna do ?");
        match.getPlayer().playerChoice(match);
        Scanner input = new Scanner(System.in);
        System.out.println("Do you wish place a bet ? Y- yes / N - no ");
        String inputBet = input.nextLine();
        if(inputBet.equals("Y") && match.getPlayer().getBetStatus() == false) {
            match.getDealer().gettingTheBets(match.getPlayer().placeBet());
        }else{
            System.out.println("You've already placed a bet.");
        }
        System.out.println("----------------------");
        System.out.println("Dealers Turn");
        match.getDealer().dealerTurn(match.getDealer().getSumCard(match.getDealer().getSelfCards()));
        System.out.println("----------------------");
    }









}
