public class Apparat extends Pryl{// subbklass till Pryl
	private int inPris; // deklarerar v�ra attribut/variabler
	private int slitage;
	private int v�rde;
	
	public Apparat(String prylNamn, String typ, int inPris, int slitage){// konstruktor med argument som m�ste uppfyllas av varje nytt objekt
		super(prylNamn, typ);// anropar superklassens konstruktor
		this.inPris=inPris;// inPris parametern f�r samma v�rde som objektet med samma namn
		this.slitage=slitage;
		}


    public int getV�rde(){ // returnerar v�rdet p� apparaten
   		return v�rde=inPris * slitage/10;
   	    }

        }