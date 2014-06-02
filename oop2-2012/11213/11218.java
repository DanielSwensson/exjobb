import java.util.ArrayList;

public class Person {
	
	String name;
	
	ArrayList <Belongings> personalBelong  = new ArrayList<Belongings>();
	
	Person(String newName) {
		name = newName;
	}
	
	public void marketCrash(){
		for (Belongings i : personalBelong) {
			if (i instanceof Shares) {
				((Shares) i).setValue(0);
				((Shares) i).setPrice(0);
			}
		}
	}
	
	public void addDevice(String name, int value, int wear) {
		personalBelong.add(new Device(name, value, wear));
	}
	
	public void addShares(String name, int amount, int price) {
		personalBelong.add(new Shares(name, amount, price));
	}
	
	public void addJewel(int number, boolean isGold, String name) {
		personalBelong.add(new Jewel(number, isGold, name));
	}
	
	public int getTotalValue() {
		int totalValue = 0;
		for (Belongings i : personalBelong)
			totalValue +=  i.getValue();
		return totalValue;
	}
	
	public void printTotalValue() {
		String str =("\n" + this.name + "\t" + "Totalt värde: " + this.getTotalValue());
		Gui.textArea.append(str + "\n");
		for (Belongings i: personalBelong)
			Gui.textArea.append( i.toString()+ "\n");
	}

	public String toString() {
		return name;	
	}
	
	public String getName() {
		return name;	
	}
}
