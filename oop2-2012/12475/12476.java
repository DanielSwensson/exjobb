public class Appliance extends Thing{
	private int wear;
	public Appliance(String name, double value, int wear){
		super(name, value);
		this.wear = wear;
	}
	public double getValue(){
		return this.value * this.wear / 10;
	}
}

