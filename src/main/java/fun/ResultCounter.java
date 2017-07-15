package fun;

/**
 * Created by antons on 16/07/2017.
 */
public class ResultCounter {

    private Player player;
    private Dealer dealer;

    public ResultCounter(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
        printResults();
    }

    private void printResults (){

        int seatNumber = 1;

        for (Seat seat : player.getSeats()){

            if (seat.getScore()>dealer.getScore() & seat.getScore()<22 |
                    seat.getScore()<22 & dealer.getScore()>21){
                System.out.println("Seat number "+seatNumber+" won!");
            } else if (seat.getScore()==dealer.getScore()&&seat.getScore()<22){
                System.out.println("Tie for seat number "+seatNumber);
            } else {
                System.out.println("Dealer won against seat "+seatNumber);
            }
            seatNumber = seatNumber+1;
        }


    }

}
