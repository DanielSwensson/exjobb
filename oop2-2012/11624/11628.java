import java.util.ArrayList;

public class Person {
	private String Namn;
	private ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>();
	private int Summa;

	Person (String n){
		Namn = n;
	}

	public String getNamn(){
		return Namn;
	}
	public String toString(){
		return Namn + "   " +getSumma() +" kr";
	}
	
	public ArrayList<Pryl> getAllaPrylar(){
		return allaPrylar;
	}

	public int getSumma(){
		Summa = 0;
		for (Pryl p : allaPrylar){
			Summa += p.getVärde();
		}
		return Summa;
	}
	
}



