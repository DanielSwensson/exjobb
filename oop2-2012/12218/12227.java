package personer.src.Package;

public class Smycken extends VardeSaker {

	
	public Smycken(String name, double pris) {
		super(name, pris);

	}

	
	public String toString(){
		return  "smycken: "+name+" V�rde :"+pris;
	}
}
