import java.util.ArrayList;

public class Person {

	private ArrayList<Pryl> Pryllista = new ArrayList<Pryl>();

	private String namn;

	public Person(String n) {
		namn = n;

	}

	public void setNamn(String n) {
		namn = n;
	}

	public String getNamn() {
		return namn;
	}

	public void addPryl(Pryl nyPryl) {
		Pryllista.add(nyPryl);
	}

	public int summaVärde() { // detta är metoden för att rätt värde ska skrivas ut
								
		int summa = 0;
		for (Pryl aktuell : Pryllista)
			summa += aktuell.getVärde();
		return summa;
	}

	public String sakLista() {
		String sak = "";
		for (Pryl nuvarande : Pryllista)
			sak += nuvarande.getNamn() + "    " + nuvarande.getVärde() + "\n";
		return sak;
	}

	public ArrayList<Pryl> getPryllista() {
		return Pryllista;
	}

	public String toString() {
		return namn + " med ett totalt värde på " + summaVärde() + " kr";
	}

}
