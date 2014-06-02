package pr;

/**
 * @author Marc Balbo
 * @version 1.5
 * @since 2013-01-16
 * 
 * PrylRegister:
 * Apparat klassen
 */

public class Apparat extends Pryl{
    private static final long serialVersionUID = 3739150469859370065L;
    private int varde = 0;

    Apparat(String prylNamn, int pris, int slitaget) {
	super(prylNamn);// Anroppar Konstruktorn i supperklassen
	this.varde = (int)(pris*(slitaget/10.0));//räknar ut värdet på apparaten
    }
    
    @Override
    public int getVarde() {
	return varde;
    }

}
