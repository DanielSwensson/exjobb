import java.util.ArrayList;
import java.util.Objects;

class Person {
	private String namn;
	private ArrayList<Vardesak> v�rdesaker = new ArrayList<Vardesak>();

	public Person(String namn) {
		setNamn(namn);
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		if (namn.equals(""))
			throw new IllegalArgumentException();

		this.namn = Objects.requireNonNull(namn);
	}

	public ArrayList<Vardesak> getV�rdesaker() {
		return v�rdesaker;
	}

	public int getV�rdesakersSammanlagdaV�rde() {
		int sammanlagtV�rde = 0;

		if (!v�rdesaker.isEmpty()) {
			for (Vardesak v�rdesak : v�rdesaker) {
				sammanlagtV�rde += v�rdesak.getV�rde();
			}
		}

		return sammanlagtV�rde;
	}

	public void registreraV�rdesak(Vardesak v�rdesak) {
		v�rdesaker.add(Objects.requireNonNull(v�rdesak));
	}

	public String toString() {
		return getNamn() + " v�rd " + getV�rdesakersSammanlagdaV�rde() + " kr";
	}
}
