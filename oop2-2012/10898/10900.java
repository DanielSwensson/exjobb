
public class apparat extends Prylar{

	private int slitage;
	
	apparat(String s�ttPNamn, String s�ttTyp, int s�ttV�rde, String namn, int s�ttSlitage,int f�rm�genhet) {
		super(s�ttPNamn, s�ttTyp, s�ttV�rde, namn,f�rm�genhet);
		slitage=s�ttSlitage;
		// TODO Auto-generated constructor stub
	}
	
	public int getSlitage(){
		return slitage;
	}
	public String toString(){
		return "namn: "+getNamn()+" prylnamn: "+getPNamn()+" typ: "+getTyp()+" v�rde: "+getV�rde()+" Slitage: "+slitage;
	}
	

}
