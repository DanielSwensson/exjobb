
public class Smycken extends Pryl {
	private String smycke;
	private String guld;
	private int ädelsten;

	Smycken (String ä, String s, String g, int äs){
		super(ä);
		smycke = s;
		guld = g;
		ädelsten = äs;
	}

	public String getGuld(){
		return guld;
	}

	public String toString(){
		return "Smycket är en/ett " +smycke +". Den är i guld: "+guld +". Smycket har " +ädelsten +" ädelstenar och är värd " +getVärde() +" kr.";
	}

	public double getVärde(){
		if (guld.equalsIgnoreCase("ja")){
			return 2000 + (ädelsten * 500);
		}else{
			return 700 + (ädelsten * 500);
		}
	}

}
