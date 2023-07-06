public class Base {
    private String name;

    public Base(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isDugout(){
        return name == "Dugout";
    }

    public boolean isHome(){
        return name == "Home";
    }

    public String toString(){
        return "PLACEHOLDER";
    }
}
