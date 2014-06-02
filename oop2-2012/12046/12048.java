
public class Apparat extends Pryl{
	private double inkPris;
	private double slitage;

	public double getVärde(){
		return inkPris*(slitage/10);
	}
	public Apparat(String namn,double inkPris, int slitage){
		super(namn);
		this.inkPris= inkPris;
		this.slitage=slitage;
	}
}
