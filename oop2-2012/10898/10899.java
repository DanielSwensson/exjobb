
public class aktie extends Prylar{
	public int antal,pris;
	aktie(String sättPNamn, String sättTyp, int sättVärde, String namn,int sättAntal, int sättPris,int förmögenhet) {
		super(sättPNamn, sättTyp, sättVärde, namn,förmögenhet);
		
		antal = sättAntal;
		pris = sättPris;

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
