
public class Aktie extends Pryl{
	private int amount;
	private int worth;

	public Aktie(String typ, int amount, int worth){
		super(typ);
		this.amount=amount;
		this.worth=worth;
	}
	//Värde av aktierna (beräkning antal gånger värdet)
	public double value() {
		return (amount*worth);
	}
	//Vid börskrachen är värdet 0
	public void krasch(){
		worth=0;
	}
}

