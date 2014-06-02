
abstract class Pryl {

	private String prylNamn;

	public Pryl(String prylNamn){
		this.prylNamn = prylNamn;
	}

	abstract double värde();

	public String toString(){
		return prylNamn + " "+värde()+"\n";
	}

}
