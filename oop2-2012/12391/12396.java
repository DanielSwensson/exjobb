import java.util.Scanner;
import java.util.ArrayList;

public class Register 
{
	private static ArrayList <Person> personList = new ArrayList<Person>();
	static Scanner keyboard = new Scanner(System.in);

	//Kontrollerar att det anv�ndaren skriver in �r en int n�r vi ber om det, och ger annars ett felmeddelande
	int readInt(String question)
	{
		for(;;)
		{
			try
			{
				System.out.print(question);
				int keyboardInt = Integer.parseInt(keyboard.nextLine());
				return keyboardInt;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error - please write a numeric value.");
			}
		}
	}

	//Kontrollerar att det anv�ndaren skriver in �r en String n�r vi ber om det
	String readString(String question)
	{
		System.out.print(question);
		String keyboardString = keyboard.nextLine();
		return keyboardString;
	}



	public void main (String [] args)
	{
		while (true)//F�r att alltid komma tillbaka till menyn n�r man g�r ur ett case
		{
			menu();

			String command = keyboard.nextLine();

			switch (command)
			{
			case "1":
				addPerson();//tror den fungerar utm�rkt
				break;

			case "2":
				addItem();//tror den fungerar utm�rkt >:3 men den �r J�VLIGT r�rig >:(
				break;

			case "3":
				showAll();//fungerar bra tror jag
				break;

			case "4":
				showRichest();//tror denna fungerar perfekt
				break;

			case "5":
				listOnePerson();//fungerar nog helt fucking perfekt >:D
				break;

			case "6":
				stockCrash();//funkar!!!!!!!
				break;

			case "7":
				System.out.println("Farewell.");
				System.exit(0);
				break;

			default:
				System.out.println("There is no such command. Please make it right. Just once. Just. Frikkin. Once.");

			}
		}
	}

	//Skriver ut menyn
	public static void menu()
	{
		System.out.println("1. Create person");
		System.out.println("2. Create possession");
		System.out.println("3. Show everyone");
		System.out.println("4. Show the richest person");
		System.out.println("5. Show specific person");
		System.out.println("6. Stockmarket crash");
		System.out.println("7. Exit");
	}

	//Skapar en person
	public void addPerson()
	{
		String namePerson = readString("Register a person by writing his/her name:");
		Person currentPerson = getPerson(namePerson);
		if(currentPerson != null)
		{
			System.out.println("There is already a person with that name.");
		}
		else
		{
			Person newPerson = new Person(namePerson);
			personList.add(newPerson);
			System.out.println(namePerson + " has been registerd.");
		}
	}

	//G�r igenom personlistans namn och j�mf�r med det namn som anv�ndaren angav ovan
	Person getPerson(String namePerson)
	{
		for(Person currentPerson : personList)
		{
			if(currentPerson.getNamePerson().equalsIgnoreCase(namePerson))
			{
				return currentPerson;
			}
		}
		return null;
	}

	/*
	public void addPerson()
	{
		System.out.println("Register a person by writing his/her name:");
		String namePersonTemp = keyboard.nextLine(); //Registerar det �nskade namnet.

		if (namePersonTemp.equalsIgnoreCase(searchPersonName(namePersonTemp))) //Om namnet �r upptaget 
		{
			System.out.println("There is already a person with that name.");
		}
		else //Om namnet inte �r upptaget skapar
		{
			personList.add (new Person(namePersonTemp));
			System.out.println(namePersonTemp + " has been registerd.");
		}
	}
	 */

	public static void addItem() //m�ste l�gga in loop s� kommandofr�gan kommer igen, men �ven att den slutar n�r ett item �r inlagt
	{
		System.out.println("What kind of item do you wish to add?" + "\n"
				+ "1. Jewlery" + "\n" + "2. Stock" + "\n" + "3. Apparatus");
		String command = keyboard.nextLine();

		switch(command)
		{
		case "1":
			System.out.println("Who is the owner of the item?");
			String namnedPerson = keyboard.nextLine();
			createJewlery(namnedPerson);	
			break;

		case "2":
			System.out.println("Who is the owner of the item?");
			String namnedPersonStock = keyboard.nextLine();
			createStock(namnedPersonStock);
			break;

		case "3":
			System.out.println("Who is the owner of the item?");
			String namnedPersonApparatus = keyboard.nextLine();
			createApparatus(namnedPersonApparatus);	
			break;

		default:
			System.out.println("There is no such command.");
		}
	}

	public static void createJewlery (String namnedPerson)
	{
		if (namnedPerson.equalsIgnoreCase(searchPersonName(namnedPerson)))
		{
			System.out.println("What kind of jewlery is it?");
			String nameItem = keyboard.nextLine();

			System.out.println("Is it made of gold or silver?");
			String material = keyboard.nextLine();

			System.out.println("How many gems does it contain?");
			int numberOfGems = keyboard.nextInt();
			keyboard.nextLine();

			personList.get(searchPersonPlace(namnedPerson)).addItem(new Jewlery(nameItem, material, numberOfGems));
			System.out.println("Your jewlery has been registerd.");
		}	
		else
		{
			System.out.println("Person not found.");
		}
	}

