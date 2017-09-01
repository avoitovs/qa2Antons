package fun.BlackjackGame;

import fun.Cards;

import java.util.List;

/**
 * Created by antons on 15/07/2017.
 */
public class BlackjackSeat {

    private List<Cards> playersCard;
    private int score;
    private List<BlackjackSplitHand> hands;
    private boolean hasBlackjack;
    private boolean win;
    private double bet;
    private boolean insurance;


    private boolean doubledBet;


    public boolean isDoubledBet() {
        return doubledBet;
    }

    public void setDoubledBet(boolean doubledBet) {
        this.doubledBet = doubledBet;
    }


    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean getHasBlackjack() {
        return hasBlackjack;
    }

    public void setHasBlackjack(boolean hasBlackjack) {
        this.hasBlackjack = hasBlackjack;
    }

    public List<Cards> getPlayersCard() {
        return playersCard;
    }

    public void setPlayersCard(List<Cards> playersCard) {
        this.playersCard = playersCard;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<BlackjackSplitHand> getHands() {
        return hands;
    }

    public void setHands(List<BlackjackSplitHand> hands) {
        this.hands = hands;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }
}
