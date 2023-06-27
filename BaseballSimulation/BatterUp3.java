import java.util.Random;

public class BatterUp3{
    public static String[] batters = new String[]{
        "BatterName1", "BatterName2", "BatterName3", "BatterName4", "BatterName5", "BatterName6", "BatterName7", "BatterName8", "BatterName9"
    };
    public static void main(String[] args){
        int outs = 0;
        while(outs < 3){
            for (String batter : batters) {
                System.out.printf("%s is up to bat with %d outs\n", batter, outs); //will change players location here (-1,0) = (dugout, at bat)
                if(batterTakeTurn()){
                    outs += 1;
                    if(outs >= 3){
                        break;
                    }
                }
            }
        }
    }

    public static int bat(){
        Random rand = new Random();
        int dice1 = rand.nextInt(6) + 1;
        int dice2 = rand.nextInt(6) + 1;
        System.out.printf("Roll: %d", dice1);
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
                    break;
                case -1:
                    System.out.println("Strike!");
                    strikes++;
                    if(strikes >= 3){
                        isOut = true;
                    }
                    break;
                case 1:
                    hit = true;
                    System.out.println("Single!");
                    break;
                case 2:
                    hit = true;
                    System.out.println("Double!");
                    break;
                case 3:
                    hit = true;
                    System.out.println("Tripple!");
                    break;
                default:
                    hit = true;
                    System.out.println("Homerun!");
                    break;
            }
        }
        return isOut;
    }
}
