import java.util.ArrayList;

public class Person {

	private ArrayList<Pryl> allaPrylar = new ArrayList<Pryl> ();
	private String namn = null; 

	public Person(String newNamn) {
		namn = newNamn;
	}

	public String getNamn() {
		return namn;
	}

	public String toString() {
		int fm = 0;
		fm=getVarde();

		String agare = "Namn:" + namn+" har "+fm;
		return agare;		
	}

	void addPryl(Pryl pryl){
		allaPrylar.add(pryl);
	}

	void listaPrylar(){
		for (Pryl v : allaPrylar){
			System.out.println(v.getNamn() + "    " + v.varde()+"\n");
		}
	}

	public int getVarde() {
		int summa = 0;
		for (Pryl v : allaPrylar)
			summa += v.varde();
		return summa;
	}

	public String toString1(){
		return namn + getVarde();
	}

	public ArrayList<Pryl> getAllaPrylar(){
		return allaPrylar;
	} 
}

