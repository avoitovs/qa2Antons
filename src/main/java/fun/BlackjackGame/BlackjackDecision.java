package fun.BlackjackGame;

import fun.Cards;
import fun.Hand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackDecision {



    public Cards dealOneCard(){
        return Cards.getRandomCard();
    }

    public void hit (BlackjackSeat seat){
        Cards card = dealOneCard();
        seat.getPlayersCard().add(card);
        updateScore(seat,card);
        System.out.println("Your hand: "+seat.getPlayersCard()+" Total score: "+seat.getScore());

    }

    public void updateScore(BlackjackSeat seat, Cards card){

        if (card.equals(Cards.ACE_CLUBS)||
                card.equals(Cards.ACE_DIAMOND)||
                card.equals(Cards.ACE_HEARTS)||
                card.equals(Cards.ACE_SPADES)){
            if (seat.getScore()+card.getScore()>22){
                card.setScore(1);
                seat.setScore(seat.getScore()+card.getScore());
                card.setScore(11);
            }else if (seat.getScore()+card.getScore()<22){
                seat.setScore(seat.getScore()+card.getScore());
            }
        } else {
            seat.setScore(seat.getScore()+card.getScore());
        }

    }
    public void updateScore(Hand hand, Cards card){

        if (card.equals(Cards.ACE_CLUBS)||
                card.equals(Cards.ACE_DIAMOND)||
                card.equals(Cards.ACE_HEARTS)||
                card.equals(Cards.ACE_SPADES)){
            if (hand.getScore()+card.getScore()>22){
                card.setScore(1);
                hand.setScore(hand.getScore()+card.getScore());
                card.setScore(11);
            }else if (hand.getScore()+card.getScore()<22){
                hand.setScore(hand.getScore()+card.getScore());
            }
        } else {
            hand.setScore(hand.getScore()+card.getScore());
        }

    }


     public void split (BlackjackSeat seat){

         List<Cards> cardsHandOne = new ArrayList<>();
         cardsHandOne.add(seat.getPlayersCard().get(0));
         Cards secondCardHandOne = dealOneCard();
         cardsHandOne.add(secondCardHandOne);


         List<Cards> cardsHandTwo = new ArrayList<>();
         cardsHandTwo.add(seat.getPlayersCard().get(1));
         Cards secondCardHandTwo = dealOneCard();
         cardsHandTwo.add(secondCardHandTwo);


         Hand handOne = new Hand(cardsHandOne);
         updateScore(handOne,seat.getPlayersCard().get(0));
         updateScore(handOne,secondCardHandOne);

         Hand handTwo = new Hand(cardsHandTwo);
         updateScore(handTwo,seat.getPlayersCard().get(1));
         updateScore(handTwo,secondCardHandTwo);

         List<Hand> hands = new ArrayList<>();
         hands.add(handOne);
         hands.add(handTwo);
         seat.setHands(hands);
     }

     public void hitForSplit (Hand hand){
         Cards card = dealOneCard();
         hand.getPlayersCard().add(card);
         updateScore(hand,card);
         System.out.println("Your hand: "+hand.getPlayersCard()+" Total score: "+hand.getScore());

     }

}
