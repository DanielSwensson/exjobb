import java.util.ArrayList;

public class Person {

	private String namn;

	ArrayList<Pryl> prylar = new ArrayList<Pryl>();

	public Person(String namn) {
		this.namn = namn;
	}

	public int summaV�rde(ArrayList<Pryl> prylar) {
		int summa = 0;
		for (Pryl x : prylar) {
			summa += x.v�rde();
		}
		return summa;
	}

	public String getNamn() {
		return namn;
	}

	public String toString() {
		return namn + "  " + summaV�rde(prylar);
	}

	public void listaPrylar() {
		for (Pryl x : prylar) {
			System.out.println(x);
		}
	}
}