public class Apparater extends Prylar {

	private int pris;
	private int appSlit;
	private String appNamn;
	private double värde;

	public Apparater(String ä, double v,String n, int p, int as) {
		super(ä, v, n);
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
	public double setVärde (double v){
		värde = v;
		return värde;
	}


}


