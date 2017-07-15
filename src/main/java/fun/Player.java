package fun;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antons on 15/07/2017.
 */
public class Player {
    private String playersName;
    private int amountOfSeats;
    private List<Seat> seats;


    public void setPlayersName(String playersName) {
        this.playersName = playersName;
    }

    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
    public void setSeats(){
        List<Seat> list = new ArrayList<>();
        for (int i =0;i<amountOfSeats;i++){
            list.add(new Seat());
        }
        this.seats = list;
    }



}
