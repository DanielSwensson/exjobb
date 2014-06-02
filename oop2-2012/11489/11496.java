public class Jewelry extends Item {
	private boolean isGold;
	private int numberStones;

	public Jewelry(String name, boolean isGold, int numberStones) {
		this.name = name;
		this.isGold = isGold;
		this.numberStones = numberStones;
	}

	public double getValue() {
		if (isGold) {
			return 2000 + numberStones * 500;
		} else {
			return 700 + numberStones * 500;
		}
	}
}

// Smycken: om smycket �r av guld s� �r v�rdet 2000, om det �r av silver s� �r
// v�rdet 700. Dessutom �kar v�rdet med 500 f�r varje �delsten
