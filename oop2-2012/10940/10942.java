
class Apparat extends Pryl {
	private int ink�pspris;
	private double slitage;
	private double v�rde;
	
	public Apparat (String prylNamn, int ink�pspris, double slitage) {
		super(prylNamn);
		this.ink�pspris = ink�pspris;
		this.slitage = slitage;
		
		}
	
	public double getV�rde(){
		return v�rde = (slitage/10.0*ink�pspris);
	}

}

