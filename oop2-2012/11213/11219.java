import java.util.ArrayList;
import javax.swing.*;

public class Register {
		
	public static ArrayList <Person> allPersons = new ArrayList <Person>();

	private static boolean isGold;
	private static Person thePerson = null;		
		
	public static void main(String[] args) {

		new Gui();
	}	
	
	private static boolean doesPersonExist(String name) {
		boolean exist = false;
		for (Person i : allPersons)
			if (i.getName().equalsIgnoreCase(name)){
				exist = true;
				break;
			}
		return exist;
	}

	private static void whatPerson(String personName) {
		for (Person i : allPersons) {
			if (i.getName().equalsIgnoreCase(personName))
				thePerson = i;
		}
	}
	
	private static String inputString(String text){
		String stri = null;
		do{
			try{
				stri=JOptionPane.showInputDialog(text);
			}
			catch (java.lang.NullPointerException e){
			}
		} while (stri == null || stri.equalsIgnoreCase(""));
		return stri;
	}

 	private static boolean isItGold() {
		int gold = 0;
		do{
			gold = JOptionPane.showConfirmDialog(null, "ÄR SMYCKET GJORT AV GULD?", "ÄR SMYCKET GJORT AV GULD", JOptionPane.YES_NO_OPTION);
		} while (gold < 0 || gold > 1);
			
		if (gold  == 0) 
			isGold = true;
		else
			isGold = false;
		return isGold;
	}
	
	private static int inputInt(String text) {
		int value = 0;
		boolean somethingWrong = false;

		do{
			try{
				somethingWrong = false;
				String str = JOptionPane.showInputDialog(null, text);
				value = Integer.parseInt(str);
			}
			catch (java.lang.NullPointerException e) {
				somethingWrong = true;
			} 
			catch (java.lang.NumberFormatException e) {
				somethingWrong = true;
			}
		} while (somethingWrong);

		return value;
	}

	private static int inputIntBetween(int min, int max, String text) {
		int value = 0;

		do{
			value = inputInt(text);
		} while(value < min || value > max);

		return value;
	}

	public static void addPerson() {
		String per;
		per = inputString("Ange namn på personen som du vill lägga till!");
		
		if (doesPersonExist(per)){
			Gui.textArea.append("\n" + "PERSON MED SAMMA NAMN exist REDAN!");	
		}	
		else {	
			allPersons.add(new Person (per));
		}
	}
	
	public static void writeAppend(String str) {
		Gui.textArea.append(" " + str);
	}
	
	public static void writeNew(String str) {
		Gui.textArea.setText("");
		Gui.textArea.append(str);
	}
	
	public static void showSpecifikPerson() {
		String who = null;
		
		do{
			who = inputString("Ange namn på personen som du vill visa: ");
			doesPersonExist(who);
		} while (!doesPersonExist(who));
		
		whatPerson(who);
		thePerson.printTotalValue();
	}
	
	public static void newThing() {
		String who1 = null, choice = null;
		
		do{
			who1 = inputString("Ange namn på personen som du vill ska äga prylen: ");
			doesPersonExist(who1);
		} while (!doesPersonExist(who1));
		
		whatPerson(who1);
		
		do{
			try{
				String[] selections = { "SMYCKE", "AKTIE", "APPARAT" };
				choice = (String) JOptionPane.showInputDialog(null, "Välj vilken typ av pryl i listan",
	            "Välj typ!", JOptionPane.INFORMATION_MESSAGE, null,
	            selections, selections[0]);
			}
			catch(java.lang.NullPointerException e){
    		
    		}
        } while(choice == null);
		
		switch(choice) {			
			case "SMYCKE":
				thePerson.addJewel(inputInt("Ange antal ädelstenar: "), isItGold(), inputString("Ange namn på SMYCKET: "));
				break;
				
			case "AKTIE":
				thePerson.addShares(inputString("Ange namn på aktien: "), inputInt("Ange antal: "), inputInt("Ange pris: "));
				break;
				
			case "APPARAT":
				thePerson.addDevice(inputString("Ange namn på apparaten: "), inputInt("Ange inköpspriset: "), inputIntBetween(0, 10, "Ange slitage: "));
				break;	
		}

	}

	public static void stockMarketCrash() {
		for (Person i : allPersons){
			i.marketCrash();
		}
	}
	
	public static void showRichestPerson() {
		if (allPersons.size() != 0) {
			thePerson = allPersons.get(0);
			ArrayList<Person> richestPersons = new ArrayList<Person>();

			for (Person i : allPersons) {
				if (!richestPersons.isEmpty()) {
					if (i.getTotalValue() > richestPersons.get(0).getTotalValue()) {
						richestPersons.clear();
						richestPersons.add(i);
					} 
					else if (i.getTotalValue() == richestPersons.get(0).getTotalValue()) {
						richestPersons.add(i);
					}
				} 
				else {
					richestPersons.add(i);
				}
			}

			if (richestPersons.size() == 1)
				writeNew("Den rikaste personen är: " + "\n");
			else
				writeNew("Dom rikaste personenerna är :" + "\n");

			for (Person p : richestPersons) {
				p.printTotalValue();
			}
		}
	}
}