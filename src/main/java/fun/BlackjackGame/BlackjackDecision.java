package fun.BlackjackGame;

import fun.Cards;
import fun.Dealer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackDecision extends BlackjackCore {


    public Cards dealOneCard(){
        return Cards.getRandomCard();
    }

    public void hit (BlackjackSeat seat){
        Cards card = dealOneCard();
        seat.getPlayersCard().add(card);
        seat.setScore(scoreUpdate(seat.getPlayersCard()));
        printPlayersCardsAndScore(seat);

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


         BlackjackSplitHand handOne = new BlackjackSplitHand(cardsHandOne);
         handOne.setScore(scoreUpdate(handOne.getPlayersCard()));

         BlackjackSplitHand handTwo = new BlackjackSplitHand(cardsHandTwo);
         handTwo.setScore(scoreUpdate(handTwo.getPlayersCard()));

         List<BlackjackSplitHand> hands = new ArrayList<>();
         hands.add(handOne);
         hands.add(handTwo);
         seat.setHands(hands);
     }

     private void hitForSplit (BlackjackSplitHand hand){
         Cards card = dealOneCard();
         hand.getPlayersCard().add(card);
         hand.setScore(scoreUpdate(hand.getPlayersCard()));
         printPlayersCardsAndScore(hand);

     }

    public void decisionMakingIfSplit (BlackjackSeat seat){
        int handNumber = 1;

        for (BlackjackSplitHand hand: seat.getHands()){
            System.out.println("Your cards on hand "+handNumber+" are: "+hand.getPlayersCard()+" Total score: "+hand.getScore());
            while (hand.getScore()<21){
                System.out.println("Please make your decision for hand "+handNumber+" (Hit or Stand):");
                String decision = scanner.next();
                if (decision.equalsIgnoreCase("Hit")){
                    new BlackjackDecision().hitForSplit(hand);
                }else {break;}

            }
            handNumber=handNumber+1;
        }
    }

    public void dealersDecision (Dealer dealer){
        printSeparator();
        while (dealer.getScore()<17){
            BlackjackDecision blackjackDecision = new BlackjackDecision();
            Cards card = blackjackDecision.dealOneCard();
            dealer.getDealersCards().add(card);
            dealer.setScore(scoreUpdate(dealer.getDealersCards()));
            hasBlackjack(dealer);
            if (dealer.getHasBlackjack()){
                System.out.println("Dealer's hand: "+dealer.getDealersCards()+" Total score: "+dealer.getScore());
                System.out.println("Dealer has blackjack!");
                break;
            }else {
                System.out.println("Dealer's hand: "+dealer.getDealersCards()+" Total score: "+dealer.getScore());
            }
        }
        printSeparator();
    }

    private void hasBlackjack (Dealer dealer){

        if (dealer.getDealersCards().get(0).getScore()+
                dealer.getDealersCards().get(1).getScore()==21){
            dealer.setHasBlackjack(true);
        }else {dealer.setHasBlackjack(false);}

    }

}
