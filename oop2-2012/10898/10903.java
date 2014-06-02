
public abstract class Prylar extends Personer{
	private String pNamn,typ;
	private int värde;
	
	
	Prylar(String sättPNamn, String sättTyp, int sättVärde, String namn, int förmögenhet){
		super(namn,förmögenhet);
		pNamn = sättPNamn;
		typ = sättTyp;
		värde = sättVärde;
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
	public int getVärde(){
		return värde;
	}
	public int sänka(int mindre){
		return värde-=mindre;
	}
}
