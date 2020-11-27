package house;

import blackjack.BlackjackMatch;
import blackjack.Card;

import java.util.ArrayList;
import java.util.Scanner;

import static blackjack.BlackjackMethods.countValues;

public class Player {



    private ArrayList<Card> cards = new ArrayList<Card>();
    private Boolean status = false;
    private int amount = 300;
    private Boolean betStatus = false;


    public Player(){
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getBetStatus() {
        return betStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }


    public void playerChoice (BlackjackMatch match) {
        if (status) {
            System.out.println("You Wished To Hold The Card, please wait for the dealers turns.");
        }
        else {
            Scanner inputPlayer = new Scanner(System.in);
            System.out.println("Type 1 for add one card; type 2 to stand;");
            String choiceMade = inputPlayer.nextLine();
            if (choiceMade.equals("1")) {
                match.getDealer().giveCard(cards);
                System.out.println("This card was added to your hand:"+ getCards().get((getCards().size() - 1)));
                setStatus(false);
            }
            if (choiceMade.equals("2")) {
                setStatus(true);
            }
         }
    }

    public int getSumCard(ArrayList<Card> cards){
        return countValues(cards);
    }

    public int placeBet() {
        if (betStatus){
            System.out.println("You've already placed a bet.");
            return 0;
        }
        int betWished;
        do{
            Scanner valueBet = new Scanner(System.in);
            System.out.println("Write the value do you want to bet, but don't use decimals.");
            betWished = valueBet.nextInt();
            if (betWished > amount){
                System.out.println("Insufficient money...");
            }
        }while(betWished > amount);
        betStatus = true;
        amount -= betWished;
        return betWished;
    }

}
