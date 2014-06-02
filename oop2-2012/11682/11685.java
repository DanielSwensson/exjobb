package Inlupp2;

public class Jewelry extends Item {
	private int gemstone;
	private String material;
	private double value;

	public Jewelry(String na, String ma, int gem) {
		super(na);
		this.gemstone = gem;
		this.material = ma;

	}

	public double getValue() {
		if (material.equalsIgnoreCase("guld")) {
			value = (2000 + (500 * gemstone));
		} else if (material.equalsIgnoreCase("silver")) {
			value = (700 + (500 * gemstone));
		}
		return value;
	}
}
