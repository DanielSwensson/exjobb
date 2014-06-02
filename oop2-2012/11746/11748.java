
/**
 * A class for jewelries, subclass to Valuables
 */
public class Jewelry extends Valuable {
    private int diamonds, metal;
    
    public Jewelry(String name, int metal, int diamonds) {
        super(name);
        this.metal = metal;
        this.diamonds = diamonds;
    }
    
    /*
     * Returns the metal of the jewelry
     */
    public int getMetal() {
        return this.metal;
    }
    
    /*
     * Returns the amount of diamonds in the jewelry
     */
    public int getDiamonds() {
        return this.diamonds;
    }
    
    /*
     * Overrides the super-method, compiles the jewelry's value
     */
    @Override
    public double getValue() {
        double value = 0;
        int i;
        if(this.metal == 1) {
            value += 2000;
        } else if(this.metal == 2) {
            value +=700;
        }
        for(i = 0; i<this.diamonds; i++) {
            value += 500;
        }
        return value;
    }
}
