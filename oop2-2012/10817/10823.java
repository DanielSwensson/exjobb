
public class Smycke extends Pryl {

	private int antalStenar;
	private boolean guld;
	
	public Smycke(String str1, int nr1, boolean bool){
		super(str1);
		antalStenar=nr1;
		guld=bool;
		
	}
	
	
	public double getVärde(){
		if(guld==true){
		return 2000+(antalStenar*500);
		}
		else{
			return 700+(antalStenar*500);
		}
	}

}
