package fun;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antons on 15/07/2017.
 */
public class Decision  {

    private List<Hand> hands = new ArrayList<>();

    public Cards dealOneCard(){
        return Cards.getRandomCard();
    }

    public void hit (Seat seat){
        Cards card = dealOneCard();
        seat.getPlayersCard().add(card);
        seat.setScore(seat.getScore()+card.getScore());
        System.out.println("Your hand: "+seat.getPlayersCard()+" Total score: "+seat.getScore());


    }

     public void split (Seat seat){

         List<Cards> cardsHandOne = new ArrayList<>();
         cardsHandOne.add(seat.getPlayersCard().get(0));
         cardsHandOne.add(dealOneCard());


         List<Cards> cardsHandTwo = new ArrayList<>();
         cardsHandTwo.add(seat.getPlayersCard().get(1));
         cardsHandTwo.add(dealOneCard());


         Hand handOne = new Hand(cardsHandOne);
         Hand handTwo = new Hand(cardsHandTwo);
         hands.add(handOne);
         hands.add(handTwo);
         seat.setHands(hands);
     }

     public void hitForSplit (Hand hand){
         Cards card = dealOneCard();
         hand.getPlayersCard().add(card);
         hand.setScore(hand.getScore()+card.getScore());

     }

}
