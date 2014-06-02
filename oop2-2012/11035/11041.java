
public class Smycke extends Pryl {

	private int antal�delstenar;
	private boolean metall;	


	public Smycke (int antStenar, String metalltyp,String pt, String n){
		super(pt, n);
		antal�delstenar = antStenar;
		if(metalltyp.equalsIgnoreCase("guld")){
			metall = true;
		}

	}

	public int getAntal�delstenar(){
		return antal�delstenar;
	}


	public double getV�rde() {
		if (metall){
			return 2000 + (antal�delstenar * 500);
		}
		else{
			return 700 + (antal�delstenar * 500);
		}

	}
}
