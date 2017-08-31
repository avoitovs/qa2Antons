package fun.BlackjackGame;

import fun.Dealer;
import fun.Player;

/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackGame {


    public BlackjackGame(Player player) {
        startBlackjackGame(player);
    }

    private void startBlackjackGame(Player player) {

        Dealer dealer = new Dealer();
        new BlackjackGameInitialization(player,dealer);

    }

}
