
public class Smycke extends Pryl {

	private int antalÄdelstenar;
	private boolean metall;	


	public Smycke (int antStenar, String metalltyp,String pt, String n){
		super(pt, n);
		antalÄdelstenar = antStenar;
		if(metalltyp.equalsIgnoreCase("guld")){
			metall = true;
		}

	}

	public int getAntalÄdelstenar(){
		return antalÄdelstenar;
	}


	public double getVärde() {
		if (metall){
			return 2000 + (antalÄdelstenar * 500);
		}
		else{
			return 700 + (antalÄdelstenar * 500);
		}

	}
}
