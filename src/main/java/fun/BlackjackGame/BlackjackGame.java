package fun.BlackjackGame;

import fun.Dealer;
import fun.Player;

/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackGame {


    public static void main(String[] args) {

        Player player = new Player();
        Dealer dealer = new Dealer();
        player.getWallet().setBalance(15.00);
        new BlackjackGameInitialization(player,dealer);

    }

}
