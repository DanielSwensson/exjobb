
public class Apparater extends Prylar{

	private int inköpsPris;
	private int slitage;
	private double summa;
	
	public Apparater(String namn, int inköpsPris, int slitage){
		super(namn);
		
		this.inköpsPris= inköpsPris;
		this.slitage= slitage;
		
		summa= inköpsPris*(slitage/10.0);
		
	}
	public double värde(){
		return summa;
	}
	public String toString(){
		return "Namn: "+ getNamn() +" Inköpspris: "+ inköpsPris+" Slitage: "+ slitage+ " Summa: "+summa;
	}
	
	public void setInköpspris(int newInköpsPris){
		inköpsPris = newInköpsPris;
	}
	
	public void setSlitage(int newSlitage){
		slitage= newSlitage;
	}
	
	public int getInköpsPris(){
		return inköpsPris;
	}
	
	public int getSlitage(){
		return slitage;
	}
	
	public void setPrisAktie(int newPris) {
		
		
	}
	
}
