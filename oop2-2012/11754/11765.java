public class Smycke extends Pryl{
	private boolean gold;
	private int jewel;
	
	public Smycke(String typ, boolean gold, int jewel){	
		super (typ);
		this.gold=gold;
		this.jewel=jewel;
	}

//Pris med juveler
	public double value() {
		if (gold)
			return (2000+jewel*500);
		else
			return (700+jewel*500);
	}
}
