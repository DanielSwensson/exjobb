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

// Smycken: om smycket är av guld så är värdet 2000, om det är av silver så är
// värdet 700. Dessutom ökar värdet med 500 för varje ädelsten
