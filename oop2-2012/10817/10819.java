
public class Apparat extends Pryl {

	private double ink�psPris;
	private int slitage;
	
	public Apparat(String str1, double nr1, int nr2){
		super(str1);
		ink�psPris=nr1;
		slitage=nr2;
	}
	public double getV�rde(){
		return ink�psPris*slitage/10;
	}
	
}
