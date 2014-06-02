package pr;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Marc Balbo
 * @version 1.5
 * @since 2013-01-16
 * 
 * PrylRegister;
 * 
 */

public class Person implements Serializable {
    private static final long serialVersionUID = 7806532260415430508L;
    private ArrayList<Pryl> prylArray = new ArrayList<Pryl>();
    private String name = null;
    private int formogenhet = 0;

    Person(String pName) {
	name = pName;
    }

    void addAktie(String prylNamn, int antal, int pris) {
	prylArray.add(new Aktie(prylNamn, antal, pris));
    }
    
    void listaPryl(){
        for (Pryl P  : prylArray){
            System.out.println(P.getName()+" "+P.getVarde());
        }
    }
    void addApparat(String prylNamn, int pris, int slitaget) {
	prylArray.add(new Apparat(prylNamn, pris, slitaget));
    }

    void addSmycke(String sort, String gold, int adelstenar) {
	boolean gb=gold.equalsIgnoreCase("ja");
	prylArray.add(new Smycke(sort, gb, adelstenar));
    }

   protected int getFormogenhet() {
	formogenhet = 0;
	int tempVarde = 0;
	for (int i = 0; i < prylArray.size(); i++) {
	    tempVarde = this.prylArray.get(i).getVarde();
	    formogenhet = formogenhet + tempVarde;
	}
	return formogenhet;
    }

    protected String getName() {
	return name;
    }

    protected ArrayList<Pryl> getPrylArray() {
	return prylArray;
    }

}
