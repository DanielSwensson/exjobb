public abstract class Item {
	private String name;
	private String owner;
	abstract public double value(); 
	
	Item(String name, String owner){
		this.name = name;
		this.owner = owner;
	}
		public String getName(){
			return name;
		}
		public String getOwner(){
			return owner;
		}
}