package fun.BlackjackGame;

import fun.Dealer;
import fun.Player;


public class BlackjackResultCounter extends BlackjackCore {

    private Player player;
    private Dealer dealer;

    public BlackjackResultCounter(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
        printResults();
    }

    private void printResults (){

        int seatNumber = 1;

        for (BlackjackSeat seat : player.getSeats()){

            if (seat.getHands()!=null){
                System.out.println("On the seat number "+seatNumber+" :");
                int handNumber = 1;
                for (BlackjackSplitHand hand : seat.getHands()){
                    if (hand.getScore()>dealer.getScore() & hand.getScore()<22 |
                            hand.getScore()<22 & dealer.getScore()>21){
                        System.out.println("          Player won on "+handNumber+" hand!");
                    } else if (hand.getScore()==dealer.getScore()&&hand.getScore()<22){
                        System.out.println("          Push for "+handNumber+" hand!");
                    } else {
                        System.out.println("          Dealer won against "+handNumber+" hand!");
                    }
                    handNumber = handNumber+1;
                }
                seatNumber=seatNumber+1;
                continue;
            }

            if ((seat.getScore()>dealer.getScore() & seat.getScore()<22) |
                    (seat.getScore()<22 & dealer.getScore()>21)|
                    (seat.getHasBlackjack() & !dealer.getHasBlackjack())){
                System.out.println("Seat number "+seatNumber+" won!");
            } else if (seat.getScore()==dealer.getScore()&&seat.getScore()<22|
                    seat.getHasBlackjack() & dealer.getHasBlackjack()){
                System.out.println("Push for seat number "+seatNumber);
            } else {
                if (dealer.getHasBlackjack() & !seat.getHasBlackjack()){
                    System.out.println("Dealer won against seat "+seatNumber);
                }else {
                System.out.println("Dealer won against seat "+seatNumber);
                }
            }

            seatNumber = seatNumber+1;
        }

        printSeparator();
    }

}
