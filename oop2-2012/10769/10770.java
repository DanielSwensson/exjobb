// subklas till V�rdesak 
class Aktie extends V�rdesak{

	private int antal;
	private int pris;

//konstruktor
	public Aktie(String namn,int antal, int pris){

	super(namn); //super classens konstruktor
		this.antal = antal;
	    this.pris = pris;
	}
// metod
	public int getV�rde(){
	return antal * pris;
	}

	public void setPris(int pris){
	this.pris = pris;
	}
}

