
public class Smycken extends Pryl {

	private int antaladelsten, materialV;

	public Smycken (String smyckeTyp, String guldSilver,int inlantaladelsten) {
		super(smyckeTyp);
		antaladelsten = inlantaladelsten;
		if (guldSilver.equalsIgnoreCase("guld")){
			materialV=2000;
		}
		else {
			materialV=700; 	
		}
	}

	public int varde() {
		return materialV + (antaladelsten * 500); 
	}
}
