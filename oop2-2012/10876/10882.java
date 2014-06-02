public class Smycke extends Pryl {

	private String metallTyp;
	private int antal�delstenar;

	public Smycke (String prylNamn,String metallTyp, int antal�delstenar) {
		super(prylNamn);
		this.prylNamn = prylNamn;
		this.metallTyp = metallTyp;
		this.antal�delstenar = antal�delstenar;
		setv�rde();
	}

	public void setv�rde() {
		if(metallTyp.equalsIgnoreCase("guld")) {
			v�rde = 2000 + antal�delstenar * 500; 
		} else if(metallTyp.equalsIgnoreCase("silver")) {
			v�rde = 700 + antal�delstenar * 500;
		}
	}
}
