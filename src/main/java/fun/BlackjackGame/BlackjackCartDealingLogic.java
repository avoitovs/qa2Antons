package fun.BlackjackGame;

import fun.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackCartDealingLogic {
    BlackjackCore core = new BlackjackCore();
    private Player player;
    private Dealer dealer;

    public BlackjackCartDealingLogic(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }

    public void dealInitialCards (){
        int seatNumber = 1;

        for (BlackjackSeat seat : player.getSeats()){

            List<Cards> playersCards = dealInitialPlayersCards();

            seat.setPlayersCard(playersCards);
            seat.setScore(core.scoreUpdate(seat));

            hasBlackjack(seat);

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

        BlackjackDecisionController blackjackGameController = new BlackjackDecisionController();
        blackjackGameController.decisionMaking(player);
        blackjackGameController.dealersDecision(dealer);
        new BlackjackResultCounter(player,dealer);
        
    }

    private List<Cards> dealInitialPlayersCards(){

        List<Cards> playersCards = new ArrayList<>();
        Cards firstPlayerCard = Cards.getRandomCard();
        playersCards.add(firstPlayerCard);
        Cards secondPlayerCard = Cards.getRandomCard();
        playersCards.add(secondPlayerCard);

        return playersCards;
    }

    private void hasBlackjack (BlackjackSeat seat){

        if (seat.getScore()==21){
            seat.setHasBlackjack(true);
        } else {
            seat.setHasBlackjack(false);
        }

    }

}
