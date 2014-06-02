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

	public int getv�rde() {
		int prylv�rde = 0;
		for(Pryl v: prylList) {
			prylv�rde += v.getv�rde();
		}
		return prylv�rde;
	}

	public String toString() {
		return namn + "\t" +getv�rde() + "\n";
	}

	public String visaprylar() {
		String prylar = ""; 
		for(Pryl p : prylList)
			prylar += p.toString();
		return prylar;
	}

	public void L�ggaTillPryl(Pryl p) {
		prylList.add(p);
	}

	public ArrayList<Pryl> getprylar() {
		return prylList;
	}
}
