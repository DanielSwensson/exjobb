
public class Aktie extends Pryl{
	private int amount;
	private int worth;

	public Aktie(String typ, int amount, int worth){
		super(typ);
		this.amount=amount;
		this.worth=worth;
	}
	//V�rde av aktierna (ber�kning antal g�nger v�rdet)
	public double value() {
		return (amount*worth);
	}
	//Vid b�rskrachen �r v�rdet 0
	public void krasch(){
		worth=0;
	}
}

