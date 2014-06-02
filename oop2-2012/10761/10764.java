public class Jewelry extends Valuable {
	private boolean isGold=false;
	private int stones=0;	
	
	public Jewelry() {
		String isGold=null;
		this.name=Register.promptString("Please enter a description of the item", "name: ");
		while (isGold == null){
			isGold=Register.promptString("is this made of Gold or Silver?", "Gold/Silver:").trim().toLowerCase();
			if (isGold.startsWith("g")){
				this.isGold=true;
			} else if (isGold.startsWith("s")){
				this.isGold=false;
			} else{
				isGold = null;
				System.out.println("Either Either Gold (G) or Silver (S)");
			}
		}
		this.stones=Register.promptInt("Please enter number of precious stones in the object", "ammount: ") ;
	}

	public Jewelry(String name, boolean isGold, int stones) {
		this.name=name;
		this.isGold=isGold;
		this.stones=stones;
	}
	public int getValue() {
		int goldPrize=2000;
		int silverPrize=700;
		int stonePrize=500;
		
		if (isGold) {
			return goldPrize + stones* stonePrize;
		} else {
			return silverPrize + stones* stonePrize;
		}
	}

	public String toString() {	
		return String.format(listFormat," Jewelry:",this.name, this.getValue());
	}

	public void crash() {
		//NOOP gold can't crash
	}

}
