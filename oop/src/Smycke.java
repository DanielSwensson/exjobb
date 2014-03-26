public class Smycke extends Pryl{
	private int antal�delstenar;
	private String material;
	private int v�rde;
	private final int VAL1 = 700;
	private final int VAL2 = 500;
	private final int val3 = 2000;
	
	public Smycke(String prylTyp, int a, String m) {
		super(prylTyp);
		antal�delstenar = a;
		material = m;
	}
	
	public int getV�rde(){
		if (material.equalsIgnoreCase("guld")) {
			v�rde = val3 + antal�delstenar * VAL2;
		}
		else if (material.equalsIgnoreCase("silver")) {
			v�rde = VAL1 + antal�delstenar * VAL2;
		}
		return v�rde;
	}
}
