
public class Apparater extends Pryl {
private int slitage;
private int ink�pspris;
	public Apparater (String �gare, String namn, int ink�pspris, int slitage){
		super(�gare, namn);
		this.ink�pspris = ink�pspris;
		this.slitage = slitage;
	}
	public int getV�rde (){
		return ((slitage*ink�pspris)/10);
	}
}

