package personer.src.Package;


public class VardeSaker {
	protected String name;
	protected double pris;

	public VardeSaker(String name, double pris){
		this.name=name;
		this.pris=pris;
}
	public double getPris(){
		return pris;
	}
}