public class Aktie extends Pryl {

	public int amount;
	public double price;

	public Aktie(String n, int a, int p){
		super(n);
		amount=a;
		price=p;
	}
	public int getValue(){
	return (int) (amount*price);
	}
	public String getPrylName(){
		return name;
	}
	public void setCrash(){
		price=0;
	}
}