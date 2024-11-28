public class Joker extends Card{

    //constructor
    public Joker(int value){
        super(5, value);
    }

    //methods
    public String getSuitAsString(){
        return "Joker";
    }

    public String getValueAsString(){
        return "\"" + value + "\"";
    }

    //main for testing
    // public static void main(String[] args) {
        
    //     Joker myJoker = new Joker(3, 1);

    //     System.out.println(myJoker.toString());
    // }
}
