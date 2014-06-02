package pr;

/**
 * @author Marc Balbo
 * @version 1.5
 * @since 2013-01-16
 * 
 * PrylRegister:
 * Aktie klassen
 */

public class Aktie extends Pryl {

    private static final long serialVersionUID = 6145340205187959133L;
    private int antal = 0;
    private int pris = 0;
    private int varde = 0;

    Aktie(String pName, int pantal, int ppris) {
	super(pName);// Anroppar Konstruktorn i supperklassen
	this.antal = pantal;
	this.pris = ppris;
	this.varde = antal * pris;

    }
    
    @Override
    public int getVarde() {
	return varde;
    }

    public void setPris(int pris) {
	this.pris = pris;
	this.varde = antal * pris;
    }
}
