import java.util.ArrayList;
import java.util.Arrays;

public class BatterUp {
    private int outs;
    private int score;
    private int nextPlayerIndex;
    private ArrayList<Player> players;
    private Field field;

    public BatterUp() {
        outs = 0;
        score = 0;
        nextPlayerIndex = 0;
        CreatePlayers();
        field = new Field();
    }

    public void CreatePlayers(){
        Base dugout = field.getDugout();
        players = new ArrayList<Player>(Arrays.asList(
            new Player("Larry", dugout),
            new Player("Landon", dugout),
            new Player("Levi", dugout),
            new Player("Lionel", dugout),
            new Player("Liam", dugout),
            new Player("Lucy", dugout),
            new Player("Lucas", dugout),
            new Player("Logan", dugout),
            new Player("Lincoln", dugout)
        ));
    }

    public Player getNextPlayer(){
        Player nextPlayer = players.get(nextPlayerIndex);
        nextPlayerIndex += 1;
        if(nextPlayerIndex > players.size()){
            nextPlayerIndex = 0;
        }
        return nextPlayer;
    }

    public void Play(){

    }

    public void movePlayers(){

    }

    public void displayField(){

    }
}
