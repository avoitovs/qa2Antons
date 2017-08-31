package fun.BlackjackGame;

import fun.Cards;
import fun.Core;
import fun.Dealer;
import fun.Player;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by antons on 19/07/2017.
 */
public class BlackjackCore extends Core {

    public int scoreUpdate (List<Cards> lisOfCards){

        int temp = 0;

        Predicate<Cards> notAce = u -> u.getValue()!=14;
        Predicate<Cards> Ace = u -> u.getValue()==14;

        List<Cards> withoutAces = lisOfCards.stream()
                .filter(notAce)
                .collect(Collectors.toList());

        for (Cards card : withoutAces){

            temp = temp+card.getScore();

        }

        List<Cards> withAces = lisOfCards.stream()
                .filter(Ace)
                .collect(Collectors.toList());
        for (Cards card : withAces){


            if (temp>9
                    & withAces.size()>1){
                card.setScore(1);               //if there are several aces and other cards have score more than 9
                temp = temp+card.getScore();    // then all aces are treated as 1's
                card.setScore(11);
            continue;
            }

            if (temp+card.getScore()>21){
                card.setScore(1);
                temp = temp+card.getScore();
                card.setScore(11);
            }else if (temp+card.getScore()<22) {
                temp = temp + card.getScore();
            }
        }

        return temp;
    }


    public void printPlayersCardsAndScore (BlackjackSeat seat, int seatNumber){

        System.out.println("Player's cards on seat "+ seatNumber +": "+seat.getPlayersCard()+" Total score: "+seat.getScore());

    }

    public void printDealersInitialCard (Dealer dealer){

        System.out.println();
        System.out.println("Dealer's face up card: "+dealer.getDealersCards()+" Total score: "+dealer.getScore());
        System.out.println();

    }

    public void printPlayersCardsAndScore (BlackjackSeat seat){

        System.out.println("Your hand: "+seat.getPlayersCard()+" Total score: "+seat.getScore());

    }
    public void printPlayersCardsAndScore (BlackjackSplitHand hand){

        System.out.println("Your hand: "+hand.getPlayersCard()+" Total score: "+hand.getScore());

    }

    public void printSeparator (){

        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println();

    }

    public void printTotalBalance(Player player){
        System.out.println("Your total balance is: "+player.getWallet().getBalance());
        System.out.println("-------------");
    }


}















