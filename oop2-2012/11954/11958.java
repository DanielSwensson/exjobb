import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	private String namn;
	ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>();
	Scanner keyboard = new Scanner(System.in);

	Person(String str) {
		namn = str;
	}

	protected String getNamn() {
		return namn;
	}

	public String allaPrylar() {
		for (Pryl pr : allaPrylar)
			System.out.println(pr);
		return "";

	}

	Pryl getPryl(String namn) {
		for (Pryl pr : allaPrylar)
			if (pr.getSort().equalsIgnoreCase(namn))
				return pr;
		return null;
	}

	public void nollställaAktier() {
		for (Pryl ak : allaPrylar)
			if (ak instanceof Aktier)
				 ((Aktier) ak).börskrasch();
		
	}

	public int summaVärde() {
		int summa = 0;
		for (Pryl pr : allaPrylar)
			summa += pr.getVärde();
		return summa;

	}

	public boolean AddPryl(Pryl ny) {
		return allaPrylar.add(ny);
	}

}
