
public class Smycke extends Pryl{

	private int �delstenar;
	private int metalV�rde;

	public Smycke(String prylNamn, int �delstenar, int metalV�rde){
		super(prylNamn);
		this.�delstenar = �delstenar;
		this.metalV�rde = metalV�rde;
	}
	public double v�rde(){
		return ((�delstenar*500)+metalV�rde);
	}
}