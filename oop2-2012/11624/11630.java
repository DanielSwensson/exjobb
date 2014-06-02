
public class Smycken extends Pryl {
	private String smycke;
	private String guld;
	private int �delsten;

	Smycken (String �, String s, String g, int �s){
		super(�);
		smycke = s;
		guld = g;
		�delsten = �s;
	}

	public String getGuld(){
		return guld;
	}

	public String toString(){
		return "Smycket �r en/ett " +smycke +". Den �r i guld: "+guld +". Smycket har " +�delsten +" �delstenar och �r v�rd " +getV�rde() +" kr.";
	}

	public double getV�rde(){
		if (guld.equalsIgnoreCase("ja")){
			return 2000 + (�delsten * 500);
		}else{
			return 700 + (�delsten * 500);
		}
	}

}
