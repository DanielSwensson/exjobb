
public class Stuff extends Article {
	
		private int price;
		private double wear;
		
		public Stuff (String name, int price, double wear){
			super (name);
			this.price = price;
			this.wear = wear;
		}
		
		public double value (){
			double value = this.price * this.wear/10; 
			return value;
	}
		
}
