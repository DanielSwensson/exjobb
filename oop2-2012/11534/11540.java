public class Stock extends Item{
	private int price;
	private int amount;
	private int value;
	
	Stock(String name, String owner, int price, int amount){
		super(name, owner);
		this.price = price;
		this.amount = amount;
	}
		public int getPrice(){
			return price;
		}
		public void setPrice(int newPrice){
			this.price = newPrice;
		}
		public void addAmount(int newAmount){
			this.amount += newAmount;
		}
		public int getAmount(){
			return amount;
		}
		public double value(){
			return value = price * amount;
		}
}