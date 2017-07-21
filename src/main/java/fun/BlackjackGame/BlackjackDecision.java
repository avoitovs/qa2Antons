package fun.BlackjackGame;

import fun.Cards;
import fun.Hand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackDecision {
    BlackjackCore core = new BlackjackCore();



    public Cards dealOneCard(){
        return Cards.getRandomCard();
    }

    public void hit (BlackjackSeat seat){
        Cards card = dealOneCard();
        seat.getPlayersCard().add(card);
        seat.setScore(core.scoreUpdate(seat));
        System.out.println("Your hand: "+seat.getPlayersCard()+" Total score: "+seat.getScore());

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
         handOne.setScore(core.scoreUpdate(handOne));

         Hand handTwo = new Hand(cardsHandTwo);
         handTwo.setScore(core.scoreUpdate(handTwo));

         List<Hand> hands = new ArrayList<>();
         hands.add(handOne);
         hands.add(handTwo);
         seat.setHands(hands);
     }

     public void hitForSplit (Hand hand){
         Cards card = dealOneCard();
         hand.getPlayersCard().add(card);
         hand.setScore(core.scoreUpdate(hand));
         System.out.println("Your hand: "+hand.getPlayersCard()+" Total score: "+hand.getScore());

     }

}
