
abstract public class Pryl {
private String namn;
private String �gare;

	public Pryl (String �gare, String namn){
	this.namn = namn;
	this.�gare = �gare;
	}
	abstract public int getV�rde();
	
	public String get�gare(){
		return �gare;
	}
	public String toString(){
		 return namn + "	" + getV�rde();
	 }

 }