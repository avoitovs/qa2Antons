package fun.BlackjackGame;

import fun.Player;

/**
 * Created by antons on 21/07/2017.
 */
public class BlackjackBetPlacement extends BlackjackCore {

    private Player player;

    public BlackjackBetPlacement(Player player) {
        this.player = player;
        placeBet();
    }

    private void placeBet (){

        System.out.println("Your total balance is: "+player.getWallet().getBalance());

        int seatNumber = 1;

        for (BlackjackSeat seat : player.getSeats()){

            betPlacement(seat,seatNumber);
            seatNumber = seatNumber+1;
        }

    }


    private boolean isBetValid (Double bet){

        if (player.getWallet().getBalance()-bet<0){

            System.out.println("INVALID BET! Insufficient funds!");
            return false;

        }
        if (bet<1){

            System.out.println("INVALID BET! Bet is less than table minimum limit!");
            return false;

        }
        return true;

    }

    private void betPlacement (BlackjackSeat seat, int seatNumber){

        System.out.println("Please enter bet amount to place on seat "+seatNumber+":");
        Double bet = scanner.nextDouble();
        if (isBetValid(bet)){
            seat.setBet(bet);
            player.getWallet().setBalance(player.getWallet().getBalance()-seat.getBet());
            printTotalBalance(player);
            }
        else {betPlacement(seat,seatNumber);}

    }








}
