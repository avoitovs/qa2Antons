package fun;

import java.util.List;

/**
 * Created by antons on 15/07/2017.
 */
public class Seat {

    private List<Cards> playersCard;
    private int score;
    private List<Hand> hands;

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

    public List<Hand> getHands() {
        return hands;
    }

    public void setHands(List<Hand> hands) {
        this.hands = hands;
    }
}
