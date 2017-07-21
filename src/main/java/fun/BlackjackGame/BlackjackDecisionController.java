package fun.BlackjackGame;

import fun.*;

import java.util.Scanner;

/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackDecisionController {

    private Scanner scanner = new Scanner(System.in);
    BlackjackCore core = new BlackjackCore();


    public void decisionMaking (Player player){

        int seatNumber =1;
        for (BlackjackSeat seat : player.getSeats()){

             while (seat.getScore()<21){


               if ((seat.getPlayersCard().get(0).getValue()==seat.getPlayersCard().get(1).getValue())
                       &(seat.getPlayersCard().size()==2)){
               System.out.println("Please make your decision (Hit, Stand, DoubleDown or Split) for seat "+seatNumber+" :");
               String decision = scanner.next();
                   if (decision.equalsIgnoreCase("Hit")){
                       new BlackjackDecision().hit(seat);
                   }else if (decision.equalsIgnoreCase("DoubleDown")){
                       new BlackjackDecision().hit(seat);
                       break;
                   }else if (decision.equalsIgnoreCase("Split")) {
                       new BlackjackDecision().split(seat);
                       decisionMakingIfSplit(seat);
                       break;
                   }else {break;}

               } else {
                System.out.println("Please make your decision (Hit, Stand or DoubleDown) for seat "+seatNumber+" :");
                String decision = scanner.next();
                if (decision.equalsIgnoreCase("Hit")){
                    new BlackjackDecision().hit(seat);
                }else if (decision.equalsIgnoreCase("DoubleDown")){
                    new BlackjackDecision().hit(seat);
                    break;
                }else {break;}

                }

             }
            seatNumber = seatNumber+1;
        }

    }

    private void decisionMakingIfSplit (BlackjackSeat seat){
        int handNumber = 1;

        for (Hand hand: seat.getHands()){
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
        while (dealer.getScore()<17){
            BlackjackDecision blackjackDecision = new BlackjackDecision();
            Cards card = blackjackDecision.dealOneCard();
            dealer.getDealersCards().add(card);
            dealer.setScore(core.scoreUpdate(dealer));
            hasBlackjack(dealer);
            if (dealer.getHasBlackjack()){
                System.out.println("Dealer has blackjack!");
                break;
            }else {
                System.out.println("Dealer's hand: "+dealer.getDealersCards()+" Total score: "+dealer.getScore());
            }
        }

    }

    private void hasBlackjack (Dealer dealer){

        if (dealer.getDealersCards().get(0).getScore()+
                        dealer.getDealersCards().get(1).getScore()==21){
            dealer.setHasBlackjack(true);
        }else {dealer.setHasBlackjack(false);}

    }

}



