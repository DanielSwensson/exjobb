
abstract public class Pryl {
private String namn;
private String ägare;

	public Pryl (String ägare, String namn){
	this.namn = namn;
	this.ägare = ägare;
	}
	abstract public int getVärde();
	
	public String getÄgare(){
		return ägare;
	}
	public String toString(){
		 return namn + "	" + getVärde();
	 }

 }