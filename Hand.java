import java.util.ArrayList;

public abstract class Hand {

    protected Card[] cards;
    protected int value;
    protected int handSize;

    public abstract void displayHand();
    public abstract void addCardValue(Card card);
    public abstract int getValue();
    public abstract void addCard(Deck deck);
}
