

public abstract class Thing {
	
	
	
	private String thingName;
	
	public Thing (String thingName){
		this.thingName = thingName;
		
	}
	
	abstract int getValue();
	
	public String getThingName() {return thingName;}
	
}


class Shares extends Thing {

	private int price;
	private int amountShares;
	
	public Shares(String thingName, int price, int amountShares) {
		
		super(thingName);
		this.price = price;
		this.amountShares = amountShares;
	}

	private int setValue() {
		
		return price*amountShares;
	}

	protected int getValue(){
		return setValue();
	}
	
	public void smCrash(){
		
		System.out.println("Börskrasch! Alla ägda aktiers värde går ner till 0 kr.");
		price = 0;
	}
}


class Jewelry extends Thing {
	private boolean gold;
	private int gemstones;
	
	public Jewelry (String thingName, Boolean gold, int gemstones){
	
		super(thingName);
		this.gold = gold;
		this.gemstones = gemstones;	
	}
	
	protected int getValue(){return setValue();}
	
	private int setValue(){
	
		if(gold){
			return 2000 + (500*gemstones);
		}
		else{
			return 700 + (500*gemstones);
		}
	}
}


class Appliances extends Thing {

	private int price;
	private int wear;
	
	
	public Appliances(String thingName, int price, int wear) {
		
		super(thingName);
		this.price = price;
		this.wear = wear;
	}


	private int setValue(){
		
	
		double counter = wear /10.0;
		int value=(int) (price*counter);
		return value;
		
	}
	
	protected int getValue(){
		return setValue();
	}

}

	

