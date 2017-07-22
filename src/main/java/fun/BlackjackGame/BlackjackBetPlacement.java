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

        for (BlackjackSeat seat : player.getSeats()){

            System.out.println("Please enter bet amount to place on seat:");
            seat.setBet(scanner.nextDouble());
            player.getWallet().setBalance(player.getWallet().getBalance()-seat.getBet());
            System.out.println("Your total balance is: "+player.getWallet().getBalance());
            printSeparator();

        }

    }
}
