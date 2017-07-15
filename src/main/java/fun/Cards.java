package fun;

/**
 * Created by antons on 15/07/2017.
 */
public enum Cards {

    TWO_CLUBS(2),
    TWO_SPADES(2),
    TWO_HEARTS(2),
    TWO_DIAMOND(2),

    THREE_CLUBS(3),
    THREE_SPADES(3),
    THREE_HEARTS(3),
    THREE_DIAMOND(3),

    FOUR_CLUBS(4),
    FOUR_SPADES(4),
    FOUR_HEARTS(4),
    FOUR_DIAMOND(4),

    FIVE_CLUBS(5),
    FIVE_SPADES(5),
    FIVE_HEARTS(5),
    FIVE_DIAMOND(5),

    SIX_CLUBS(6),
    SIX_SPADES(6),
    SIX_HEARTS(6),
    SIX_DIAMOND(6),

    SEVEN_CLUBS(7),
    SEVEN_SPADES(7),
    SEVEN_HEARTS(7),
    SEVEN_DIAMOND(7),

    EIGHT_CLUBS(8),
    EIGHT_SPADES(8),
    EIGHT_HEARTS(8),
    EIGHT_DIAMOND(8),

    NINE_CLUBS(9),
    NINE_SPADES(9),
    NINE_HEARTS(9),
    NINE_DIAMOND(9),

    TEN_CLUBS(10),
    TEN_SPADES(10),
    TEN_HEARTS(10),
    TEN_DIAMOND(10),

    JACK_CLUBS(10),
    JACK_SPADES(10),
    JACK_HEARTS(10),
    JACK_DIAMOND(10),

    QUEEN_CLUBS(10),
    QUEEN_SPADES(10),
    QUEEN_HEARTS(10),
    QUEEN_DIAMOND(10),

    KING_CLUBS(10),
    KING_SPADES(10),
    KING_HEARTS(10),
    KING_DIAMOND(10),

    ACE_CLUBS(11),
    ACE_SPADES(11),
    ACE_HEARTS(11),
    ACE_DIAMOND(11);

    public int getScore() {
        return score;
    }

    Cards(int score) {
        this.score = score;
    }

    public final int score;

    public static Cards getRandomCard (){
        return values()[(int)(Math.random() * values().length)];
    }





}
