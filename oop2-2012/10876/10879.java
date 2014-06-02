import java.util.*;

public class Person {
	private ArrayList<Pryl> prylList = new ArrayList<Pryl>();

	private String namn;

	public Person(String namn) {
		this.namn = namn;
		this.prylList=new ArrayList<Pryl>();
	}

	public String getnamn() {
		return namn;
	}

	public int getvärde() {
		int prylvärde = 0;
		for(Pryl v: prylList) {
			prylvärde += v.getvärde();
		}
		return prylvärde;
	}

	public String toString() {
		return namn + "\t" +getvärde() + "\n";
	}

	public String visaprylar() {
		String prylar = ""; 
		for(Pryl p : prylList)
			prylar += p.toString();
		return prylar;
	}

	public void LäggaTillPryl(Pryl p) {
		prylList.add(p);
	}

	public ArrayList<Pryl> getprylar() {
		return prylList;
	}
}
