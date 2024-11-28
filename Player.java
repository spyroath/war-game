public class  Player{
    private String name;
    private Deck playDeck;

    public Player(String name){
        this.name = name;
        this.playDeck = new Deck(54);
    }
    
    public String getName(){
        return name;
    }

    public Deck getPlayerDeck(){
        return playDeck;
    }
}