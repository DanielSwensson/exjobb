
class person {
	
	private String personName;
	private int personNetWorth;
	public person(String n, int pw){
		personName = n;
		personNetWorth = pw;
	}
	
	public String getPersonName(){
		return personName;
	}
	public int getPersonNetWorth(){
		return personNetWorth;
	}
	
	public String toString(){
		return "" + personName + " " + personNetWorth; 
	}
	public void setPersonNetWorth(int pw){
		personNetWorth = personNetWorth +  pw;
	}

}

class item extends person {
	private String itemOwner;
	private String itemType; // �R det ett smycke, aktie, apparat!
	private String itemName; // Vad �r det f�r sorts smycke eller aktie!? 
	private int itemWorth; // Vad �r det v�rt?!
	
	public item(String n, int pw, String it, String in, int iw){
		super(n,pw);
		itemOwner = n;
		itemName = in;
		itemType = it;
		itemWorth = iw;
		pw = pw + itemWorth;
	}
	public String getItemType(){
		return itemType;
	}
	public String getItemName(){
		return itemName;
	}
	public int getItemWorth(){
		return itemWorth;
	}
	public void setItemWorth(int iw){
		itemWorth = iw;
	}
	public String getItemOwner(){
		return itemOwner;
	}
}

class stock extends item {
	private int stockAmount;
	private int stockPrice;
	public stock(String n, int pw, String it, String in, int iw, int sa, int sp){
		super(n,pw,it,in,iw);
		stockAmount = sa;
		stockPrice = sp;
	}	
}

class jewlery extends item{
	private int gemStones;
	private String gemMaterial;
	public jewlery(String n, int pw, String it, String in, int iw, int gs, String gm){
		super(n,pw,it,in,iw);
		gemStones = gs;
		gemMaterial = gm;
		
		
	}
}

class appliance extends item{
	private int condition;
	 private int boughtPrice; 
	public appliance(String n, int pw, String it, String in, int iw, int c, int bp) {
		super(n, pw, it, in, iw);
		condition = c; 
		boughtPrice = bp; 
	}
	
}

