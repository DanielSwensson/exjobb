
public class aktie extends Prylar{
	public int antal,pris;
	aktie(String s�ttPNamn, String s�ttTyp, int s�ttV�rde, String namn,int s�ttAntal, int s�ttPris,int f�rm�genhet) {
		super(s�ttPNamn, s�ttTyp, s�ttV�rde, namn,f�rm�genhet);
		
		antal = s�ttAntal;
		pris = s�ttPris;

	}
	
	public int getAntal(){
		return antal;
	}
	public int getPris(){
		return pris;
	}
	
	public String toString(){
	return getNamn();
	}

}
