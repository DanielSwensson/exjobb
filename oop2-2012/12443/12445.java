public class Apparater extends Prylar {

	private int pris;
	private int appSlit;
	private String appNamn;
	private double v�rde;

	public Apparater(String �, double v,String n, int p, int as) {
		super(�, v, n);
		pris = p;
		appSlit = as;
		appNamn = n;
	}	

	public int getPris(){
		return pris;
	}
	public String getTyp(){
		return appNamn;
	}	
	public double setV�rde (double v){
		v�rde = v;
		return v�rde;
	}


}


