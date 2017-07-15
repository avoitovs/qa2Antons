package fun;

import java.util.Scanner;

/**
 * Created by antons on 15/07/2017.
 */
public class GameController {
    Scanner scanner = new Scanner(System.in);


    public void decisionMaking (Player player){

        int seatNumber =1;
        for (Seat seat : player.getSeats()){

             while (seat.getScore()<21){


               if (seat.getPlayersCard().get(0).equals(seat.getPlayersCard().get(1))){
               System.out.println("Please make your decision (Hit, Stand, DoubleDown or Split) for seat "+seatNumber+" :");
               String decision = scanner.next();
                   if (decision.equalsIgnoreCase("Hit")){
                       new Decision().hit(seat);
                   }else if (decision.equalsIgnoreCase("DoubleDown")){
                       new Decision().hit(seat);
                       break;
                   }else if (decision.equalsIgnoreCase("Split")) {
                       new Decision().split(seat);
                       decisionMakingIfSplit(seat);
                   }else {break;}

               } else {
                System.out.println("Please make your decision (Hit, Stand or DoubleDown) for seat "+seatNumber+" :");
                String decision = scanner.next();
                if (decision.equalsIgnoreCase("Hit")){
                    new Decision().hit(seat);
                }else if (decision.equalsIgnoreCase("DoubleDown")){
                    new Decision().hit(seat);
                    break;
                }else {break;}

                }

             }
            seatNumber = seatNumber+1;
        }

    }

    private void decisionMakingIfSplit (Seat seat){
        int handNumber = 1;

        for (Hand hand: seat.getHands()){
            while (hand.getScore()<21){
                System.out.println("Please make your decision for hand "+handNumber+" (Hit or Stand):");
                String decision = scanner.next();
                if (decision.equalsIgnoreCase("Hit")){
                    new Decision().hitForSplit(hand);
                }else {break;}

            }
         handNumber=handNumber+1;
        }
    }

    public void dealersDecision (Dealer dealer){
        while (dealer.getScore()<17){
            Decision decision = new Decision();
            Cards card = decision.dealOneCard();
            dealer.getDealersCards().add(card);
            dealer.setScore(dealer.getScore()+card.getScore());
            System.out.println("Dealer's hand: "+dealer.getDealersCards()+" Total score: "+dealer.getScore());
        }

    }

}



