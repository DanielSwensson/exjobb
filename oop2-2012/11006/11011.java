
abstract class Pryl {

	private String prylNamn;

	public Pryl(String prylNamn){
		this.prylNamn = prylNamn;
	}

	abstract double v�rde();

	public String toString(){
		return prylNamn + " "+v�rde()+"\n";
	}

}
