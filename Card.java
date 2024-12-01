/*
 * Author: Steve Banh
 */

// import java.util.Scanner;
public class Card {

    /*this class is responsible of declaring the suits
    and the value of the cards*/
    protected int suit;
    protected int value;

    //Constructor
    public Card(int suit, int value){
        this.suit = suit;
        this.value = value;
    }

    //getters
    public int getSuit(){
        return suit;
    }

    public int getValue(){
        return value;
    }

    //methods
    public String getSuitAsString(){

        switch (suit){
            case 1:
                return "Spades";
            case 2:
                return "Hearts";
            case 3:
                return "Diamonds";
            case 4:
                return "Clubs";
            default:
                return "Invalid suit";
        }
    }

    public String getValueAsString(){

        switch (value){
            case 1:
                return "Ace";
            case 2,3,4,5,6,7,8,9,10:
                return Integer.toString(value);
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return "Invalid value";
        }
    }

    public String toString(){
        return getValueAsString() + " of " + getSuitAsString();
    }

    // //main for testing
    // public static void main(String[] args) {
    //     Scanner input = new Scanner(System.in);

    //     System.out.println("enter a suit");
    //     int suit = input.nextInt();

    //     System.out.println("enter a value");
    //     int value = input.nextInt();

    //     Card myCard = new Card (suit, value);

    //     System.out.println(myCard.toString());

    //     System.out.println(myCard.getSuitAsString(4));
    //     System.out.println(myCard.getValueAsString(5));

    // }
}