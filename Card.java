public class Card {

    private int value;
    private int suit;

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public String displayCard() {
        String convertedValue;
        String convertedSuit = null;

        if (value == 1) {
            convertedValue = "Ace";
        } else if (value == 11) {
            convertedValue = "Jack";
        } else if (value == 12) {
            convertedValue = "Queen";
        } else if (value == 13) {
            convertedValue = "King";
        } else {
            convertedValue = String.valueOf(value);
        }

        if (suit == 1) {
            convertedSuit = "Diamonds";
        } else if (suit == 2) {
            convertedSuit = "Spades";
        } else if (suit == 3) {
            convertedSuit = "Hearts";
        } else if (suit == 4) {
            convertedSuit = "Clubs";
        }
        return convertedValue + " of " + convertedSuit;
    }
}
