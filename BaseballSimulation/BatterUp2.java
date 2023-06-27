import java.util.Random;

public class BatterUp2{
    public static void main(String[] args){
        batterTakeTurn();
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

    public static void batterTakeTurn(){
        int balls = 0;
        int strikes = 0;
        boolean hit = false;
        int batterBatResult = 0;
        while(balls < 4 && strikes < 3 && hit == false){
            batterBatResult = bat();
            System.out.printf("%d    ", batterBatResult);
            switch (batterBatResult) {
                case -2:
                    balls++;
                    System.out.println("Ball!");
                    break;
                case -1:
                    System.out.println("Strike!");
                    strikes++;
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
    }
}