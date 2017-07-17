package fun;

import fun.BlackjackGame.BlackjackSeat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antons on 15/07/2017.
 */
public class Player {
    private String playersName;
    private int amountOfSeats;
    private List<BlackjackSeat> seats;

    public void setPlayersName(String playersName) {
        this.playersName = playersName;
    }

    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    public List<BlackjackSeat> getSeats() {
        return seats;
    }

    public void setSeats(List<BlackjackSeat> seats) {
        this.seats = seats;
    }
    public void setSeats(){
        List<BlackjackSeat> list = new ArrayList<>();
        for (int i =0;i<amountOfSeats;i++){
            list.add(new BlackjackSeat());
        }
        this.seats = list;
    }



}
