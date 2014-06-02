
public class Aktie extends Vardesak {
	private int antal;
	private double pris;
	
	//Konstruktorn
	public Aktie (String nV, int a, double p){
		super(nV);
		antal=a;
		pris=p;
		
	}
	//Metod f�r att h�mta v�rde 
	public double getVarde() {
		return antal * pris;
	}
	
	//Metod f�r att h�mta antal
	public int getAntal(){
		return antal;
	}
	
	//Metod f�r att h�mta pris
	public double getPris(){
		return pris;
	}
	
	//Metod f�r att �ndra pris. Void �r f�r att vi inte ska returnera n�got
	public void setPris(double p){
		pris=p;
	}
	//Metod f�r att krascha. Void anv�nds f�r att vi inte returnerar n�got, utan �ndrar.
	public void krasch(){
		pris=0;
	}
}
