public class Smycke extends Pryl {

	private String metallTyp;
	private int antalÄdelstenar;

	public Smycke (String prylNamn,String metallTyp, int antalÄdelstenar) {
		super(prylNamn);
		this.prylNamn = prylNamn;
		this.metallTyp = metallTyp;
		this.antalÄdelstenar = antalÄdelstenar;
		setvärde();
	}

	public void setvärde() {
		if(metallTyp.equalsIgnoreCase("guld")) {
			värde = 2000 + antalÄdelstenar * 500; 
		} else if(metallTyp.equalsIgnoreCase("silver")) {
			värde = 700 + antalÄdelstenar * 500;
		}
	}
}
