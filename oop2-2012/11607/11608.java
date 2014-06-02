
public class Aktie extends Vardesak {
	private int antal;
	private double pris;
	
	//konstruktorn nedan
	public Aktie (String nV, int a, double p){
		super(nV);
		antal=a;
		pris=p;
		
	}
	// metod f�r att h�mta v�rde 
	public double getVarde() {
		return antal * pris;
	}
	
	//metod f�r att h�nta antal
	public int getAntal(){
		return antal;
	}
	
	//metod f�r att h�mta pris
	public double getPris(){
		return pris;
	}
	
	//metod f�r att �ndra pris void �r f�r att vi inte ska returnera n�gonting
	public void setPris(double p){
		pris=p;
	}
	// metod f�r att krascha . void anv�nds f�r att vi inte returnerar n�gonting utan �ndrar.
	public void krasch(){
		pris=0;
	}
}
