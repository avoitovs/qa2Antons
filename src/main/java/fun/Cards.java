package fun;

/**
 * All possible cards.
 * First parameter (TWO_HEARTS(2,2)) represents score value of the card.
 * Second parameter represents value itself (TEN,JACK,QUEEN, etc).
 */
public enum Cards {

    TWO_CLUBS(2,2),
    TWO_SPADES(2,2),
    TWO_HEARTS(2,2),
    TWO_DIAMOND(2,2),

    THREE_CLUBS(3,3),
    THREE_SPADES(3,3),
    THREE_HEARTS(3,3),
    THREE_DIAMOND(3,3),

    FOUR_CLUBS(4,4),
    FOUR_SPADES(4,4),
    FOUR_HEARTS(4,4),
    FOUR_DIAMOND(4,4),

    FIVE_CLUBS(5,5),
    FIVE_SPADES(5,5),
    FIVE_HEARTS(5,5),
    FIVE_DIAMOND(5,5),

    SIX_CLUBS(6,6),
    SIX_SPADES(6,6),
    SIX_HEARTS(6,6),
    SIX_DIAMOND(6,6),

    SEVEN_CLUBS(7,7),
    SEVEN_SPADES(7,7),
    SEVEN_HEARTS(7,7),
    SEVEN_DIAMOND(7,7),

    EIGHT_CLUBS(8,8),
    EIGHT_SPADES(8,8),
    EIGHT_HEARTS(8,8),
    EIGHT_DIAMOND(8,8),

    NINE_CLUBS(9,9),
    NINE_SPADES(9,9),
    NINE_HEARTS(9,9),
    NINE_DIAMOND(9,9),

    TEN_CLUBS(10,10),
    TEN_SPADES(10,10),
    TEN_HEARTS(10,10),
    TEN_DIAMOND(10,10),

    JACK_CLUBS(10,11),
    JACK_SPADES(10,11),
    JACK_HEARTS(10,11),
    JACK_DIAMOND(10,11),

    QUEEN_CLUBS(10,12),
    QUEEN_SPADES(10,12),
    QUEEN_HEARTS(10,12),
    QUEEN_DIAMOND(10,12),

    KING_CLUBS(10,13),
    KING_SPADES(10,13),
    KING_HEARTS(10,13),
    KING_DIAMOND(10,13),

    ACE_CLUBS(11,14),
    ACE_SPADES(11,14),
    ACE_HEARTS(11,14),
    ACE_DIAMOND(11,14);

    public int getScore() {
        return score;
    }

    public void setScore(int score) { this.score = score;}

    Cards(int score,int value) {
        this.score = score;
        this.value = value;
    }

    private int score;

    private int value;

    public int getValue() {
        return value;
    }

    public static Cards getRandomCard (){
        return values()[(int)(Math.random() * values().length)];
    }





}
