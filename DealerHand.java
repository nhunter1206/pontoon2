
public class DealerHand extends Hand {


    public DealerHand(Deck deck) {
        System.out.println("Dealing Dealer Hand");
        System.out.println();
        cards = new Card[2];
        addCard(deck);
        addCard(deck);
        System.out.println();
        handSize = cards.length;
    }


    public void displayHand() {
        System.out.println();
        System.out.println("Dealer hand: ");
        for (int i = 0; i < handSize; i++) {
            System.out.println(cards[i].displayCard());
        }
        System.out.println("Hand value: " + value);
    }

    public void addCardValue(Card card) {
        if (card.getValue() == 11 || card.getValue() == 12 || card.getValue() == 13) {
            value += 10;
        } else {
            value += card.getValue();
        }
    }

    public int getValue() {
        return value;
    }


    public void addCard(Deck deck) {
        Card[] newCards = new Card[handSize + 1];
        for (int i = 0; i < handSize; i++) {
            newCards[i] = cards[i];
        }
        newCards[handSize] = deck.drawCard();
        cards = newCards;
        addCardValue(cards[handSize]);
        handSize += 1;
    }
}
