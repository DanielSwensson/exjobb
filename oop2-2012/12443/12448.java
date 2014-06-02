public abstract class Prylar {

	private String Šgare;
	private String pNamn;
	private double vŠrde;

	public Prylar (String Š, double v, String n){
		Šgare=Š;
		vŠrde=v;
		pNamn=n;
	}
	public String get€gare() {
		return Šgare;
	}
	public double setPrylVŠrde (double v){
		vŠrde = v;
		return vŠrde;
	}	
	public double getPrylVŠrde() {
		return vŠrde;
	}
	public String getTyp(){
		return pNamn;
	}	



}


