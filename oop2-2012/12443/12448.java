public abstract class Prylar {

	private String �gare;
	private String pNamn;
	private double v�rde;

	public Prylar (String �, double v, String n){
		�gare=�;
		v�rde=v;
		pNamn=n;
	}
	public String get�gare() {
		return �gare;
	}
	public double setPrylV�rde (double v){
		v�rde = v;
		return v�rde;
	}	
	public double getPrylV�rde() {
		return v�rde;
	}
	public String getTyp(){
		return pNamn;
	}	



}


