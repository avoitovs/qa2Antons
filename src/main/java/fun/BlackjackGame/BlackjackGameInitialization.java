package fun.BlackjackGame;

import fun.Dealer;
import fun.Player;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackGameInitialization extends BlackjackCore {

    private Player player;
    private Dealer dealer;

    public BlackjackGameInitialization(Player player, Dealer dealer) {
        this.player = player;
        this.dealer=dealer;
        getPlayersName();
        getAmountOfSeats();
        player.setBlackjackRoundsHistory(new BlackjackRound(player, dealer));
        playAgain();
    }

    private void getPlayersName(){

        System.out.println("WELCOME TO BLACKJACK GAME!");
        System.out.println("--------------------------");
        System.out.println("Please enter your name:");
        player.setPlayersName(scanner.nextLine());
        System.out.println("Hello "+player.getPlayersName()+", nice to see you!");
        System.out.println();
    }

    private void getAmountOfSeats (){
        System.out.println("How many seats you want to play:");
        player.setAmountOfSeats(scanner.nextInt());
        player.setSeats();
    }


    private void playAgain(){

        System.out.println(player.getPlayersName()+", would you like to play again?");
        String cont = scanner.next();
        if (cont.equalsIgnoreCase("YES")){
            player.setBlackjackRoundsHistory(new BlackjackRound(player, dealer));
            playAgain();
        } else {
            System.out.println("Thank you for the game! Have a nice day!");
        }

    }
}