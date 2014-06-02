public class Smycke extends Pryl{
	private boolean �rGuld;
	private int �delstenar;
	
	public Smycke(String sort, boolean guldsmycke, int antalStenar) { //konstruktor
		namn = sort;
		�rGuld = guldsmycke;
		�delstenar = antalStenar;
	}
	
	public double getV�rde(){ //metod f�r att f� ut v�rdet p� ett smycke. Baseras p� om smycket �r utav guld och hur m�nga �delstenar det �r gjort utav
		if(�rGuld){
			return 2000+(500*�delstenar);
		}else{
			return 700+(500*�delstenar);
		}
	}


	public String getPrylSort() { //metod f�r att returnera vilken sorts pryl detta �r
		return "smycke";
	}

}
