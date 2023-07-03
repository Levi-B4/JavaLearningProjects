public class Player {
    
    public String name;
    public int strikes;
    public int balls;

    public Player(String name, Base base){

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
