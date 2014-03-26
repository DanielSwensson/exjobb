public class Smycke extends Pryl{
	private int antalädelstenar;
	private String material;
	private int värde;
	private final int VAL1 = 700;
	private final int VAL2 = 500;
	private final int val3 = 2000;
	
	public Smycke(String prylTyp, int a, String m) {
		super(prylTyp);
		antalädelstenar = a;
		material = m;
	}
	
	public int getVärde(){
		if (material.equalsIgnoreCase("guld")) {
			värde = val3 + antalädelstenar * VAL2;
		}
		else if (material.equalsIgnoreCase("silver")) {
			värde = VAL1 + antalädelstenar * VAL2;
		}
		return värde;
	}
}
