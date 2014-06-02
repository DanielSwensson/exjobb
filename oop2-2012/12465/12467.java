import java.util.ArrayList;

public class Person {
	
		private String name;

		public Person(String name) {
			this.name = name;

		}

		public String getName() {
			return name;
		}
		
		private ArrayList<Thing> allThings = new ArrayList<Thing>();

		public ArrayList getAllThings() {
			return allThings;
		}

		public void setAllThings(ArrayList allThings) {
			this.allThings = allThings;
		}

		public double getTotal() {
			double totalValue = 0;
			for (Thing p : allThings) {
				totalValue = totalValue + p.getValue();
			}
			return totalValue;
		}

		public String toString() {
			return name + " med en total prylsumma av " + getTotal() + " kr.";
		}
		
		public void stockCrasch(){
			for (Thing t : allThings){
				
			if (t instanceof Stock){
			t.changeValue(0);
				}
			}
			
		}
}

