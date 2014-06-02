
public class Smycke extends Pryl{

	private boolean guld; 
	private int �delstenar;	

	public Smycke(String tap, boolean guld, int �delstenar) {
		super(tap);
		this.�delstenar = �delstenar;
		this.guld = guld;
	}	

	@Override
	public double getValue() {
		if(guld){
			return (�delstenar * 500) + 2000;
		}
		else{
			return (�delstenar * 500) + 700;
		}
	}	

}
