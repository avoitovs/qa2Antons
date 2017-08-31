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

        System.out.println(" DEALING INITIAL CARDS...");

        printSeparator();

        for (BlackjackSeat seat : player.getSeats()){

            dealInitialPlayersCards(seat);
            printPlayersCardsAndScore(seat,seatNumber);
            seatNumber = seatNumber+1;
        }

        dealDealersInitialCard();
        offerInsurance();

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
        seat.setScore(scoreUpdate(seat.getPlayersCard()));
        checkForBlackjack(seat);

    }

    private void checkForBlackjack(BlackjackSeat seat){

        if (seat.getScore()==21){
            seat.setHasBlackjack(true);
        } else {
            seat.setHasBlackjack(false);
        }

    }


    private void offerInsurance(){

        if (dealer.getDealersCards().get(0).getValue()==14) {


            int seatNumber = 1;
            System.out.println("Dealer's face up card is ACE");
            for (BlackjackSeat seat : player.getSeats()) {

                if (!(player.getWallet().getBalance() < seat.getBet())) {

                    System.out.println("Would you like to get an insurance for seat number " + seatNumber + " ?");
                    String insuranceDecision = scanner.nextLine();
                    if (insuranceDecision.equalsIgnoreCase("yes")) {

                        seat.setInsurance(true);
                        player.getWallet().setBalance(player.getWallet().getBalance() - (seat.getBet() * 0.5));
                        printTotalBalance(player);


                    }
                }
                    seatNumber = seatNumber + 1;
            }

        }

    }

}
