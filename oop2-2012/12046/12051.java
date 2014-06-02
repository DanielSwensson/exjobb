
public abstract class Pryl {
	private String prylNamn;
	public abstract double getVärde();
	
	
	public Pryl(String namn) {
		this.prylNamn = namn;
	}
	
	public String toString (){
		return prylNamn + " " + getVärde();
	}
	
	public void påverkaAvKrasch() {
		
	}
}
