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

		String agare = "Namn: " + namn+" har "+fm;
		return agare;		
	}

	void addPryl(Pryl pryl){
		allaPrylar.add(pryl);
		System.out.println("Pryl sparad \n");
	}

	void listaPrylar(){
	    	System.out.println();
		for (Pryl v : allaPrylar){
			System.out.println(v.getNamn() + " : " + v.varde());
		}
	}

	public int getVarde() {
		int summa = 0;
		for (Pryl v : allaPrylar)
			summa += v.varde();
		return summa;
	}

	//public String toString1(){
	//String ret = "Namn: " + namn + " har " + getVarde()+"";
	//return ret;
	//}

	public ArrayList<Pryl> getAllaPrylar(){
		return allaPrylar;
	} 
}