abstract public class Pryl {
	private String prylNamn;

	public Pryl (String prylNamn){
		this.prylNamn=prylNamn;
	}

	public String getNamn () {
		return prylNamn;
	}
	public abstract int getV�rde () ;

	public String toString (){
		return  prylNamn +"\t"+ getV�rde ();
	}



}
