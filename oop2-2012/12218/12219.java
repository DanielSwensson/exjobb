package personer.src.Package;

public class Aktier extends VardeSaker {



	public Aktier(String name, double pris ){
		super (name, pris);
	}
	public void setPris(double p){
		pris = p;
	}

	
	public String toString(){
		return  "aktier: "+name+" Värde :"+pris;
	}
}
