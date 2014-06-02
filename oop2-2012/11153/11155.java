public class Apparat extends Pryl{// subbklass till Pryl
	private int inPris; // deklarerar våra attribut/variabler
	private int slitage;
	private int värde;
	
	public Apparat(String prylNamn, String typ, int inPris, int slitage){// konstruktor med argument som måste uppfyllas av varje nytt objekt
		super(prylNamn, typ);// anropar superklassens konstruktor
		this.inPris=inPris;// inPris parametern får samma värde som objektet med samma namn
		this.slitage=slitage;
		}


    public int getVärde(){ // returnerar värdet på apparaten
   		return värde=inPris * slitage/10;
   	    }

        }