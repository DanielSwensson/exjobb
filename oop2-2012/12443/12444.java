public class Aktier extends Prylar {

	private int antal;
	private	int pris;
	private String aNamn;


	public Aktier(String �, double v, String n, int a, int p) {
		super(�, v, n);
		antal = a;
		pris = p;
		aNamn = n;

	}
	public int setPris(int x){
		pris = x;
		return pris;
	}
	public String getTyp(){
		return aNamn;
	}
	public int getAntal(){
		return antal;
	}








}



