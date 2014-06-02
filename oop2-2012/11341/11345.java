// Av Emil Isaksson & Oscar Larsson DSK:1 OOP HT12		

import java.util.ArrayList;

public class Person {

	private String personNamn;

	private ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>();

	public Person(String personNamn) {
		this.personNamn = personNamn;

	}

	public void addAllaPrylar(Pryl p) {
		allaPrylar.add(p);
	}

	public String listaAllaPrylar() {
		String listan = "";
		for (int i = 0; i < allaPrylar.size(); i++) {
			listan += " " + allaPrylar.get(i).getPrylNamn() + " "
					+ allaPrylar.get(i).getV�rde() + "\n";
		}
		return listan;
	}

	public String getPersonNamn() {
		return personNamn;
	}

	public String toString() {
		return personNamn;

	}

	public int getV�rde() {
		int totalV�rde = 0;
		for (int x = 0; x < allaPrylar.size(); x++)
			totalV�rde += allaPrylar.get(x).getV�rde();

		return totalV�rde;

	}

	public void getB�rskrasch() {

		for (int i = 0; i < allaPrylar.size(); i++) {
			if (allaPrylar.get(i) instanceof Aktie) {
				((Aktie) allaPrylar.get(i)).kraschadB�rs();
			}
		}
	}

}
