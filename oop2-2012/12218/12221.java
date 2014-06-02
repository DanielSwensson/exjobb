package personer.src.Package;

public class Apparater extends VardeSaker{


	public Apparater(String name, double pris ){
		super (name, pris);
	}

	
	public String toString(){
		return  "apparater: "+name+" värde:"+pris;
	}

}
