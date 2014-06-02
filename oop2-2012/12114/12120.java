public class Smycke extends Pryl{
	private boolean ärGuld;
	private int ädelstenar;
	
	public Smycke(String sort, boolean guldsmycke, int antalStenar) { //konstruktor
		namn = sort;
		ärGuld = guldsmycke;
		ädelstenar = antalStenar;
	}
	
	public double getVärde(){ //metod för att få ut värdet på ett smycke. Baseras på om smycket är utav guld och hur många ädelstenar det är gjort utav
		if(ärGuld){
			return 2000+(500*ädelstenar);
		}else{
			return 700+(500*ädelstenar);
		}
	}


	public String getPrylSort() { //metod för att returnera vilken sorts pryl detta är
		return "smycke";
	}

}
