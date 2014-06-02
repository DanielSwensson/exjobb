
public class Smycke extends Pryl{

	private boolean guld;
	private int stenar;

	public Smycke (String pNamn, boolean guld, int stenar){
		super(pNamn);
		this.guld = guld;
		this.stenar = stenar;
	}
	
	public double getVärde(){
		if (guld){
			värde = 2000;
		}else{
			värde = 700;
		}
		värde = värde + (500 * stenar);
		return värde;
	}

	public String toString(){
		return super.toString();
	}

}

