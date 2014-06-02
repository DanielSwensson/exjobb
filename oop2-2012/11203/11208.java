abstract public class Pryl {
	private String prylNamn;

	public Pryl (String prylNamn){
		this.prylNamn=prylNamn;
	}

	public String getNamn () {
		return prylNamn;
	}
	public abstract int getVärde () ;

	public String toString (){
		return  prylNamn +"\t"+ getVärde ();
	}



}
