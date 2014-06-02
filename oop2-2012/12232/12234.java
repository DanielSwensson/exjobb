public class Apparat extends Pryl{

	public int purchacePrice;
	public int wear;

	public Apparat(String n, int pp, int w){
		super(n);
		purchacePrice=pp;
		wear=w;
	}

	public int getValue(){
		return (int) (purchacePrice*(1.0/10*wear));
	}
	public String getPrylName(){
		return name;
	}
}