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
                System.out.println(player1.getName() + " has no more cards");
                break;
            }
            System.out.print(player1.getName() + " draws " + player1Card + " (" + player1.getDeck().getNumberOfCards() + " cards remaining in deck)");
            scan.nextLine();
            player2Card = player2.getDeck().dealCard();
            if (player2Card == null) {
                System.out.println(player2.getName() + " has no more cards");
                break;
            }
            System.out.print(player2.getName() + " draws " + player2Card + " (" + player2.getDeck().getNumberOfCards() + " cards remaining in deck)");

            if (player1Card.getValue() == player2Card.getValue()) {
                System.out.print("\nBoth players draw the same card, adding to table");
                table.addToDeck(player1Card);
                table.addToDeck(player2Card);
                continue;
            }

            if (player1Card.getValue() > player2Card.getValue()) {
                player1.getDeck().addToDeck(player1Card);
                player1.getDeck().addToDeck(player2Card);
                transferTableCards(player1.getDeck(), table);
                player1.getDeck().shuffle();
                System.out.print("\n" + player1.getName() + " wins this round");
            } else {
                player2.getDeck().addToDeck(player1Card);
                player2.getDeck().addToDeck(player2Card);
                transferTableCards(player2.getDeck(), table);
                player2.getDeck().shuffle();
                System.out.print("\n" + player2.getName() + " wins this round");
            }

        } while (player1.getDeck().getNumberOfCards() > 0 && player2.getDeck().getNumberOfCards() > 0);

        scan.close();

        if (player1.getDeck().getNumberOfCards() > 0) {
            System.out.println("\n" + player1.getName() + " wins the game");
        } else {
            System.out.println("\n" + player2.getName() + " wins the game");
        }
    }

    public static void transferTableCards(Deck winnerDeck, Deck table) {
        while (table.getNumberOfCards() > 0) { // clear entire table
            Card card = table.dealCard();
            if (card != null) {
                winnerDeck.addToDeck(card);
            }
        }
    }
}