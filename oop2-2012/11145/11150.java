
	public class Share extends Article {

		protected int price;
		private int numberOfShares;
		
		public Share (String name, int price, int numberOfShares){
			super (name); 
			this.price = price;
			this.numberOfShares = numberOfShares;
		}
		
		public double value(){
			int value = (this.numberOfShares) * (this.price);
			return value;
		}
		
		public int changePrice (){
			this.price = 0;
			return price;
		}
		
}