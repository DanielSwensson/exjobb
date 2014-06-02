public class Smycke extends Pryl{

	public String type;
	public int gemstoneAmount;

	public Smycke(String n, String t, int ga){
		super(n);
		type=t;
		gemstoneAmount=ga;
	}

	public int getValue(){
		for (;;)
			if (type.equalsIgnoreCase ("Guld"))
				return (2000+(500*gemstoneAmount));

			else if (type.equalsIgnoreCase("Silver"))
				return (700+(500*gemstoneAmount));
			else
				System.out.println("Felaktig input");

	}
	public String getPrylName(){
		return name;
	}

}