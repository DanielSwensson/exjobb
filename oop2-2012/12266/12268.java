
public class Apparater extends Prylar{

	private int ink�psPris;
	private int slitage;
	private double summa;
	
	public Apparater(String namn, int ink�psPris, int slitage){
		super(namn);
		
		this.ink�psPris= ink�psPris;
		this.slitage= slitage;
		
		summa= ink�psPris*(slitage/10.0);
		
	}
	public double v�rde(){
		return summa;
	}
	public String toString(){
		return "Namn: "+ getNamn() +" Ink�pspris: "+ ink�psPris+" Slitage: "+ slitage+ " Summa: "+summa;
	}
	
	public void setInk�pspris(int newInk�psPris){
		ink�psPris = newInk�psPris;
	}
	
	public void setSlitage(int newSlitage){
		slitage= newSlitage;
	}
	
	public int getInk�psPris(){
		return ink�psPris;
	}
	
	public int getSlitage(){
		return slitage;
	}
	
	public void setPrisAktie(int newPris) {
		
		
	}
	
}
