
public class Aktie extends Vardesak {
	private int antal;
	private double pris;
	
	//konstruktorn nedan
	public Aktie (String nV, int a, double p){
		super(nV);
		antal=a;
		pris=p;
		
	}
	// metod för att hämta värde 
	public double getVarde() {
		return antal * pris;
	}
	
	//metod för att hänta antal
	public int getAntal(){
		return antal;
	}
	
	//metod för att hämta pris
	public double getPris(){
		return pris;
	}
	
	//metod för att ändra pris void är för att vi inte ska returnera någonting
	public void setPris(double p){
		pris=p;
	}
	// metod för att krascha . void används för att vi inte returnerar någonting utan ändrar.
	public void krasch(){
		pris=0;
	}
}
