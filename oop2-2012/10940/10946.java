class Smycke extends Pryl {

	private int Šdelsten;
	private boolean smycke;
	private int vŠrde;

	public Smycke (String prylNamn, int Šdelsten, boolean smycke) {
		super (prylNamn);

		this.Šdelsten = Šdelsten;
		this.smycke = smycke;

	}

	public int getSmycke(){	

		if (smycke) {			
			return (2000 + Šdelsten*500);						
		}
		else {				
			return (700 + Šdelsten*500);
		}
	}
	
	public double getVŠrde(){
		return vŠrde = getSmycke();
	}
		
}

