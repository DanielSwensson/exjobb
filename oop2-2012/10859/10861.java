package pr;

import java.io.Serializable;

/**
 * @author Marc Balbo
 * @version 1.5
 * @since 2013-01-16
 * 
 * PrylRegister:
 * Pryl klassen, Superklass till Aktie,Apparat,Smycke.
 */

public class Pryl implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 27343642416196300L;
    private String name = null;
    private int varde = 0;

    Pryl(String pName) {
	name = pName;
    }

    public String getName() {
	return name;
    }

    public int getVarde() {
	return varde;
  }

}
