
class Smycke extends Pryl {

	private String pNamn;
	private String material;
	private int �delstenar;

	public Smycke (String pNamn, String material, int �delstenar) {
		this.pNamn = pNamn;
		this.material = material;
		this.�delstenar = �delstenar;
	}

	public String getpNamn(){
		return pNamn;
	}

	public int v�rde() {
		if (material.equalsIgnoreCase("Ja")) {
			return (2000+500*�delstenar);
		}
		else {
			return (700+500*�delstenar);

		}

	}


}
