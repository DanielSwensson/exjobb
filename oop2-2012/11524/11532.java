//En subklass till Pryl, som beskriver en pryl av typ Smyckes
public class Smycke extends Pryl {

	private int ädelstenar;
	private boolean guld;
	
	
	public Smycke (String namn, int värde, int ädelstenar, boolean guld){
		super(namn, värde);
		this.ädelstenar = ädelstenar;
		this.guld = guld;
		räknaVärde();
	}
	
	public int getÄdelsten (){
		return ädelstenar;
	}
	
	public boolean getGuld(){
		return guld;
	}
	public void setGuld (boolean guld){
		this.guld = guld;
	}
	
	public void setÄdelstenar (int ädelstenar){
		this.ädelstenar = ädelstenar;
	}
	
	public int räknaVärde (){
		if (guld){
			this.värde= 2000 + (ädelstenar * 500);
			return this.värde;
		} else {
			this.värde = 700 + (ädelstenar * 500);
			return this.värde;
		}
	}	
}
