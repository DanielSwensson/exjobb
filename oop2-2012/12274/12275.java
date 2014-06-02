
public class Aktie extends Vardesak {
	private int antal;
	private double pris;
	
	//Konstruktorn
	public Aktie (String nV, int a, double p){
		super(nV);
		antal=a;
		pris=p;
		
	}
	//Metod för att hämta värde 
	public double getVarde() {
		return antal * pris;
	}
	
	//Metod för att hämta antal
	public int getAntal(){
		return antal;
	}
	
	//Metod för att hämta pris
	public double getPris(){
		return pris;
	}
	
	//Metod för att ändra pris. Void är för att vi inte ska returnera något
	public void setPris(double p){
		pris=p;
	}
	//Metod för att krascha. Void används för att vi inte returnerar något, utan ändrar.
	public void krasch(){
		pris=0;
	}
}
