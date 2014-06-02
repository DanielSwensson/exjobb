public class Aktier extends Pryl{ // subklass till Pryl
    
	private int antal; // deklarerar våra attribut/variabler
	private int pris;
    private int värde;
	
	public Aktier(String prylNamn, String typ, int antal, int pris){ // konstruktor med argument som måste uppfyllas av varje nytt objekt
		super(prylNamn, typ);// anropar superklassens konstruktor
		this.antal=antal;// antal parametern får samma värde som objektet med samma namn
		this.pris=pris;
		}
    
    public int getVärde(){ // returnerar det sammanlagda värdet på aktierna
   		return värde=antal * pris;
   	    }
    
    public void börsKrasch(){ // nollställa aktiernas värde vid börskrasch anrop
    	pris=0;
    	}
	
	    }