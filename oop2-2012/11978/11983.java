
public class Smycke extends Pryl{

	private boolean guld;
	private int stenar;

	public Smycke (String pNamn, boolean guld, int stenar){
		super(pNamn);
		this.guld = guld;
		this.stenar = stenar;
	}
	
	public double getV�rde(){
		if (guld){
			v�rde = 2000;
		}else{
			v�rde = 700;
		}
		v�rde = v�rde + (500 * stenar);
		return v�rde;
	}

	public String toString(){
		return super.toString();
	}

}

