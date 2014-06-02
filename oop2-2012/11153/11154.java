public class Aktier extends Pryl{ // subklass till Pryl
    
	private int antal; // deklarerar v�ra attribut/variabler
	private int pris;
    private int v�rde;
	
	public Aktier(String prylNamn, String typ, int antal, int pris){ // konstruktor med argument som m�ste uppfyllas av varje nytt objekt
		super(prylNamn, typ);// anropar superklassens konstruktor
		this.antal=antal;// antal parametern f�r samma v�rde som objektet med samma namn
		this.pris=pris;
		}
    
    public int getV�rde(){ // returnerar det sammanlagda v�rdet p� aktierna
   		return v�rde=antal * pris;
   	    }
    
    public void b�rsKrasch(){ // nollst�lla aktiernas v�rde vid b�rskrasch anrop
    	pris=0;
    	}
	
	    }