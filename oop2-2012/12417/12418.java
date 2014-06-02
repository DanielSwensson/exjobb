public class Device extends Valuable{
	private int wear = 10;
	private double startingValue = 1;
	private double currentValue =0;
	private double division = 10.0;

	public Device(String n, int w, double s){
		this.setName(n);
		this.wear = w;
		this.startingValue = s;
		//this.currentValue= startingValue*(wear*wear/division);
	}

	public void setWear(int w){
		this.wear = w;
	}

	public int getWear(){
		return wear;
	}

	public double getStartingValue(){
		return startingValue;
	}

	public double getValue(){
		return startingValue*wear/10;
	}
}
