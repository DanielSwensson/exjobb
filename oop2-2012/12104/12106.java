import java.util.ArrayList;
import java.util.Objects;

class Person {
	private String namn;
	private ArrayList<Vardesak> värdesaker = new ArrayList<Vardesak>();

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

	public ArrayList<Vardesak> getVärdesaker() {
		return värdesaker;
	}

	public int getVärdesakersSammanlagdaVärde() {
		int sammanlagtVärde = 0;

		if (!värdesaker.isEmpty()) {
			for (Vardesak värdesak : värdesaker) {
				sammanlagtVärde += värdesak.getVärde();
			}
		}

		return sammanlagtVärde;
	}

	public void registreraVärdesak(Vardesak värdesak) {
		värdesaker.add(Objects.requireNonNull(värdesak));
	}

	public String toString() {
		return getNamn() + " värd " + getVärdesakersSammanlagdaVärde() + " kr";
	}
}
