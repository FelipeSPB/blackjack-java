package blackjack;

import house.Dealer;
import house.Player;

import java.util.ArrayList;

public interface BlackjackMethods {

    public static int countValues(ArrayList<Card> cards){
        int totalValue = 0;
        for (Card indexCard: cards) {
            totalValue += indexCard.getValue();
        }
        return totalValue;
    }

    static boolean checkingResults(Player player, Dealer dealer){
        int playerSum = player.getSumCard(player.getCards());
        int dealerSum = dealer.getSumCard(dealer.getSelfCards());

        //check 21
        if(playerSum == 21){
            System.out.println("WOW ! You've got Blackjack, congratulations... try to be careful, because the mobsters are watching.");
            System.out.println("The house had: "+dealer.getSelfCards());

            return false;
        }
        if (dealerSum == 21){
            System.out.println("The house has: "+dealer.getSelfCards());
            System.out.println("Well my friend... the house had a blackjack. Look... the mobsters are smiling for your loss...");
            return false;
        }
        // check burst
        if (playerSum > 21){
            System.out.println("Well my friend... you busted... the house won. Look... the mobsters are smiling for your loss...");
            System.out.println("The house had: "+dealer.getSelfCards());
            return false;
        }
        if (dealerSum > 21){
            System.out.println("This...is strange, the house busted... by the look of the mobsters, i think the dealer won't return to his home today.");
            System.out.println("The house had: "+dealer.getSelfCards());
            return false;
        }
        // check status
        if(dealer.getStatus() && player.getStatus() && playerSum > dealerSum ){
            System.out.println("The house has: "+dealer.getSelfCards());
            System.out.println("WOW ! You win, congratulations... try to be careful, because the mobsters are watching.");
            return false;
        }
        if (dealer.getStatus() && player.getStatus() && dealerSum > playerSum){
            System.out.println("The house has: "+dealer.getSelfCards());
            System.out.println("Well... you lose... The mobsters are happy, look at their smiles...");
            return false;
        }
        if(dealer.getStatus() && player.getStatus() && playerSum == dealerSum){
            System.out.println("The house has: "+dealer.getSelfCards());
            System.out.println("It's a draw... everyone is looking to you and talking of this miracle event... you'll be famous and for the kind of the mobsters, they exchanged the chips that you'd have if you win and gave the money. It's a good thing, isn't ?");
            return false;
        }
        return true;
    };

}
