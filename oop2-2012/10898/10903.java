
public abstract class Prylar extends Personer{
	private String pNamn,typ;
	private int v�rde;
	
	
	Prylar(String s�ttPNamn, String s�ttTyp, int s�ttV�rde, String namn, int f�rm�genhet){
		super(namn,f�rm�genhet);
		pNamn = s�ttPNamn;
		typ = s�ttTyp;
		v�rde = s�ttV�rde;
	}
	
	public String toString(){
		return getNamn();
	}
	
	public String getPNamn(){
		return pNamn;
	}
	
	public String getTyp(){
		return typ;
	}
	public int getV�rde(){
		return v�rde;
	}
	public int s�nka(int mindre){
		return v�rde-=mindre;
	}
}
