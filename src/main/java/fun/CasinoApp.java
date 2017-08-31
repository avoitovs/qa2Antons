package fun;


import fun.BlackjackGame.BlackjackGame;

/**
 * Created by antons on 03/08/2017.
 */
public class CasinoApp {


    public static void main(String[] args) {

        Player player = new Player();
        player.getWallet().setBalance(15.00);

        new BlackjackGame(player);





    }






}
