
public class apparat extends Prylar{

	private int slitage;
	
	apparat(String sättPNamn, String sättTyp, int sättVärde, String namn, int sättSlitage,int förmögenhet) {
		super(sättPNamn, sättTyp, sättVärde, namn,förmögenhet);
		slitage=sättSlitage;
		// TODO Auto-generated constructor stub
	}
	
	public int getSlitage(){
		return slitage;
	}
	public String toString(){
		return "namn: "+getNamn()+" prylnamn: "+getPNamn()+" typ: "+getTyp()+" värde: "+getVärde()+" Slitage: "+slitage;
	}
	

}
