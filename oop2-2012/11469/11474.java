import java.util.ArrayList;
public class Person {

	private String Namn;
	private ArrayList<Pryl> alla�godelar = new ArrayList<Pryl>();
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
		return Namn + "       " + getSummaV�rde(alla�godelar);
	}
	
	public ArrayList<Pryl> getAllaPrylar(){
		return alla�godelar;
	}
	
	public int getSummaV�rde(ArrayList<Pryl> alla�godelar){
		Summa = 0;
		for(Pryl nu : alla�godelar){
			Summa += nu.getV�rde();
		
		}
		return Summa;
	}
	
}
