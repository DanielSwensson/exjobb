
public abstract class Pryl {
	private String prylNamn;
	public abstract double getV�rde();
	
	
	public Pryl(String namn) {
		this.prylNamn = namn;
	}
	
	public String toString (){
		return prylNamn + " " + getV�rde();
	}
	
	public void p�verkaAvKrasch() {
		
	}
}
