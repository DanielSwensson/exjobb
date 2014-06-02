
public class Apparater extends Pryl {

	private int slit, nPris;

	Apparater(String typApparat, int slitskada, int pris){
		super(typApparat);
		slit=slitskada;
		nPris=pris;		
	}

	public int varde() {
		return nPris * (slit/10);
	}

}