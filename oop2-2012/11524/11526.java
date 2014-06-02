//En subklass till Pryl, som beskriver en pryl av typ Apparat
public class Apparat extends Pryl {
	
	private int ink�pspris;
	private int slitage;
	
	public Apparat (String namn,int v�rde, int ink�pspris, int slitage){
		super(namn, v�rde);
		this.ink�pspris = ink�pspris;
		this.slitage = slitage;
		r�knaV�rde();
	}
	
	public int getInk�pspris(){
		return ink�pspris;
	}
	
	public int getSlitage (){
		return slitage;
	}
	
	public void r�knaV�rde (){
		super.v�rde =(this.ink�pspris * (this.slitage*10))/100;
		
	}
}
