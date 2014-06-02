public class Apparat extends Pryl {
	int slitage;
	int pris;

	public double getValue() {
		return (slitage / 10.0) * (pris);
	}

	public Apparat(String name, int p, int s) {
		super(name);
		pris=p;
		slitage=s;

	}
	public String toString(){
		return namn +" "+  getValue()  ;
	}

}

