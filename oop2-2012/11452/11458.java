class Aktie extends Pryl{

	private int antal, pris;

	public Aktie(String pN, Person o, int a, int p){

		super(pN, o);
		antal = a;
		pris = p;

	}


	public int getValue(){

		value = antal * pris;

		return value;

	}

	public void setPris(){

		int p = 0;
		pris = p;

	}


}//class