public class Gadget extends Item {
	private int condition;
	private int price;

	public Gadget(String name, int condition, int price) {
		this.name = name;
		this.condition = condition;
		this.price = price;
	}

	public double getValue() {
		return price * (condition / 10.0);
	}
}

// Apparater: v�rdet varierar beroende p� slitaget.
// Om slitaget �r 10 (apparaten �r ny) s� �r v�rdet lika med priset, �r slitaget
// 9 �r v�rdet 90% av priset, �r slitaget 8 �r v�rdet 80% av priset osv.
