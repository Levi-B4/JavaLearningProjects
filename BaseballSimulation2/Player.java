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
        return "PLACEHOLDER";
    }

    public void setName(String name){

    }

    public Base getLocation(){
        return new Base("PLACEHOLDER");
    }

    public void setLocation(Base base){
        
    }

    public boolean isNotInDugout(){
        return true;
    }

    public int takeTurn(){
        return 0;
    }

    public int bat(){
        return 0;
    }

    public String toString(){
        return "PLACEHOLDER";
    }
}
