//En subklass till Pryl, som beskriver en pryl av typ Apparat
public class Apparat extends Pryl {
	
	private int inköpspris;
	private int slitage;
	
	public Apparat (String namn,int värde, int inköpspris, int slitage){
		super(namn, värde);
		this.inköpspris = inköpspris;
		this.slitage = slitage;
		räknaVärde();
	}
	
	public int getInköpspris(){
		return inköpspris;
	}
	
	public int getSlitage (){
		return slitage;
	}
	
	public void räknaVärde (){
		super.värde =(this.inköpspris * (this.slitage*10))/100;
		
	}
}
