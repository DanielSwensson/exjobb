
public class Apparat extends Pryl {

	private double inköpsPris;
	private int slitage;
	
	public Apparat(String str1, double nr1, int nr2){
		super(str1);
		inköpsPris=nr1;
		slitage=nr2;
	}
	public double getVärde(){
		return inköpsPris*slitage/10;
	}
	
}
