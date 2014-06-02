public class Share extends Thing{
	private int amount;
	public Share(String name, double value, int amount){
		super(name, value);
		this.amount = amount;
	}
	public void setValue(double value){
		this.value = value;
	}
	public double getValue(){
		return this.value * this.amount;
	}
}
