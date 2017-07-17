package fun;

import java.util.List;

/**
 * Created by antons on 15/07/2017.
 */
public class Dealer {

    private List<Cards> dealersCards;
    private int score;
    private boolean hasBlackjack;


    public boolean getHasBlackjack() {
        return hasBlackjack;
    }

    public void setHasBlackjack(boolean hasBlackjack) {
        this.hasBlackjack = hasBlackjack;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Cards> getDealersCards() {
        return dealersCards;
    }

    public void setDealersCards(List<Cards> dealersCards) {
        this.dealersCards = dealersCards;
    }
}
