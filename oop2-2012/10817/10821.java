
public abstract class Pryl {
	
	private String namn;
	
	public Pryl(String str1){
		namn=str1;
	}
	
	public abstract double getV�rde();
	
	
	public String toString(){
    	return namn+"\t\t"+getV�rde();
	}
}
