import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Game {

    Deck deck;
    Player player;
    Hand[] hands;
    String userInput;
    Scanner kboard;


    public Game() {
        kboard = new Scanner(System.in);
        deck = new Deck();
        hands = new Hand[2];
        hands[0] = new PlayerHand(deck);
        hands[1] = new DealerHand(deck);
        start();
    }

    public void start() {
        hands[0].displayHand();
        do {
            promptUser();
            if (userInput.equalsIgnoreCase("y")){
                hands[0].addCard(deck);
            }
            if (!isBust()){
                hands[0].displayHand();
            }
        } while (userInput.equalsIgnoreCase("y") && !isBust());
        evaluateGame(hands);
    }

    private Boolean isBust() {
        return hands[0].getValue() > 21;
    }

    private void promptUser() {
        System.out.println("Draw another card? (y/n)");
        userInput = kboard.next();
    }

    private void evaluateGame(Hand[] hands) {
        if (hands[0].getValue() > hands[1].getValue() && !isBust()) {
            System.out.println("You win!");
            System.out.println();
            hands[0].displayHand();
            hands[1].displayHand();
        } else {
            System.out.println("You lose!");
            System.out.println();
            hands[0].displayHand();
            hands[1].displayHand();
        }
    }
}
