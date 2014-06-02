
public class Aktie extends Pryl{
	private long antal;
	private double pris;
	
	public Aktie(String aktieNamn ,long antalAktier, double aktieV�rde) { //konstruktor
		namn = aktieNamn;
		antal = antalAktier;
		pris = aktieV�rde;
	}
	
	public double getV�rde(){ //metod f�r att returnera v�rdet p� aktien
		return pris*antal;
	}
	public String getPrylSort() { //metod f�r att returnera vilken sorts pryl detta �r (eftersom alla prylar �r i samma array)
		return "aktie";
	}
	
	public void setV�rde(int v�rde){ //metod f�r att s�tta v�rdet p� en aktie efter att den �r skapad
		pris = v�rde;
	}
}
