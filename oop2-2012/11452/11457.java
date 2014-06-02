class Smycke extends Pryl{

	private String smyckSort;
	private int metall, antalStenar;


	public Smycke(String pN, Person o, int m, int aS){

		super(pN, o);
		metall = m;
		antalStenar = aS;

	}


	public int getValue(){
		int m;

		int i = antalStenar * 500;

		if(metall == 1) {
			m = 700;
		} else
		{
			m = 2000;
		}
		value = m + i;

		return value;

	}


}//class