import java.util.ArrayList;

public class Person {

	private String namn;

	ArrayList<Pryl> prylar = new ArrayList<Pryl>();

	public Person(String namn) {
		this.namn = namn;
	}

	public int summaVärde(ArrayList<Pryl> prylar) {
		int summa = 0;
		for (Pryl x : prylar) {
			summa += x.värde();
		}
		return summa;
	}

	public String getNamn() {
		return namn;
	}

	public String toString() {
		return namn + "  " + summaVärde(prylar);
	}

	public void listaPrylar() {
		for (Pryl x : prylar) {
			System.out.println(x);
		}
	}
}