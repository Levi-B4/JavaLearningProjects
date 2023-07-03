import java.util.Random;

public class BatterUp5{
    //game info
    public static String[] players = new String[]{
        "BatterName1", "BatterName2", "BatterName3", "BatterName4", "BatterName5", "BatterName6", "BatterName7", "BatterName8", "BatterName9"
    };
    public static int[] playerLocations = new int[]{
        -1, -1, -1, -1, -1, -1, -1, -1, -1
    };
    public static int score = 0;

    public static void main(String[] args){
        int outs = 0;
        while(outs < 3){
            for (int i = 0; i < players.length; i++) {
                System.out.printf("\nSCORE: %d\n", score);
                displayField();
                playerLocations[i] = 0;
                System.out.printf("%s is up to bat with %d outs\n", players[i], outs);
                if(batterTakeTurn()){
                    outs += 1;
                    playerLocations[i] = -1;
                    if(outs >= 3){
                        break;
                    }
                }
            }
        }
    }

    //batting logic
    public static int bat(){
        Random rand = new Random();
        int dice1 = rand.nextInt(6) + 1;
        int dice2 = rand.nextInt(6) + 1;
        System.out.printf("  Roll: %d", dice1);
        System.out.printf(" %d    ", dice2);
        if(dice1 == dice2 && dice1 <= 4){
            return dice1;
        } else{
            if((dice1 + dice2 )% 2 == 0){
                return -1;
            } else{
                return -2;
            }
        }
    }

    //repeat batting until walk, strikeout, or hit
    public static boolean batterTakeTurn(){
        int balls = 0;
        int strikes = 0;
        boolean hit = false;
        int batterBatResult = 0;
        boolean isOut = false;
        while(balls < 4 && strikes < 3 && hit == false){
            batterBatResult = bat();
            switch (batterBatResult) {
                case -2:
                    balls++;
                    System.out.println("Ball!");
                    if(balls == 4){
                        System.out.println("Walk");
                        movePlayers(1);
                    }
                    break;
                case -1:
                    System.out.println("Strike!");
                    strikes++;
                    if(strikes == 3){
                        System.out.println("Strike out!!");
                        isOut = true;
                    }
                    break;
                case 1:
                    hit = true;
                    System.out.println("Single!");
                    movePlayers(batterBatResult);
                    break;
                case 2:
                    hit = true;
                    System.out.println("Double!");
                    movePlayers(batterBatResult);
                    break;
                case 3:
                    hit = true;
                    System.out.println("Tripple!");
                    movePlayers(batterBatResult);
                    break;
                default:
                    hit = true;
                    System.out.println("Homerun!");
                    movePlayers(batterBatResult);
                    break;
            }
        }
        return isOut;
    }

    //changes player locations
    public static void movePlayers(int batValue){
        for (int i = 0; i < playerLocations.length; i ++) {
            if(playerLocations[i] >= 0){
                playerLocations[i] += batValue;
                if(playerLocations[i] >= 4){
                    System.out.printf("%s scored!!\n", players[i]);
                    score ++;
                    playerLocations[i] = -1;
                }
            }
        }
    }

    //show who is on each base
    public static void displayField(){
        String[] field = new String[]{
            "empty", "empty", "empty"
        };
        int playerLocation = -1;
        for (int i = 0; i < playerLocations.length; i++) {
            playerLocation = playerLocations[i];
            if(1 <= playerLocation && playerLocation <= 3){
                field[playerLocation - 1] = players[i];
            }
        }
        System.out.printf("[ 1 ] %s  [ 2 ] %s  [ 3 ] %s\n", field[0], field[1], field[2]);
    }
}