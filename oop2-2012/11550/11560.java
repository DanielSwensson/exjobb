import java.util.ArrayList;
import java.util.Scanner;

public class RegTest {
	
	static ArrayList<Person> all = new ArrayList<Person>();
	Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args)	{
	
	RegTest rt = new RegTest();
	System.out.println("Hej och välkommen till Prylprogrammet");
	for ( ; ; ) {
		int menu = rt.readInt("Ange kommando 1-7: ");
		switch (menu) {
		case 1: 
			rt.createPerson();
			break;
		case 2:
			rt.listAll();
			break;
		default: 
			System.out.println("Fel kommando!");
		}
	}

	}
	
	void addGadget() {
		
	}
	
	// Lists all persons
	void listAll() {
		for (Person p : RegTest.all) {
			System.out.println(p.getName());
		}
	}
	
	// Checks if a person with the same name already exists in the system
	boolean personExist(String name) {
		for (Person p : RegTest.all) {
			if (p.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	// Create a new Person object
	void createPerson() {
		String name = readString("Nya personens namn: ");
		if (personExist(name)) {
			System.out.println("Det finns tyvärr redan en person med namnet " + name);
		} else {
		Person p = new Person(name);
		all.add(p);
		}
	}
	
	
	// Ask user for an integer and check if true
	int readInt(String question)	{
		for ( ; ; ) {
			try	{
				System.out.print(question);
				int x=Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e)	{
				System.out.println("Fel - skall vara numeriskt värde");
			}
		}
	}
	
	// Ask user for a string
	String readString(String question)	{
		System.out.println(question);
		String str=keyboard.nextLine();
		return str;
	}

}
