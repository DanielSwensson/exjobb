public class Smycken extends Prylar {

	private int aStenar;
	private String sNamn;
	private String metall;
	private double v�rde;

	public Smycken(String �, double v, String n, int as, String m) {
		super(�, v, n);
		aStenar=as;
		metall=m;
		sNamn=n;

	}
	public double setV�rde (double v){
		v�rde = v;
		return v�rde;
	}
	public String getTyp(){
		return sNamn;
	}

}
