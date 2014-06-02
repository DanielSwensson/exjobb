
abstract public class Pryl  {

	private String prylNamn;
	private String prylTyp;
						




	public Pryl (String prylNamn, String prylTyp){

		this.prylNamn = prylNamn;
		this.prylTyp = prylTyp;
	}

	

	public String getprylNamn(){
		return prylNamn;
	}

	public String getprylTyp(){
		return prylTyp;
	}


	public abstract int getVŠrde();
}


