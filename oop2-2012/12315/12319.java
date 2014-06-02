public class Pryl {

	private String prylSort;
	private int prylVarde;
	private String prylNamn;

	public Pryl(String prylSort, String prylNamn) {
		this.prylSort = prylSort;
		this.prylNamn = prylNamn;
	}

	public int getVarde() {
		return prylVarde;
	}

	public String toString() {

		return " " + prylVarde;
	}

	public String getPrylSort() {
		return prylSort;
	}

	public String getPrylNamn() {
		return prylNamn;

	}

}
