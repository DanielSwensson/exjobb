
public class Smycke extends Pryl{

	private int ädelstenar;
	private int metalVärde;

	public Smycke(String prylNamn, int ädelstenar, int metalVärde){
		super(prylNamn);
		this.ädelstenar = ädelstenar;
		this.metalVärde = metalVärde;
	}
	public double värde(){
		return ((ädelstenar*500)+metalVärde);
	}
}