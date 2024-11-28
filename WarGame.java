/*
 * Author(s): Spyro Athanasoulis
 * Section n*: 000002
 */
import java.util.Scanner;

public class WarGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter name for player 1: ");
        Player player1 = new Player(scan.nextLine());
        System.out.print("Enter name for player 2: ");
        Player player2 = new Player(scan.nextLine());

        Deck deck = new Deck();
        for (int i = 0; i < 5; i++) {
            deck.shuffle();
        }

        for (int i = 0; i < 27; i++) {
            player1.getDeck().addToDeck(deck.dealCard());
            player2.getDeck().addToDeck(deck.dealCard());
        }

        System.out.println();

        Card player1Card, player2Card;
        Deck table = new Deck(54);

        System.out.println("Press enter to draw cards");
        do {
            scan.nextLine();
            player1Card = player1.getDeck().dealCard();
            if (player1Card == null) {
                System.out.println("Player 1 has null card");
                break;
            }
            System.out.print("Player 1 draws " + player1Card + " (" + player1.getDeck().getNumberOfCards() + " cards remaining in deck)");
            scan.nextLine();
            player2Card = player2.getDeck().dealCard();
            if (player2Card == null) {
                System.out.println("Player 2 has null card");
                break;
            }
            System.out.print("Player 2 draws " + player2Card + " (" + player2.getDeck().getNumberOfCards() + " cards remaining in deck)");

            if (player1Card.getValue() == player2Card.getValue()) {
                System.out.print("\nBoth players draw the same card, adding to table.");
                table.addToDeck(player1Card);
                table.addToDeck(player2Card);
                continue;
            }

            if (player1Card.getValue() > player2Card.getValue()) {
                player1.getDeck().addToDeck(player1Card);
                player1.getDeck().addToDeck(player2Card);
                if (table.dealCard(0) != null) {
                    for (int i = 0; i < table.getNumberOfCards(); i++) {
                        player1.getDeck().addToDeck(table.dealCard(i));
                        table.removeCard(i);
                    }
                }
                player1.getDeck().shuffle();
                System.out.print("\nPlayer 1 wins this round");
                continue;
            } else if (player2Card.getValue() > player1Card.getValue()) {
                player2.getDeck().addToDeck(player1Card);
                player2.getDeck().addToDeck(player2Card);
                if (table.dealCard(0) != null) {
                    for (int i = 0; i < table.getNumberOfCards(); i++) {
                        player2.getDeck().addToDeck(table.dealCard(i));
                        table.removeCard(i);
                    }
                }
                player2.getDeck().shuffle();
                System.out.print("\nPlayer 2 wins this round");
                continue;
            }

            // if table isn't empty, add to deck
            if (table.dealCard(0) != null) {
                for (int i = 0; i < table.getNumberOfCards(); i++) {
                    if (player1Card.getValue() > player2Card.getValue()) {
                        player1.getDeck().addToDeck(table.dealCard());
                        player1.getDeck().shuffle();
                    } else {
                        player2.getDeck().addToDeck(table.dealCard());
                        player2.getDeck().shuffle();
                    }
                }
                continue;
            }

        } while (player1Card != null && player2Card != null);

        scan.close();
    }
}