
abstract public class Pryl {
	private String namn;
	
	public Pryl (String na){
		namn=na;
	}
	public String getNamn(){
		return namn;
	}
		public abstract double getVärde();


	public String toString () 
	{
	return namn + " " +getVärde();
	}
}
