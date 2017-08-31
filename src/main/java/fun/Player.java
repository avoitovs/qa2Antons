package fun;

import fun.BlackjackGame.BlackjackRound;
import fun.BlackjackGame.BlackjackSeat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antons on 15/07/2017.
 */
public class Player extends Core {
    private String playersName;
    private int amountOfSeats;
    private List<BlackjackSeat> seats;
    private List<BlackjackRound> blackjackRoundsHistory = new ArrayList<>();
    private Wallet wallet;

    public Player() {
        this.wallet = new Wallet();
        System.out.println("WELCOME TO ANTON'S CASINO!");
        setPlayersName();
    }

    public Wallet getWallet() {
        return wallet;
    }

    public List<BlackjackRound> getBlackjackRoundsHistory() {
        return blackjackRoundsHistory;
    }

    public void setBlackjackRoundsHistory(BlackjackRound blackjackRound) {
        blackjackRoundsHistory.add(blackjackRound);
    }

    public String getPlayersName() {
        return playersName;
    }

    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    public List<BlackjackSeat> getSeats() {
        return seats;
    }

    public void setSeats(){
        List<BlackjackSeat> list = new ArrayList<>();
        for (int i =0;i<amountOfSeats;i++){
            list.add(new BlackjackSeat());
        }
        this.seats = list;
    }

    private void setPlayersName (){

        System.out.println("Please enter your name:");
        this.playersName = scanner.nextLine();
        System.out.println("Hello "+playersName+", nice to see you!");
        System.out.println();

    }



}
