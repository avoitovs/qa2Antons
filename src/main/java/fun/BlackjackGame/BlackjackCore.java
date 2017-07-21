package fun.BlackjackGame;

import fun.Cards;
import fun.Dealer;

import java.util.List;
import java.util.Scanner;

/**
 * Created by antons on 19/07/2017.
 */
public class BlackjackCore {

    public Scanner scanner = new Scanner(System.in);


    public int scoreUpdate (BlackjackSeat seat){

        int temp = 0;
        List<Cards> listOfCards = seat.getPlayersCard();

        if (listOfCards.size()==2) {
            int score = listOfCards.get(0).getScore()+listOfCards.get(1).getScore();
            if (score>21){
                score=score-10;
            }
            return score;
        }

        for (Cards card : listOfCards){

            if (card.equals(Cards.ACE_CLUBS)||
                    card.equals(Cards.ACE_DIAMOND)||
                    card.equals(Cards.ACE_HEARTS)||
                    card.equals(Cards.ACE_SPADES)){
                if (seat.getScore()+card.getScore()>=22){
                    card.setScore(1);
                    temp = temp+card.getScore();
                    card.setScore(11);
                }else if (seat.getScore()+card.getScore()<=21){
                    temp = temp+card.getScore();
                }
            } else {
                temp = temp+card.getScore();
            }

        }

        return temp;
    }

    public int scoreUpdate (BlackjackSplitHand hand){

        int temp = 0;
        List<Cards> listOfCards = hand.getPlayersCard();

        if (listOfCards.size()==2) {
            int score = listOfCards.get(0).getScore()+listOfCards.get(1).getScore();
            if (score>21){
                score=score-10;
            }
            return score;
        }

        for (Cards card : listOfCards){

            if (card.equals(Cards.ACE_CLUBS)||
                    card.equals(Cards.ACE_DIAMOND)||
                    card.equals(Cards.ACE_HEARTS)||
                    card.equals(Cards.ACE_SPADES)){
                if (hand.getScore()+card.getScore()>=22){
                    card.setScore(1);
                    temp = temp+card.getScore();
                    card.setScore(11);
                }else if (hand.getScore()+card.getScore()<=21){
                    temp = temp+card.getScore();
                }
            } else {
                temp = temp+card.getScore();
            }

        }

        return temp;
    }
    public int scoreUpdate (Dealer dealer){

        int temp = 0;
        List<Cards> listOfCards = dealer.getDealersCards();

        if (listOfCards.size()==2) {
            int score = listOfCards.get(0).getScore()+listOfCards.get(1).getScore();
            if (score>21){
                score=score-10;
            }
            return score;
        }

        for (Cards card : listOfCards){

            if (card.equals(Cards.ACE_CLUBS)||
                    card.equals(Cards.ACE_DIAMOND)||
                    card.equals(Cards.ACE_HEARTS)||
                    card.equals(Cards.ACE_SPADES)){
                if (dealer.getScore()+card.getScore()>=22){
                    card.setScore(1);
                    temp = temp+card.getScore();
                    card.setScore(11);
                }else if (dealer.getScore()+card.getScore()<=21){
                    temp = temp+card.getScore();
                }
            } else {
                temp = temp+card.getScore();
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

}