	public static void createStock (String namnedPersonStock)
	{
		if (namnedPersonStock.equalsIgnoreCase(searchPersonNameStock(namnedPersonStock)))
		{
			System.out.println("What is the name of the Stock?");
			String nameItem = keyboard.nextLine();

			System.out.println("How many stocks have you bought?");
			int numberOfStocks = keyboard.nextInt();

			System.out.println("How much is it worth?");
			int valueStock = keyboard.nextInt();
			keyboard.nextLine();

			personList.get(searchPersonPlace(namnedPersonStock)).addItem(new Stock(nameItem, numberOfStocks, valueStock));
			System.out.println("Your stock has been registerd.");
		}	
		else
		{
			System.out.println("Person not found.");
		}
	}

	public static void createApparatus (String namnedPersonApparatus)
	{
		if (namnedPersonApparatus.equalsIgnoreCase(searchPersonNameApparatus(namnedPersonApparatus)))
		{
			System.out.println("What kind of apparatus is it?");
			String nameItem = keyboard.nextLine();

			System.out.println("How much did it cost?");
			int purchasePrice = keyboard.nextInt();

			System.out.println("On a scale of 1-10, where 1 broken and 10 is mint condition, wherein lies your apparatus?");
			int levelMintCondition = keyboard.nextInt();
			keyboard.nextLine();

			personList.get(searchPersonPlace(namnedPersonApparatus)).addItem(new Apparatus(nameItem, purchasePrice, levelMintCondition));
			System.out.println("Your apparatus has been registerd.");
		}	
		else
		{
			System.out.println("Person not found.");
		}
	}

	public static int searchPersonPlace (String namnedPerson)
	{
		for (int i = 0; i < personList.size(); i++)
		{
			if (namnedPerson.equalsIgnoreCase(personList.get(i).getNamePerson()))
			{
				return i;
			}
		}
		return 0;
	}

	public static String searchPersonName (String namnedPerson)
	{
		for (int i = 0; i < personList.size(); i++)
		{
			if (namnedPerson.equalsIgnoreCase(personList.get(i).getNamePerson()))
			{
				return namnedPerson;
			}
		}
		return "Person not found.";
	}

	public static String searchPersonNameStock (String namnedPersonStock)
	{
		for (int i = 0; i < personList.size(); i++)
		{
			if (namnedPersonStock.equalsIgnoreCase(personList.get(i).getNamePerson()))
			{
				return namnedPersonStock;
			}
		}
		return "Person not found.";
	}

	public static String searchPersonNameApparatus (String namnedPersonApparatus)
	{
		for (int i = 0; i < personList.size(); i++)
		{
			if (namnedPersonApparatus.equalsIgnoreCase(personList.get(i).getNamePerson()))
			{
				return namnedPersonApparatus;
			}
		}
		return "Person not found.";
	}

	public static void showAll()
	{
		System.out.println("Registerd people, and the total value of their items:");
		for(int i=0; i < personList.size(); i++)
		{
			System.out.println(personList.get(i));
		}
	}

	public static void listOnePerson()
	{
		//Ska skriva ut enskild person inklusive �godelar som ovan med namn p� dessa och individuellt v�rde bredvid, finns ej namn ges felmeddelande
		System.out.println("Write the name of the person you want all the dirty details on:");
		String wantedPerson = keyboard.nextLine();
		boolean found = false;

		for(int i=0; i < personList.size(); i++)
		{
			if (wantedPerson.equalsIgnoreCase(personList.get(i).getNamePerson()))
			{
				found = true;
				System.out.println(personList.get(i).getNamePerson() + "\n" + personList.get(i).getItemNameAndValue());
				break;
			}
		}
		if(found == false)
		{
			System.out.println("There is no such person. Why you no want dirty details?!");
		}
	}

	public static void showRichest()
	{
		Person richestPerson = null;
		for (Person currentPerson : personList)
		{
			if(richestPerson == null || richestPerson.getTotalValue() <currentPerson.getTotalValue())
			{
				richestPerson = currentPerson;
			}
		}

		if(personList == null)
		{
			System.out.println("There is no person registerd.");
		}
		else
		{
			System.out.println("The richest person is " + richestPerson.getNamePerson() + " who owns " + richestPerson.getTotalValue() + " solid American dollars.");
			System.out.println(richestPerson.getItemNameAndValue());
		}
	}

	//i stockCrash vill jag g� igenom varje person. jag har en funktion i perosn, getPersonValueStock, som g�r igenom en persons lista och nollst�ller alla stocks
	//h�r vill jag g� igenom varje person, och kalla p� den getPersonValueStock funktion f�r varje perosn.
	public static void stockCrash()
	{
		//g� igenom alla personer och kalla p� getPErsonValueStock f�r varje perosn
		for (int i = 0; i < personList.size(); i++)//letar igenom listan �ver personer
		{
			personList.get(i).getPersonValueStock();
			//personList.get(i).getClass().getSimpleName() =="Stock");//
			//if(personList.get(i).get(getPersonValueStock())!=0)
			//{
			//	hasStock = true;
			//getPersonValueStock() = 0;//h�r ska den s�tta de stocks personen har till noll.
			//}
		}
		//if (personList.itemList.getPersonValueStock() == 0)//om ingen har n�gra stocks
		//{
		//System.out.println("No one has any stocks.");
		//}
		//else //i alla andra fall skrivs detta ut
		//{
		System.out.println("Every persons current stocks has been invalid.");
		//}
	}
}






























