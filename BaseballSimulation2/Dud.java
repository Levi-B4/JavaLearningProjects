import java.util.Random;

public class Dud extends Player{
    public Dud(String name, Base base) {
        super(name, base);
    }

    public int[] roll(){
        Random rand = new Random();
        
        //simulate two dice rolls
        int dice1 = rand.nextInt(10) + 1;
        int dice2 = rand.nextInt(10) + 1;
        
        System.out.printf("  Rolled: %d", dice1);
        System.out.printf(" %d    ", dice2);
        
        return new int[]{dice1, dice2};
    }
}