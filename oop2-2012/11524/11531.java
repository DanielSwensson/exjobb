//En superklass som inneh�ller parametrar som �r gemensamma f�r alla prylar
public class Pryl {
	
	String namn;
	int v�rde;
	private boolean �rAktie = false;
	
	public Pryl (String namn, int v�rde){
		this.namn = namn;
		this.v�rde = v�rde;
	}
	
	public String getNamn (){
		return namn;
	}
	
	public int getV�rde() {
		return this.v�rde;
	}
	
	public boolean �rAktie (){
		return �rAktie;
	}
}
