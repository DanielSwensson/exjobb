
public class Strength extends Exercise {
	
	private double weight;

	public double getWeight(){
		return weight;
	}
	public Strength(String name, String equipment, double weight, int amount) {
		super(name, equipment, amount);
		this.weight = weight;
	}
	public Strength(String name, String equipment, double weight) {
		super(name, equipment);
		this.weight = weight;
	}
	public String toString(){
		return super.toString() + " på " + this.weight + "kg";
	}
}
