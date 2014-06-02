
public class SilverJewelery extends Jewelery{
    private final int MATERIALWORTH = 700;
            
    public SilverJewelery (String jeweleryType, int numberOfJewels){
        super(jeweleryType, numberOfJewels);
    }
    
    public double getValue(){
        value = (super.getValue() + MATERIALWORTH);
        return value;
    }
}
