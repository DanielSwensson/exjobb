package varderegister;

public class Smycke extends Pryl{

	private int juvel;
	private String metall;
	
	public Smycke(String namn, int juvel, String metall){
		super(namn);
		this.juvel = juvel;
		this.metall = metall;
		super.namn = namn;
	}
		
	public double varde(){
		if (metall.equalsIgnoreCase("guld")){
			return (double) 2000 + (500 * juvel);
		}
		if (metall.equalsIgnoreCase("silver")){
			return (double) 700 + (500 * juvel);
		}
			
		return (500 * juvel);
	}
	
	public String getNamn(){
		return this.namn;
	}
}
