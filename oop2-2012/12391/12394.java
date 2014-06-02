import java.util.Scanner;
import java.util.ArrayList;

public class MainInlupp2 
{
	private static ArrayList <Person> personList = new ArrayList<Person>();
	static Scanner keyboard = new Scanner(System.in);

	//Kontrollerar att det användaren skriver in är en int när vi ber om det, och ger annars ett felmeddelande
	public static int readInt(String question)
	{
		for(;;)
		{
			try
			{
				System.out.print(question);
				int writtenInt = Integer.parseInt(keyboard.nextLine());
				return writtenInt;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Sir, there is no such command, please write a numeric value." + "\n");
			}
		}
	}

	//Kontrollerar att det användaren skriver in är en String när vi ber om det
	public static String readString(String question)
	{
		System.out.print(question);
		String writtenString = keyboard.nextLine();
		return writtenString;
	}

	public static void main (String [] args)
	{
		System.out.println("\n" + "Hello, and welcome to our Register. May I take your coat?" + "\n");
		while (true)//För att alltid komma tillbaka till menyn när man går ur ett case
		{
			menu();

			String command = keyboard.nextLine();

			switch (command)
			{
			case "1":
				addPerson();
				break;

			case "2":
				addItem();
				break;

			case "3":
				showAll();
				break;

			case "4":
				showRichest();
				break;

			case "5":
				listOnePerson();
				break;

			case "6":
				stockCrash();
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
		System.out.println("_________________________________");
		System.out.println("1. Create person");
		System.out.println("2. Create possession");
		System.out.println("3. Show everyone");
		System.out.println("4. Show the richest person");
		System.out.println("5. Show specific person");
		System.out.println("6. Stockmarket crash");
		System.out.println("7. Exit");
		System.out.println("_________________________________" + "\n");
	}

	//Skapar en person
	public static void addPerson()
	{
		String namePerson = readString("Register a person by writing his/her name:" + "\n");
		Person currentPerson = getPerson(namePerson);
		if(currentPerson != null)
		{
			System.out.println("There is already a person with that name." + "\n");
		}
		else
		{
			Person newPerson = new Person(namePerson);
			personList.add(newPerson);
			System.out.println(namePerson + " has been registerd." + "\n");
		}
	}

	//Går igenom personlistans namn och jämför med det namn som användaren angav
	public static Person getPerson(String namePerson)
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

	//Går igenom personlistan och returnerar en persons plats
	public static int getPersonPlace (String namePerson)
	{
		for (int i = 0; i < personList.size(); i++)
		{
			if (namePerson.equalsIgnoreCase(personList.get(i).getNamePerson()))
			{
				return i;
			}
		}
		return 0;
	}

	//Lägger till en pryl
	public static void addItem()
	{
		int command = readInt("What kind of item do you wish to add?" + "\n"
				+ "1. Jewlery" + "\n" + "2. Stock" + "\n" + "3. Apparatus" + "\n");
		switch(command)
		{
		case 1:
			createJewlery();
			break;

		case 2:
			createStock();
			break;

		case 3:
			createApparatus();	
			break;

		default:
			System.out.println("There is no such command.");
		}
	}

	//Skapar ett smycke
	public static void createJewlery()
	{
		String namePerson = readString("Who is the owner of the jewlery?" + "\n");
		Person currentPerson = getPerson(namePerson);
		if (currentPerson != null)
		{
			String nameItem = readString("What kind of jewlery is it?" + "\n");
			String material = readString ("Is it made of gold?" + "\n");
			int numberOfGems = readInt("How many gems does it contain?" + "\n");
			personList.get(getPersonPlace(namePerson)).addItem(new Jewlery(nameItem, material, numberOfGems));
			System.out.println("Your jewlery has been registerd." + "\n");
		}	
		else
		{
			System.out.println("There is no such person. And there never was. Ever." + "\n");
		}
	}

	//Skapar ett aktie
	public static void createStock()
	{
		String namePerson = readString("Who is the owner of the stocks?" + "\n");
		Person currentPerson = getPerson(namePerson);
		if (currentPerson != null)
		{
			String nameItem = readString("What is the name of the stock?" + "\n");
			int numberOfStocks = readInt ("How many stocks are we talking about here? The amount where I ask you to marry me?" +
					" Oh, that was highly unproffesional. I should appolgise. I really should." + "\n");
			int valueStock = readInt("How much is it worth?" + "\n");
			personList.get(getPersonPlace(namePerson)).addItem(new Stock(nameItem, numberOfStocks, valueStock));
			System.out.println("Your stock has been registerd." + "\n");
		}	
		else
		{
			System.out.println("There is no such person. And there never was. Ever." + "\n");
		}
	}

	//Skapar ett apparat
	public static void createApparatus()
	{
		String namePerson = readString("Who is the owner of the apparatus?" + "\n");
		Person currentPerson = getPerson(namePerson);
		if (currentPerson != null)
		{
			String nameItem = readString("What kind of apparatus is it?" + "\n");
			int purchasePrice = readInt ("How much did it cost?" + "\n");
			int levelMintCondition = readInt("On a scale of 1-10, where 1 broken and 10 is mint condition, wherein lies your apparatus?" + "\n");
			personList.get(getPersonPlace(namePerson)).addItem(new Apparatus(nameItem, purchasePrice, levelMintCondition));
			System.out.println("Your apparatus has been registerd." + "\n");
		}	
		else
		{
			System.out.println("There is no such person. And there never was. Ever." + "\n");
		}
	}

	//Listar alla personer och det totala värdet av respektives ägodelar
	public static void showAll()
	{
		System.out.println("Registerd people, and the total value of their items:");
		for(int i=0; i < personList.size(); i++)
		{
			System.out.println(personList.get(i));
		}
	}

	//Listar en person och dennes ägodelar och dessas värde
	public static void listOnePerson()
	{
		String wantedPerson = readString("Write the name of the person you want all the dirty details on:" + "\n");
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
			System.out.println("There is no such person. Why you no want dirty details?!" + "\n");
		}
	}

	//Visar den rikaste personen och dennes totala värde, listar även samtliga av dennes ägodelar och dessas värde
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
			System.out.println("The person you should blackmail is " + richestPerson.getNamePerson() + " who owns " + richestPerson.getTotalValue() + " solid American dollars.");
			System.out.println(richestPerson.getItemNameAndValue());
		}
	}

	//Börskrasch, går här igenom alla personer i listan, och kallar på en funktion som går igenom var och en av dessa personers ägodelar och nollställer aktievärdet
	public static void stockCrash()
	{
		for (int i = 0; i < personList.size(); i++)
		{
			personList.get(i).getPersonValueStock();
		}
		System.out.println("Every person's current stocks has been invalid." + "\n");
	}
}






























