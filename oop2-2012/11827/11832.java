import java.util.ArrayList;
import java.util.Scanner;

public class Register 
{
	private Scanner keyboard = new Scanner(System.in);
	private ArrayList<Person> allPersons = new ArrayList<Person>();
	
	public Register()
	{
		for(;;)
		{
			switch(checkData("1. Add Person\n" +
					 		 "2. Add property\n" +
					 		 "3. Show all\n" +
					 		 "4. Show richest\n" +
					 		 "5. Show a person\n" +
					 		 "6. Cause stock market to crash\n" +
					 		 "7. Exit\n" +
				  	  		 "Enter command: "))
			{
				case 1:
					addPerson();
					break;
				case 2:
					addProperty();
					break;
				case 3:
					listPersons();
					break;
				case 4:
					showRichest();
					break;
				case 5:
					showPerson();
					break;
				case 6:
					stockMarketCrash();
					break;
				case 7:
					System.exit(0);
			}
		}
	}
	
	public int checkData(String text)
	{
		boolean ok = false;
		int choice = 0;
		do
		{
			ok = true;
			try
			{
				System.out.print(text);
				
				String str = keyboard.next();
				choice = Integer.parseInt(str);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Your choice must be a number!");
				ok = false;
			}
		}while (!ok);
		return choice;
	}
	
	public void addPerson()
	{
		String personName = askForString("Enter person's name: ");
		Person newPerson = findPerson(personName);
		if(newPerson == null)
		{
			newPerson = new Person(personName);
			allPersons.add(newPerson);
			System.out.println(newPerson.getName() + " registred!");
		}
		else
		{
			System.out.println(personName + " is already registred.");
		}
	}
	
	public String askForString(String string)
	{
		System.out.print(string);
		return keyboard.next();
	}

	public Person findPerson(String personName)
	{
		for(Person personToFind : allPersons)
		{
			if(personToFind.getName().equalsIgnoreCase(personName))
			{
				return personToFind;
			}
		}
		return null;
	}
	
	public void addProperty()
	{
		String personName = askForString("Enter person's name: ");
		
		Person personFound = findPerson(personName);
		
		if( personFound!= null)
		{
			createProperty(personFound);
		}
		else
		{
			personNotFound(personName);
		}
	}
	
	public void createProperty(Person propertyPerson)
	{
		int properties = 3;
		int data = 0;
		boolean b = false;
		
		while(!b)
		{
			data = checkData("1. Create jewellery\n2. Create stock\n3. Create device\nEnter command: ");
			if(data <= 0 || data > properties)
			{
				System.out.println("The number must be between 1 and " + properties);
			}
			else
			{
				b = true;
			}
		}
		
		switch(data)
		{
			case 1:
				createJewellery(propertyPerson);
				break;
			case 2:
				createStock(propertyPerson);
				break;
			case 3:
				createDevice(propertyPerson);
				break;
		}
	}
	
	public void createJewellery(Person propertyPerson)
	{
		String name = askForString("Enter the name of the jewellery: ");
		boolean b = false;
		boolean gold = false;
		int gems = 0;
		
		while(!b)
		{
			switch(checkData("Is it made of gold or silver?\n1. Gold\n2. Silver\nEnter command: "))
			{
				case 1:
					gold = true;
					b = true;
					break;
				case 2:
					gold = false;
					b = true;
					break;
				default:
					System.out.println("You must choose either gold or silver!");
			}
		}
		
		gems = checkData("Enter the amount of gemstones on the jewellery: ");
		Jewellery newJewellery = new Jewellery(name, gold, gems);
		propertyPerson.addProperty(newJewellery);
		System.out.println("Jewellery registred!");
		
	}
	
	public void createStock(Person propertyPerson)
	{
		String name = askForString("Enter the name of the stock: ");
		int price = checkData("Enter the price of the stock: ");
		int number = checkData("Enter the number of stocks: ");

		Stock newStock = new Stock(name, price, number);
		propertyPerson.addProperty(newStock);
		System.out.println("Stock registred!");
	}
	
	public void createDevice(Person propertyPerson)
	{
		String name = askForString("Enter the name of the device: ");
		double price = checkData("Enter the price of the device: ");
		boolean b = false;
		double wear = 0;
		
		while(!b)
		{
			wear = checkData("Enter the condition of the device(1-10): ");
			if(wear < 1 || wear > 10)
			{
				System.out.println("The condition has to be between 1 and 10");
			}
			else
			{
				b = true;
			}
		}

		Device newDevice = new Device(name, price, wear);
		propertyPerson.addProperty(newDevice);
		System.out.println("Device registred!");
	}
	
	public void listPersons()
	{
		for(Person personToList : allPersons)
		{
			System.out.println(personToList);
		}
	}
	
	public void showRichest()
	{
		if(!allPersons.isEmpty())
		{
			Person richestPerson = allPersons.get(0);
			for(Person richPerson : allPersons)
			{
				if(richPerson.calculateValue() > richestPerson.calculateValue())
				{
					richestPerson = richPerson;
				}
			}
			System.out.println("The richest person is " + richestPerson.getName() + " who owns a total of " + richestPerson.calculateValue());
			richestPerson.showTotal();
		}
		else
		{
			System.out.println("Register empty!");
		}
	}
	
	public void personNotFound(String personName)
	{
		System.out.println("Couldn't find a person named " + personName);
	}
	
	public void showPerson()
	{
		String personName = askForString("Enter person's name: ");
		
		Person personFound = findPerson(personName);
		
		if(personFound != null)
		{
			System.out.println(personFound.getName() + " owns a total of " + personFound.calculateValue());
			personFound.showTotal();
		}
		else
		{
			personNotFound(personName);
		}
	}
	
	public void stockMarketCrash()
	{
		for(Person stockPerson : allPersons)
		{
			for(Property stockProperty : stockPerson.getAllProperty())
			{
				if(stockProperty instanceof Stock)
				{
					((Stock) stockProperty).setPrice(0);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		Register reg = new Register();
	}
}
