
public class Apparat extends Pryl {

	private double inkopspris;
	private int slitage;
	public double getVarde;

	public Apparat(String namn, int inkopspris, int slitage){
		super(namn);
		this.inkopspris = inkopspris;
		this.slitage = slitage;
	}

	public double getVarde(){
		return (inkopspris*slitage)/10;
	}
}