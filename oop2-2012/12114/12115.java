
public class Aktie extends Pryl{
	private long antal;
	private double pris;
	
	public Aktie(String aktieNamn ,long antalAktier, double aktieVärde) { //konstruktor
		namn = aktieNamn;
		antal = antalAktier;
		pris = aktieVärde;
	}
	
	public double getVärde(){ //metod för att returnera värdet på aktien
		return pris*antal;
	}
	public String getPrylSort() { //metod för att returnera vilken sorts pryl detta är (eftersom alla prylar är i samma array)
		return "aktie";
	}
	
	public void setVärde(int värde){ //metod för att sätta värdet på en aktie efter att den är skapad
		pris = värde;
	}
}
