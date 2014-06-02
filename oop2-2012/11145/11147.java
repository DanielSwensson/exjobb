
public class Jewellery extends Article {

		private String silverOrGold; 
		private int numberOfStones; 
				
		public Jewellery (String name, String silverOrGold, int numberOfStones){
			super (name);
			this.silverOrGold = silverOrGold;
			this.numberOfStones = numberOfStones;
		}
		
		public double value(){
			int value;
			if (this.silverOrGold.equalsIgnoreCase("g")){
					value = 2000 + (this.numberOfStones*500);
					return value;
				} else {
					value = 700+(this.numberOfStones*500);
				} return value;
		}
		
		//public String toString () { 
		//	return  "Smycke: " + super.toString () + " i " + sortGuldSilver + " med " + numberOfStones + " st ädelstenar." ;
		//			}
}
