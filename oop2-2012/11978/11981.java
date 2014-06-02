import java.util.*;
public class Person {

	ArrayList<Pryl> prylar = new ArrayList<Pryl>();

	private String namn;
	
	public Person (String namn){
		this.namn = namn;
	}
	
	public double getV�rde(){
		double totalV�rde=0;
		for (int index=0;index<prylar.size();index++){
			totalV�rde = totalV�rde + prylar.get(index).getV�rde();
		}
		return totalV�rde;
	}
	
	public void allaPrylar(){
		for (int index=0;index<prylar.size();index++){
			System.out.println(prylar.get(index));
		}
	}
	
	public String getNamn(){
		return namn;
	}

	public void addPryl(Pryl nyPryl){
		prylar.add(nyPryl);
	}
	
	public String toString(){
		return (namn+" "+getV�rde());
	}	
}