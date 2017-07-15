package fun;

/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackGame {


    public static void main(String[] args) {

        Player player = new Player();
        Dealer dealer = new Dealer();
        new GameInitializastion(player);
        CartDealingLogic dealingLogic = new CartDealingLogic(player,dealer);
        dealingLogic.dealInitialCards();

    }

}
