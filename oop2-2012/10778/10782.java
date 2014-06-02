import java.util.*;

public class Personer {
	ArrayList<Pryl> prylar = new ArrayList<Pryl>();

	private String namn;

	Personer(String namn) {
		this.namn = namn;

	} // ATTRIBUT PERS

	public String getNamn() {
		return namn;
	} // METOD NAMN

	public void addPryl(Pryl p) {
		prylar.add(p);

	}

	public int getTotalV�rde() {
		int summa = 0;
		for (int i = 0; i < prylar.size(); i++) {
			summa = prylar.get(i).getV�rde() + summa;

		}
		return summa;
	}

	public String getPrylar() {
		String prylString = "";
		for (int i = 0; i < prylar.size(); i++) {
			prylString+= prylar.get(i) + "\n";
		}
		return prylString;
	}
	public void getB�rs() {
		for (int i = 0; i < prylar.size(); i++) {
			if (prylar.get(i)instanceof Aktie)
				((Aktie)prylar.get(i)).getKrasch();
		}
	}// METOD G�R IGENOM ALLA PRYLAR,KALLA METOD FR�N AKTIE 
} // KLASSEN
