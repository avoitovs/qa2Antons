package fun.BlackjackGame;

import fun.Dealer;
import fun.Player;


/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackGameInitialization extends BlackjackCore {

    private Player player;
    private Dealer dealer;

    public BlackjackGameInitialization(Player player, Dealer dealer) {
        this.player = player;
        this.dealer=dealer;
        System.out.println(player.getPlayersName()+", welcome to our blackjack game! ");
        System.out.println("--------------------------");
        getAmountOfSeats();
        player.setBlackjackRoundsHistory(new BlackjackRound(player, dealer));
        playAgain();
    }


    private void getAmountOfSeats (){
        System.out.println("How many seats you want to play:");
        player.setAmountOfSeats(scanner.nextInt());
        player.setSeats();
    }


    private void playAgain(){

        System.out.println(player.getPlayersName()+", would you like to play again? (Yes / No)");
        String cont = scanner.next();
        if (cont.equalsIgnoreCase("YES")){

            if (player.getWallet().getBalance()!=0){
            player.setBlackjackRoundsHistory(new BlackjackRound(player, dealer));
            playAgain();}
            else {
                System.out.println("Insufficient funds to start new round!");
                System.out.println();
                System.out.println("Thank you for the game! Have a nice day!");
            }
        } else {
            System.out.println("Thank you for the game! Have a nice day!");
        }

    }
}