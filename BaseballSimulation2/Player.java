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
        return location.isDugout();
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
            return 1;
        } else{
            return 0;
        }
    }

    public int bat(){
        Random rand = new Random();
        //simulate two dice rolls
        int dice1 = rand.nextInt(6) + 1;
        int dice2 = rand.nextInt(6) + 1;
        
        System.out.printf("Roll: %d", dice1);
        System.out.printf(" %d    ", dice2);
        
        if(dice1 == dice2 && dice1 <= 4){
            return dice1;
        } else{
            if((dice1 + dice2 )% 2 == 0){
                strikes =+ 1;
            } else{
                balls += 1;
            }
            return 0;
        }
    }

    public String toString(){
        return "PLACEHOLDER";
    }
}
