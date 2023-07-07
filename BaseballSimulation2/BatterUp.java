import java.util.ArrayList;
import java.util.Arrays;

public class BatterUp {
    private int outs;
    private int score;
    private int nextPlayerIndex;
    private Field field;
    private ArrayList<Player> players;

    public BatterUp() {
        outs = 0;
        score = 0;
        nextPlayerIndex = 0;
        this.field = new Field();
        CreatePlayers();
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
        if(nextPlayerIndex == players.size()){
            nextPlayerIndex = 0;
        }
        return nextPlayer;
    }

    public void Play(){
        while(outs < 3){
            System.out.printf("SCORE: %d\n\n", score);
            displayField();
            Player nextPlayer = getNextPlayer();
            System.out.printf("%s is batting\n", nextPlayer.getName());
            nextPlayer.setLocation(field.getBatterBox());
            int battingValue = nextPlayer.takeTurn();
            if(battingValue == 0){
                outs++;
            }else{
                movePlayers(battingValue);
            }
        }
    }

    public void movePlayers(int basesToMove){
        for (Player player : players) {
            if(player.isNotInDugout()){
                player.setLocation(field.moveAhead(player.getLocation(), basesToMove));
                if(player.getLocation().isHome()){
                    score++;
                    System.out.printf("%s scored", player.getName());
                    player.setLocation(field.getDugout());
                }
            }
        }
    }

    public void displayField(){
        String[] playersOnBase = new String[]{"Empty", "Empty", "Empty"};
        for (Player player : players) {
            String locationName = player.getLocation().getName();
            switch (locationName) {
                case "First":
                    playersOnBase[0] = player.getName();
                    break;

                case "Second":
                    playersOnBase[1] = player.getName();
                    break;

                case "Third":
                    playersOnBase[2] = player.getName();
                    break;
            
                default:
                    break;
            }
        }
        System.out.printf("[ 1 ] %s  [ 2 ] %s  [ 3 ] %s\n", playersOnBase[0], playersOnBase[1], playersOnBase[2]);
    }
}
