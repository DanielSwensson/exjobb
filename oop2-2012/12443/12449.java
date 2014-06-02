public class Smycken extends Prylar {

	private int aStenar;
	private String sNamn;
	private String metall;
	private double värde;

	public Smycken(String ä, double v, String n, int as, String m) {
		super(ä, v, n);
		aStenar=as;
		metall=m;
		sNamn=n;

	}
	public double setVärde (double v){
		värde = v;
		return värde;
	}
	public String getTyp(){
		return sNamn;
	}

}
