package varderegister;

public abstract class Pryl {
	
	protected  String namn;

	public Pryl(String typ){
		this.namn=typ;
	}
	
	public abstract double varde();

}
