import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Application
{
	private Scanner keyboard = new Scanner(System.in);
	private ArrayList<Person> people;
	
	private void tryCatchInputPeople()
	{
		try
		{
			FileInputStream fileIn = new FileInputStream("people.obj");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			people = (ArrayList<Person>)objectIn.readObject();
			objectIn.close();
		}
		catch (FileNotFoundException e)
		{
			people = new ArrayList<Person>();
		}
		catch (IOException e)
		{
			people = new ArrayList<Person>();
		}
		catch (ClassNotFoundException e)
		{
			people = new ArrayList<Person>();
		}	
	}
	
	private void addPerson()
	{
		boolean b = true;
		String name;
		do
		{
			b = true;
			System.out.println("\nAnge namnet på personen du vill skapa: ");
			name = keyboard.next();
			keyboard.nextLine();
			for (Person a : people)
			{
				if (name.equalsIgnoreCase(a.getName()))
				{
					System.out.println("Personen " + a.getName() + " finns redan. Var god försök igen.");
					b = false;
				}					
			}
		}
		while(!b);
		people.add(new Person(name));
	}
	
	private void deleteSpecificPryl()
	{
		System.out.println("Vilken person vill du ta bort prylen för?\n\nTillgängliga personer: \n");
		for (Person c : people)
		{
			System.out.println(c);
		}
		Person chosenPerson = null;
		boolean b;
		do 
		{
			b = true;
			String person = keyboard.next();
			keyboard.nextLine();
			for (Person c : people)
			{
				if (c.getName().equalsIgnoreCase(person))
				{
					chosenPerson = c;
					break;
				}	
			}
			if (chosenPerson == null)	
			{
				System.out.println("Felaktigt namn, försök igen!");
				b = false;
			}
		}
		while(!b);
		Pryl prylChoice = null;
		do
		{
		System.out.println("Vilken pryl hos " + chosenPerson.getName() + " vill du ta bort?\n\nTillgängliga prylar:\n");
		for (Pryl a : chosenPerson.getBelongings())
		{
			System.out.println(a);
		}
		String pryl = keyboard.next();
		keyboard.nextLine();
		for (Pryl c : chosenPerson.getBelongings())
		{
			if (c.getName().equalsIgnoreCase(pryl))
			{
				prylChoice = c;
				break;
			}
		}
		if (prylChoice == null)
			System.out.println("\nEn sådan pryl finns inte. Var god försök igen.\n");
		}
		while(prylChoice == null);
		chosenPerson.deletePryl(prylChoice);
	}
	
	private void createSmycke(Person chosenPerson)
	{
		System.out.println("Vad för typ av smycke vill du registrera? ");
		String smyckeName = keyboard.next();
		keyboard.nextLine();
		String smyckeGuld;
		do
		{
			System.out.println("Är smycket av guld eller silver?" );
			smyckeGuld = keyboard.next();
			keyboard.nextLine();
		}
		while(!smyckeGuld.equalsIgnoreCase("guld") && !smyckeGuld.equalsIgnoreCase("silver"));
		System.out.println("Hur många ädelstenar har smycket? ");
		int smyckeGems = 0;
		boolean f;
		do
		{
			f = true;
			try
			{
				smyckeGems = keyboard.nextInt();
				keyboard.nextLine();
			}
			catch (InputMismatchException g)
			{
				System.out.println("Felaktigt inmatning, var god försök igen! Hur många ädelstenar har smycket? " );
				keyboard.nextLine();
				f = false;
			}
		}
		while(!f);
		chosenPerson.addToBelongings(new Smycke(smyckeName, smyckeGuld, smyckeGems));
	}
	
	private void createApparat(Person chosenPerson)
	{
		System.out.println("Vad för typ av apparat vill du registrera? ");
		String apparatName = keyboard.next();
		keyboard.nextLine();
		System.out.println("Vad var inköpspriset för apparaten? ");
		int purchasePrice = 0;
		boolean h;
		do
		{
			h = true;
			try
			{
				purchasePrice = keyboard.nextInt();
				keyboard.nextLine();
			}
			catch (InputMismatchException g)
			{
				System.out.println("Felaktigt inmatning, var god försök igen! Vad var inköpspriset för apparaten? " );
				keyboard.nextLine();
				h = false;
			}
		}
		while(!h);
		System.out.println("På en skala mellan 1 och 10, vilket skick är det på apparaten? " );
		int condition = 0;
		boolean i;
		do
		{
			i = true;
			try
			{
				do
				{
				condition = keyboard.nextInt();
				keyboard.nextLine();
				if (condition < 1 || condition > 10)
					System.out.println("Felaktigt skick, var god välj ett skick mellan 1-10 för apparaten. ");
				}
				while(condition < 1 || condition > 10);				
			}
			catch (InputMismatchException g)
			{
				System.out.println("Felaktigt inmatning, var god försök igen! På en skala mellan 1 och 10, vilket skick är det på apparaten? " );
				keyboard.nextLine();
				i = false;
			}
		}
		while(!i);
		chosenPerson.addToBelongings(new Apparat(apparatName, purchasePrice, condition));
	}
	
	private void createAktie(Person chosenPerson)
	{
		System.out.println("Vad heter aktien du vill registrera? ");
		String aktieName = keyboard.next();
		keyboard.nextLine();
		System.out.println("Hur många " + aktieName + "-aktier vill du registrera?" );
		int amount = 0;
		boolean c;
		do
		{
			c = true;
			try
			{
				amount = keyboard.nextInt();
				keyboard.nextLine();
			}
			catch (InputMismatchException d)
			{
				System.out.println("Felaktigt inmatning, var god försök igen! Hur många aktier vill du registrera? " );
				keyboard.nextLine();
				c = false;
			}
		}
		while(!c);
		System.out.println("Vad är priset per " + aktieName + "-aktie?");
		int price = 0;
		boolean d;
		do
		{
			d = true;
			try
			{
				price = keyboard.nextInt();
				keyboard.nextLine();
			}
			catch (InputMismatchException e)
			{
				System.out.println("Felaktigt inmatning, var god försök igen! Hur många aktier vill du registrera? " );
				keyboard.nextLine();
				d = false;
			}
		}
		while(!d);
		chosenPerson.addToBelongings(new Aktie(aktieName, amount, price));
	}
	
	private void createStuff()
	{
		if (!people.isEmpty())
		{
		System.out.println("Vilken person ska äga prylen?\n\nTillgängliga personer: \n");
		for (Person c : people)
		{
			System.out.println(c.getName());
		}
		Person chosenPerson = null;
		boolean b;
		do 
		{
			b = true;
			String person = keyboard.nextLine();
			for (Person c : people)
			{
				if (c.getName().equalsIgnoreCase(person))
				{
					chosenPerson = c;
					break;
				}	
			}
			if (chosenPerson == null)	
			{
				System.out.println("Felaktigt namn, försök igen!");
				b = false;
			}
		}
		while(!b);
		String stuff;
		do
		{
			System.out.println("Vilken typ av pryl vill du registrera? Smycke, apparat eller aktie.");
			stuff = keyboard.next().toLowerCase();
			keyboard.nextLine();
			switch(stuff)
			{
			case "smycke":
				createSmycke(chosenPerson);
				break;
			case "apparat":
				createApparat(chosenPerson);
				break;
			case "aktie":
				createAktie(chosenPerson);
				break;
				default:
					System.out.println("\nFelaktig pryl, var god försök igen.\n");
					break;
			}
		}
		while(!stuff.equalsIgnoreCase("smycke") && !stuff.equalsIgnoreCase("apparat") && !stuff.equalsIgnoreCase("aktie"));
		}
		else
		{
			System.out.println("Det finns tyvärr inga personer att tilldela prylar ännu. Var vänlig skapa personer som kan äga prylar först.");
		}
	}
		
	private void listPeople()
	{
		if (!people.isEmpty())
		{	
			for (Person a : people)
			{
				System.out.println(a);
			}
		}
		else
		{
			System.out.println("Det finns inga personer att lista. ");
		}
	}
	
	private void richestPerson()
	{
		int richest = 0;
		Person richestPerson = null;
		for (Person a : people)
		{
			if (a.getWealth() > richest)
			{
				richest = a.getWealth();
				richestPerson = a;
			}
		}
		System.out.println("Den rikaste personen är " + richestPerson.getName() + ", vars totala förmögenhet är " + richestPerson.getWealth() + " kronor.\n\nPrylarna som ägs av " + richestPerson.getName() + " är:\n");
		for (Pryl a : richestPerson.getBelongings())
		{
			System.out.println(a);
		}
	}
	
	private void listPerson()
	{
		if (!people.isEmpty())
		{
		System.out.println("Vilken person vill du lista\n\nTillgängliga personer: \n");
		for (Person c : people)
		{
			System.out.println(c.getName());
		}
		Person chosenPerson = null;
		boolean b = true;
		do 
		{
			b = true;
			String person = keyboard.nextLine();
			for (Person c : people)
			{
				if (c.getName().equalsIgnoreCase(person))
				{
					chosenPerson = c;
					break;
				}	
			}
			if (chosenPerson == null)	
			{
				System.out.println("Felaktigt namn, försök igen!");
				b = false;
			}
		}
		while(!b);
		System.out.println(chosenPerson);
		}
		else
		{
			System.out.println("Det finns inga personer att lista. ");
		}
	}
	
	private void selectMarketCrash()
	{
		for (Person c : people)
		{
			c.prylMarketCrash();
		}
	}
	
	private void deletePerson()
	{
		System.out.println("\nVilken person vill du ta bort?\n\nTillgängliga personer:\n");
		for (Person a : people)
		{
			System.out.println(a);
		}
		String choice;
		Person chosenPerson = null;
		boolean c;
		do
		{
			c = true;
			choice = keyboard.next();
			keyboard.nextLine();
			for (Person b : people)
			{
				if (b.getName().equalsIgnoreCase(choice))
				{
					chosenPerson = b;
					break;
				}
			}
			if (chosenPerson == null)
			{
				System.out.println("Felaktigt person, var vänlig försök igen.");
				c = false;
			}
		}
		while(!c);
		people.remove(chosenPerson);		
	}
	
	private void systemExit()
	{
		System.out.println("Är du säker på att du vill avsluta? ");
		String userCommand = keyboard.next();
		keyboard.nextLine();
		if (userCommand.equalsIgnoreCase("Ja") || userCommand.equalsIgnoreCase("Ja.") || userCommand.equalsIgnoreCase("Ja!"))
		{
			System.out.println("\nVill du spara ditt arbete innan du avslutar? All data kommer gå förlorad om du inte sparar. ");
			String saveDogs = keyboard.next();
			keyboard.nextLine();
			if (saveDogs.equalsIgnoreCase("Ja") || saveDogs.equalsIgnoreCase("Ja.") || saveDogs.equalsIgnoreCase("Ja!"))
			{
				save();
			}
			else
			{
				System.out.println("Hejdå!");
				System.exit(0);
			}
		}
	}
	
	private void save()
	{
		try 
		{
		FileOutputStream fileOut = new FileOutputStream("people.obj");
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		objectOut.writeObject(people);
		objectOut.close();
		}
		catch (IOException e)
		{
			System.out.println("IO-fel. Hejdå!");
			System.exit(1);
		}

		System.out.println("Hejdå!");
		System.exit(0);		
	}
	
	public void runApplication()
	{
		tryCatchInputPeople();
		int switchChoise = 0;
		for (;;)
		{			
			
			boolean a = true;
			do
			{
				a = true;
				try
				{
					System.out.println("\nVad vill du göra?\n\n1 = Skapa person\n2 = Skapa pryl\n3 = Visa alla\n4 = Visa rikaste personen\n5 = Visa viss person\n6 = Börskrasch\n7 = Ta bort pryl\n8 = Ta bort person\n9 = Avsluta");
					switchChoise = keyboard.nextInt();
					keyboard.nextLine();
				}
				catch (InputMismatchException e)
				{
					System.out.println("Felaktigt val! Var vänlig försök igen.\n");
					keyboard.nextLine();
					a = false;
				}
			}
			while (!a);
			
			switch (switchChoise)
			{
			case 1:
				addPerson();
				break;
			case 2:
				createStuff();
				break;
			case 3:
				listPeople();
				break;
			case 4:
				richestPerson();
				break;
			case 5:
				listPerson();
				break;
			case 6:
				selectMarketCrash();
				break;
			case 7:
				deleteSpecificPryl();
				break;
			case 8:
				deletePerson();
				break;
			case 9:
				systemExit();
				break;
			default:
				System.out.println("Felaktigt kommando! Var vänlig försök igen.\n");
				break;
			}
		}
	}
	
}
