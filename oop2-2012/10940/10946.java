class Smycke extends Pryl {

	private int �delsten;
	private boolean smycke;
	private int v�rde;

	public Smycke (String prylNamn, int �delsten, boolean smycke) {
		super (prylNamn);

		this.�delsten = �delsten;
		this.smycke = smycke;

	}

	public int getSmycke(){	

		if (smycke) {			
			return (2000 + �delsten*500);						
		}
		else {				
			return (700 + �delsten*500);
		}
	}
	
	public double getV�rde(){
		return v�rde = getSmycke();
	}
		
}

