
abstract public class Pryl {

	private String namn;
	private String pryltyp;


	public Pryl (String pt, String n){
		pryltyp = pt;
		namn = n;
	}

	public String toString(){
		return namn + "\t" + getV�rde();
	}

	abstract public double getV�rde();

	public String getNamn(){
		return namn;
	}

	public String getPryltyp (){
		return pryltyp;
	}
}