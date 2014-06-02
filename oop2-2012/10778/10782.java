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

	public int getTotalVärde() {
		int summa = 0;
		for (int i = 0; i < prylar.size(); i++) {
			summa = prylar.get(i).getVärde() + summa;

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
	public void getBörs() {
		for (int i = 0; i < prylar.size(); i++) {
			if (prylar.get(i)instanceof Aktie)
				((Aktie)prylar.get(i)).getKrasch();
		}
	}// METOD GÅR IGENOM ALLA PRYLAR,KALLA METOD FRÅN AKTIE 
} // KLASSEN
