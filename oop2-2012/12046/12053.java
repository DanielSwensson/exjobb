
public class Smycke extends Pryl{
	private int ädelsten;
	private boolean guld;

	public double getVärde(){
		return (ädelsten * 500) + (guld ? 2000 : 700);
	}

	public Smycke(String namn, int ädelsten, boolean guld) {
		super(namn);
		this.ädelsten = ädelsten;
		this.guld = guld;
	}
	
}
