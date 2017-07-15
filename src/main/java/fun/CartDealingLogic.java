package fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by antons on 15/07/2017.
 */
public class CartDealingLogic {
    private Player player;
    private Dealer dealer;

    public CartDealingLogic(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }

    public void dealInitialCards (){
        int seatNumber = 1;

        for (Seat seat : player.getSeats()){

            List<Cards> playersCards = dealInitialPlayersCards(seat);

            seat.setPlayersCard(playersCards);

            System.out.println("Player's cards on seat "+ seatNumber +": "+playersCards+" Total score: "+seat.getScore());
            seatNumber = seatNumber+1;

        }

        List<Cards> dealersCards = new ArrayList<>();
        Cards firstDealerCard = Cards.getRandomCard();
        dealersCards.add(firstDealerCard);
        dealer.setScore(firstDealerCard.getScore());

        dealer.setDealersCards(dealersCards);
        System.out.println();
        System.out.println("Dealer's face up card: "+dealersCards+" Total score: "+dealer.getScore());
        System.out.println();

        GameController gameController = new GameController();
        gameController.decisionMaking(player);
        gameController.dealersDecision(dealer);
        new ResultCounter(player,dealer);
        
    }

    private List<Cards> dealInitialPlayersCards(Seat seat){

        List<Cards> playersCards = new ArrayList<>();
        Cards firstPlayerCard = Cards.getRandomCard();
        playersCards.add(firstPlayerCard);
        Cards secondPlayerCard = Cards.getRandomCard();
        playersCards.add(secondPlayerCard);
        seat.setScore(firstPlayerCard.getScore()+secondPlayerCard.getScore());

        return playersCards;
    }

}
