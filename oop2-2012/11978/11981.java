import java.util.*;
public class Person {

	ArrayList<Pryl> prylar = new ArrayList<Pryl>();

	private String namn;
	
	public Person (String namn){
		this.namn = namn;
	}
	
	public double getVärde(){
		double totalVärde=0;
		for (int index=0;index<prylar.size();index++){
			totalVärde = totalVärde + prylar.get(index).getVärde();
		}
		return totalVärde;
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
		return (namn+" "+getVärde());
	}	
}