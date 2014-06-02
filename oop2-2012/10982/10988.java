
class Smycke extends Pryl {

	private String pNamn;
	private String material;
	private int ädelstenar;

	public Smycke (String pNamn, String material, int ädelstenar) {
		this.pNamn = pNamn;
		this.material = material;
		this.ädelstenar = ädelstenar;
	}

	public String getpNamn(){
		return pNamn;
	}

	public int värde() {
		if (material.equalsIgnoreCase("Ja")) {
			return (2000+500*ädelstenar);
		}
		else {
			return (700+500*ädelstenar);

		}

	}


}
