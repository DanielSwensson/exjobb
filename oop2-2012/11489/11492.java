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

// Apparater: värdet varierar beroende på slitaget.
// Om slitaget är 10 (apparaten är ny) så är värdet lika med priset, är slitaget
// 9 är värdet 90% av priset, är slitaget 8 är värdet 80% av priset osv.
