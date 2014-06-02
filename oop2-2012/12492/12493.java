package Inlupp2;

public class Device extends Valuable {
	private int wear;
	private int price;
	static final int MAX_WEAR =10;
	static final int MIN_WEAR =0;


	public Device(String name, int wear, int price) {
		super(name);
		this.wear=wear;
		this.price=price;
		//Sätts variablen wear till mindre än MIN_WEAR blir wear 0. 
		//Sätts variablen wear till mer än MAX_WEAR blir wear 10.
		if (wear<MIN_WEAR)
			this.wear = 0;
		if (wear>MAX_WEAR)
			this.wear = 10;
	}
// räknar ut värdet. 
	public double getWorth(){
		double worth = (wear/10.0)*price;

		return worth;
	}

}

