
class Apparat extends Pryl {
	private int inkšpspris;
	private double slitage;
	private double vŠrde;
	
	public Apparat (String prylNamn, int inkšpspris, double slitage) {
		super(prylNamn);
		this.inkšpspris = inkšpspris;
		this.slitage = slitage;
		
		}
	
	public double getVŠrde(){
		return vŠrde = (slitage/10.0*inkšpspris);
	}

}

