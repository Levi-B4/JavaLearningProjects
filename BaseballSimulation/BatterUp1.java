import java.util.Random;

public class BatterUp1{
    public static void main(String[] args){
        for(int i = 0; i < 10; i++){
            int batResult = bat();
            String result = "";
            switch (batResult) {
                case -2:
                    result = "BALL!";
                    break;
                case -1:
                    result = "STRIKE!";
                    break;
                case 1:
                    result = "SINGLE!";
                    break;
                case 2:
                    result = "DOUBLE!";
                    break;
                case 3:
                    result = "TRIPPLE!";
                    break;
            
                default:
                    result = "HOMERUN!";
                    break;
            }
            System.out.printf("  %s\n",result);
            
        }
    }

    public static int bat(){
        Random rand = new Random();
        int dice1 = rand.nextInt(6) + 1;
        int dice2 = rand.nextInt(6) + 1;
        System.out.printf("Dice 1: %d", dice1);
        System.out.printf("Dice 2: %d", dice2);
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
}