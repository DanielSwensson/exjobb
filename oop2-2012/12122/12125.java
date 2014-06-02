import java.io.*;
import java.util.ArrayList;

public class Inlupp2 {
/*
 * This class will contain all helper methods - as well as Main-method with program main menu
 */
	public static ArrayList<Person> personList = new ArrayList<Person>(); // Create the persons list
	public static ArrayList<Item> itemList = new ArrayList<Item>(); // Create the items list

	
	public static void main(String args[]) {
		try{
			FileInputStream itemFile = new FileInputStream("Items.obj");
			ObjectInputStream itemIn = new ObjectInputStream(itemFile);
			itemList = (ArrayList<Item>)itemIn.readObject();
		} catch (FileNotFoundException e) {
			Graphics.message("The items registry file was not found - starting with empty items registry");
		} catch (IOException e) {
			Graphics.message("Unknown error (1) when reading items registry file");
		} catch (ClassNotFoundException e) {
			Graphics.message("Unknown error (2) when reading items registry file");
		}
		
		for(int x=0; x < itemList.size(); x++) {
			Object owner = itemList.get(x).getOwner();
			String ownerName = ((Person) owner).getName();
			if (!Person.personExists(ownerName)) {
				personList.add((Person) itemList.get(x).getOwner());
			}
		}
		Graphics programUI = new Graphics();
	}
	
	
}
