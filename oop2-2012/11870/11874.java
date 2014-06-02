package prylregister;

abstract public class Pryl {
    protected String prylName="";
    abstract public double getValue();
    
    public Pryl(String name){
        prylName = name;
    }
    public String getName (){
        return prylName;
    }
}