import java.util.Random;

public class Player {
    
    private String name;
    private Base location;
    private int strikes;
    private int balls;

    public Player(String name, Base location){
        this.name = name;
        //location should be dugout when instantiating
        this.location = location;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Base getLocation(){
        return location;
    }

    public void setLocation(Base location){
        this.location = location;
    }

    public boolean isNotInDugout(){
        return !location.isDugout();
    }

    public int takeTurn(){
        strikes = 0;
        balls = 0;
        int batterBatResult;

        while(strikes < 3 && balls < 4){
            batterBatResult = bat();
            if(batterBatResult > 0){
                return batterBatResult;
            }
        }
    
        //walk or strikeout
        if(balls == 4){
            System.out.println("  WALK");
            return 1;
        } else{
            System.out.println("  STRIKEOUT");
            return 0;
        }
    }

    public int bat(){
        Random rand = new Random();
        //simulate two dice rolls
        int dice1 = rand.nextInt(6) + 1;
        int dice2 = rand.nextInt(6) + 1;
        
        System.out.printf("  Rolled: %d", dice1);
        System.out.printf(" %d    ", dice2);
        
        if(dice1 == dice2 && dice1 <= 4){
            switch (dice1) {
                case 1:
                    System.out.println("SINGLE");
                    break;

                case 2:
                    System.out.println("DOUBLE");
                    break;

                case 3:
                    System.out.println("TRIPPLE");
                    break;
            
                default:
                System.out.println("HOMERUN");
                    break;
            }
            return dice1;
        } else{
            if((dice1 + dice2 )% 2 == 0){
                strikes++;
                System.out.println("STRIKE");
            } else{
                System.out.println("BALL");
                balls++;
            }
            return 0;
        }
    }

    public String toString(){
        return name;
    }
}
