
public class Apparater extends Pryl {
private int slitage;
private int inköpspris;
	public Apparater (String ägare, String namn, int inköpspris, int slitage){
		super(ägare, namn);
		this.inköpspris = inköpspris;
		this.slitage = slitage;
	}
	public int getVärde (){
		return ((slitage*inköpspris)/10);
	}
}

