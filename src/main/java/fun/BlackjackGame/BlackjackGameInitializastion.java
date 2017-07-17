package fun.BlackjackGame;

import fun.Player;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackGameInitializastion {

    Scanner scanner = new Scanner(System.in);
    Player player;

    public BlackjackGameInitializastion(Player player) {
        this.player = player;
        getPlayersName();
        getAmountOfSeats();
    }

    private void getPlayersName(){

        System.out.println("Welcome to blackjack game!");
        System.out.println("Please enter your name:");
        player.setPlayersName(scanner.nextLine());
    }

    private void getAmountOfSeats (){
        System.out.println("Enter how many seats you want to play:");
        player.setAmountOfSeats(scanner.nextInt());
        player.setSeats();
    }
}