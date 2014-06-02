
public class Smycke extends Pryl{

	private boolean guld; 
	private int ädelstenar;	

	public Smycke(String tap, boolean guld, int ädelstenar) {
		super(tap);
		this.ädelstenar = ädelstenar;
		this.guld = guld;
	}	

	@Override
	public double getValue() {
		if(guld){
			return (ädelstenar * 500) + 2000;
		}
		else{
			return (ädelstenar * 500) + 700;
		}
	}	

}
