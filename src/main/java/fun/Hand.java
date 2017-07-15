package fun;

import java.util.List;

/**
 * Created by antons on 15/07/2017.
 */
public class Hand {
    private List<Cards> playersCard;
    private int score;

    public Hand(List<Cards> playersCard) {
        this.playersCard = playersCard;
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
}
