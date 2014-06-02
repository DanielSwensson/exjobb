import java.util.ArrayList;
public class Person {

	private String Namn;
	private ArrayList<Pryl> allaÄgodelar = new ArrayList<Pryl>();
	private int Summa;
	

	
	Person(String n){
		Namn = n;
	}
	
	Person (String nm, int sum){
		Namn = nm;
		Summa = sum;
	}
	
	public String getNamn(){
		return Namn;
	}
	

	public String toString(){
		return Namn + "       " + getSummaVärde(allaÄgodelar);
	}
	
	public ArrayList<Pryl> getAllaPrylar(){
		return allaÄgodelar;
	}
	
	public int getSummaVärde(ArrayList<Pryl> allaÄgodelar){
		Summa = 0;
		for(Pryl nu : allaÄgodelar){
			Summa += nu.getVärde();
		
		}
		return Summa;
	}
	
}
