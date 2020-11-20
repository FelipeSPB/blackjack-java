package house;

import blackjack.BlackjackMatch;
import blackjack.Card;

import java.util.ArrayList;
import java.util.Scanner;

import static blackjack.BlackjackMethods.countValues;

public class Player {


    private ArrayList<Chip> chips = new ArrayList<Chip>();
    private ArrayList<Card> cards = new ArrayList<Card>();
    private Boolean status = false;

    public Player(){
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }

    public void setChips(ArrayList<Chip> chips) {
        this.chips = chips;
    }

    public void putBet(ArrayList<Chip> chipsBet){
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
            System.out.println("Type 1 for add one card; type 2 to stand; type 3 to place bet");
            String choiceMade = inputPlayer.nextLine();
            if (choiceMade.equals("1")) {
                match.getDealer().giveCard(cards);
                System.out.println("This card was added to your hand:"+ getCards().get((getCards().size() - 1)));
                setStatus(false);
            }
            if (choiceMade.equals("2")) {
                setStatus(true);
            }
            if (choiceMade.equals("3")) {
                System.out.println("To be implemented;");
            }
        }
    }

    public int getSumCard(ArrayList<Card> cards){
        return countValues(cards);
    }



}
