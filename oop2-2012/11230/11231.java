package assetmanagement;

abstract public class Asset { //abstrakt klass

    protected String name;//variabel som är protected

    abstract public int getValue();//abstrakt metod

    public String getName() {//metod hämta namn och returnerar namn
        return name;
    }

    
}
