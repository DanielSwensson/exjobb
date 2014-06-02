
public class GoldJewelery extends Jewelery {
    private final int MATERIALWORTH = 2000;

    public GoldJewelery (String jeweleryType, int numberOfJewels){
        super(jeweleryType, numberOfJewels);
    }
    
    public double getValue(){
        value = (super.getValue() + MATERIALWORTH);
        return value;
    }
}
