package pr;

/**
 * @author Marc Balbo
 * @version 1.5
 * @since 2013-01-16
 * 
 * PrylRegister:
 * Smyckes klassen
 * 
 */

public class Smycke extends Pryl {

    private static final long serialVersionUID = -9149367206314215688L;
    private int adelstenar = 0;
    private int varde = 0; 
    private int materialVarde=0;

    Smycke(String sortSmycken, boolean pGuld, int pAdelstenar) {
	super(sortSmycken);// Anroppar Konstruktorn i supperklassen
	adelstenar = pAdelstenar;
	if (pGuld == true){materialVarde = 2000;}
	else{materialVarde=700;}
	varde=materialVarde+(adelstenar*500);
    }
    
    @Override
    public int getVarde() {
	return varde;
    }
}
