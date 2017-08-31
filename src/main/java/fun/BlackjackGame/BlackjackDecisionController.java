package fun.BlackjackGame;

import fun.*;

import java.util.Scanner;

/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackDecisionController extends BlackjackCore{

    public BlackjackDecisionController(Player player, Dealer dealer) {
        decisionMaking(player, dealer);
    }

    private void decisionMaking (Player player, Dealer dealer){

        int seatNumber =1;
        for (BlackjackSeat seat : player.getSeats()){

            printSeparator();

             while (seat.getScore()<21){


               if (firstTwoCardsHasEqualValue(seat)
                       &playerHasOnlyTwoCards(seat)
                       &!(player.getWallet().getBalance()<seat.getBet())){
               System.out.println("Please make your decision (Hit, Stand, DoubleDown or Split) for seat "+seatNumber+" :");
               String decision = scanner.next();
                   if (decision.equalsIgnoreCase("Hit")){
                       new BlackjackDecision().hit(seat);
                   }else if (decision.equalsIgnoreCase("DoubleDown")){
                       doubleOrSplitBetDeduction(seat,player);
                       new BlackjackDecision().hit(seat);
                       break;
                   }else if (decision.equalsIgnoreCase("Split")) {
                       doubleOrSplitBetDeduction(seat,player);
                       new BlackjackDecision().split(seat);
                       new BlackjackDecision().decisionMakingIfSplit(seat);
                       break;
                   }else {break;}

               } else if (playerHasOnlyTwoCards(seat)
                       &!(player.getWallet().getBalance()<seat.getBet())){
                System.out.println("Please make your decision (Hit, Stand or DoubleDown) for seat "+seatNumber+" :");
                String decision = scanner.next();
                if (decision.equalsIgnoreCase("Hit")){
                    new BlackjackDecision().hit(seat);
                }else if (decision.equalsIgnoreCase("DoubleDown")){
                    doubleOrSplitBetDeduction(seat,player);

                    new BlackjackDecision().hit(seat);
                    break;
                }else {break;}

                } else {
                   System.out.println("Please make your decision (Hit or Stand) for seat "+seatNumber+" :");
                   String decision = scanner.next();
                   if (decision.equalsIgnoreCase("Hit")){
                       new BlackjackDecision().hit(seat);
                   }else {break;}
               }

             }
            seatNumber = seatNumber+1;
        }

        new BlackjackDecision().dealersDecision(dealer);

    }

    private boolean firstTwoCardsHasEqualValue(BlackjackSeat seat){
        return  (seat.getPlayersCard().get(0).getValue()==seat.getPlayersCard().get(1).getValue());
    }

    private boolean playerHasOnlyTwoCards (BlackjackSeat seat){
        return  (seat.getPlayersCard().size()==2);
    }


    private void doubleOrSplitBetDeduction (BlackjackSeat seat,Player player){

        player.getWallet().setBalance(player.getWallet().getBalance()-seat.getBet());
        seat.setBet(seat.getBet()*2);
        seat.setDoubledBet(true);
        System.out.println("Your total balance after this decision is: "+player.getWallet().getBalance());

    }

}



