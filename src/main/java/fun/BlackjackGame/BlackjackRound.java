package fun.BlackjackGame;

import fun.*;

import java.util.ArrayList;
import java.util.List;


public class BlackjackRound extends BlackjackCore {

    private Player player;
    private Dealer dealer;

    public BlackjackRound(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
        dealInitialCards();
        new BlackjackDecisionController(player,dealer);
        new BlackjackResultCounter(player,dealer);
    }

    private void dealInitialCards (){
        int seatNumber = 1;
        new BlackjackBetPlacement(player);

        printSeparator();

        for (BlackjackSeat seat : player.getSeats()){

            dealInitialPlayersCards(seat);
            printPlayersCardsAndScore(seat,seatNumber);
            seatNumber = seatNumber+1;
        }

        dealDealersInitialCard();
    }

    private void dealDealersInitialCard() {
        printSeparator();
        List<Cards> dealersCards = new ArrayList<>();
        Cards firstDealerCard = Cards.getRandomCard();
        dealersCards.add(firstDealerCard);
        dealer.setScore(firstDealerCard.getScore());

        dealer.setDealersCards(dealersCards);
        printDealersInitialCard(dealer);
    }

    private void dealInitialPlayersCards(BlackjackSeat seat){

        List<Cards> playersCards = new ArrayList<>();
        Cards firstPlayerCard = Cards.getRandomCard();
        playersCards.add(firstPlayerCard);
        Cards secondPlayerCard = Cards.getRandomCard();
        playersCards.add(secondPlayerCard);

        seat.setPlayersCard(playersCards);
        seat.setScore(scoreUpdate(seat));
        checkForBlackjack(seat);

    }

    private void checkForBlackjack(BlackjackSeat seat){

        if (seat.getScore()==21){
            seat.setHasBlackjack(true);
        } else {
            seat.setHasBlackjack(false);
        }

    }

}
