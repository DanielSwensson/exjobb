public class Apparat extends Pryl{
		private double price;
		private double wear;
//Pris och slitage
		public Apparat(String typ, double price, double wear){
			super(typ);
			this.price=price;
			this.wear=wear;
		}
//(Ber�kning f�r priset
		public double value() {
			return wear/10 * price;
		}
	}