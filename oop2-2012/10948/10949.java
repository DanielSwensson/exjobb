/*Author: Fredrik Birath Hasselgren
 * 
 *Den här klassen representerar apparat. Klassen är en subklass till Thing
 *Varje apparat har ett inköpsrpis samt ett slitage mellan 1 och 10, där 10 betyder att apparaten är helt ny
 *Förutom en överskuggad toString metod finns även en getValue-metod, som returnerar värde bereonde på apparatens slitage
 */
package valuegister;

public class Device extends Thing{
    
    private int purchasePrice;//inköpspris
    private int wear;//apparatens slitage (1-10)

    public Device(String name, int purchasePrice, int wear) {
        super(name);
        this.purchasePrice = purchasePrice;
        this.wear = wear;
    }
    
    @Override
    public double getValue(){
        if(wear == 10){//Om apparaten är helt ny
            return purchasePrice;
        }
        else {//apparaten är begagnad
            return purchasePrice * (wear*0.1);
        }
    }
    
    @Override
    public String toString(){
        return getName() + " med inköpspris " + purchasePrice + " med slitage " + wear + " med marknadsvärde " + getValue(); 
    }
}
