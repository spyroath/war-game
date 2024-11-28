/*
 * Author: Spyro Athanasoulis
 * Section n*: 000002
 */
public class Deck {
    private Card[] deck;
    private int numCards;

    public Deck() {
        deck = new Card[54];
        numCards = 54;
        int currentIndex = 0;

        for (int i = 1; i < 5; i++) { // suits
            for (int j = 1; j < 14; j++) { // values
                deck[currentIndex] = new Card(i, j);
                currentIndex++;
            }
        }

        // last 2 cards are jokers
        deck[52] = new Joker(14);
        deck[53] = new Joker(14);
    }

    public Deck(int deckSize) {
        deck = new Card[deckSize];
        numCards = 0;
    }

    public void shuffle() {
        for (int i = numCards - 1; i > 0; i--) {
            int rand = (int)(Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }

    public void removeCard(int index) {
        deck[index] = null;
    }

    public Card dealCard(int index) {
        return deck[index];
    }

    public Card dealCard() {
        if (numCards > 0) {
            return deck[--numCards];
        }
        else {
            System.out.println("Empty deck");
            return null;      
        }
    }

    public void printDeck() {
        if (numCards == 0) {
            System.out.println("Empty deck");
            return;
        }
        
        for (Card card : deck)
            System.out.println(card);
    }

    public void addToDeck(Card card) {
        if (numCards >= 0 && numCards < 54)
            deck[numCards++] = card;
    }

    public int getNumberOfCards() {
        return numCards;
    }
}