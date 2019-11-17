import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private Card[] cards;
    private Random rand;
    private int deckSize;

    //sets decksize to 52, initialises "random" object so random numbers can be generated, creates cards 1-13 for suits 1-4, shuffles deck
    public Deck() {
        deckSize = 52;
        rand = new Random();
        cards = new Card[deckSize];
        int index = 0;
        for (int suit = 1; suit < 5; suit++) {
            for (int value = 1; value < 14; value++) {
                cards[index] = new Card(suit, value);
                index++;
            }
        }
        shuffleDeck();
    }

    //generates random number, creates copy of card at index i, replaces card with card at random index, replaces card at random index with card previously at i
    //or simply, replaces card 1 with a random card, then card 2 with a random card, and so on
    public void shuffleDeck() {
        Card tempStoreCard;
        for (int i = 0; i < 51; i++) {
            int random = rand.nextInt(52);
            tempStoreCard = cards[i];
            cards[i] = cards[random];
            cards[random] = tempStoreCard;
        }
    }

    //generates a random number between 0 and current deck size, this is the card chosen to be drawn and is saved as "selectedCard", the selected card is replaced with a copy of
    // the last card in the deck. Card array "updatedDeck" is created to store the new deck which won't contain selectedCard. Updated deck is set equal to the original deck besides the last index
    // as the last index contains the now duplicate card which must be removed. Deck size is then decremented and the selected card is returned.
    public Card drawCard() {
        int random = rand.nextInt(deckSize);
        Card selectedCard = cards[random];
        cards[random] = cards[deckSize - 1];
        Card[] updatedDeck = new Card[deckSize - 1];
        for (int i = 0; i < deckSize - 1; i++) {
            updatedDeck[i] = cards[i];
        }
        cards = updatedDeck;
        deckSize -= 1;
        System.out.println("Drawing card...");
        return selectedCard;
    }

    //executes the displayCard() method for each card in the deck
    public void printDeck() {
        for (int i = 0; i < deckSize; i++) {
            System.out.println(i + 1);
            cards[i].displayCard();
        }
    }
}
