//En superklass som innehåller parametrar som är gemensamma för alla prylar
public class Pryl {
	
	String namn;
	int värde;
	private boolean ärAktie = false;
	
	public Pryl (String namn, int värde){
		this.namn = namn;
		this.värde = värde;
	}
	
	public String getNamn (){
		return namn;
	}
	
	public int getVärde() {
		return this.värde;
	}
	
	public boolean ärAktie (){
		return ärAktie;
	}
}
