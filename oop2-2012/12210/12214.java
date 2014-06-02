import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import java.io.*;

/**
 * @author Fredrika St�hl, 2012-12-25
 */

public class Registry 
{
	private static String name; 					
	private static String richestPerson;
	private static String fileName = "PersonFile.txt";
	private static ArrayList<Person> owners;												// Lista med alla registrerade personer.
	private static ArrayList<Valuable> bank;												// En persons lista �ver dess v�rdesaker.
	private static int ownersListPosition;													// Visar �nskad persons position i ArrayList.
	private static int personTotalWealth;
	private static Person person;
	private static Jewelery jewelery;
	private static Appliance appliance;
	private static Share share;
	private static String shareName;
	private static int sharePrice;
	private static int valueOfValuable;														// V�rdet f�r en v�rdesak.
	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) 
	{	
		for(;;)
		{
			int kom = readInt("\n\n1 - Skapa en ny person" +
					"\n2 - Skapa en ny v�rdesak" + 
					"\n3 - Visa alla personer" + 
					"\n4 - Visa viss person" +
					"\n5 - Visa rikaste person" + 
					"\n6 - B�rskrasch" +
					"\n7 - �ndra v�rde p� aktie" +
					"\n8 - Avsluta" + 
					"\n\nAnge kommando: "); 
			 
			switch(kom)
			{
			
				case 1: 																	// Skapa ny person
					owners = getAllOwners();
					
					name = readString("Vad heter personen? ");
					ownersListPosition = getPositionInList(name);
					
					while(ownersListPosition >= 0)
					{
						name = readString("Personen existerar redan, f�rs�k igen: ");
						ownersListPosition = getPositionInList(name);
					}	
					
					/* 
					 * Skapa personen, l�gga till personen i owners-Arraylist och spara owners-Arraylist till filen.
					 */
					person = new Person(name); 
					owners.add(person);
					saveOwnersList(owners);
					
					break;
				case 2: 																	// Skapa ny v�rdesak
					owners = getAllOwners();
					
					name = readString("Vem �ger v�rdesaken? ");
					ownersListPosition = getPositionInList(name);
					
					/*
					 * Skapa personen om personen inte redan finns, ist�llet f�r tvinga anv�ndare att g� till Case 1 ovan.
					 */
					if(ownersListPosition == -1)
					{
						person = new Person(name);
						owners.add(person);
						ownersListPosition = owners.size() - 1;
					}
									
					person = owners.get(ownersListPosition);								// Skapar en person genom att plocka ut personen fr�n Owners-listan p� �nskad position.
										
					int kom1 = readInt("\nVilken v�rdesak vill du skapa?" + 
							"\n\n1 - Skapa smycke" + 
							"\n2 - Skapa aktie" + 
							"\n3 - Skapa apparat" +
							"\n\nAnge kommando: "); 
				
					switch(kom1)
					{
						case 1: 															// Skapa nytt smycke
							String jeweleryName = readString("Vilket sorts smycke �ger " + person.getName() + "? ");
							String preciousMetal = readString("Vilken �delmetall best�r smycket av, guld eller silver? ");
							
							while( !preciousMetal.equalsIgnoreCase("guld") && !preciousMetal.equalsIgnoreCase("silver") )
							{
								preciousMetal = readString("Systemet st�djer endast f�r �delmetallerna guld och silver. F�rs�k igen: ");
							}
							int numberOfStones = readInt("Hur m�nga �delstenar har smycket? ");
							
							jewelery = new Jewelery(jeweleryName, preciousMetal, numberOfStones);
							person.setValuable(jewelery);									// Kopplar v�rdesaken till en specifik person.
							
							break;
						case 2:																// Skapa ny aktie
							shareName = readString("Vad heter aktien? ");
							sharePrice = readInt("Vad �r en aktie v�rd? ");
							int numberOfShares = readInt("Hur m�nga aktier har " + person.getName() + "? ");
							
							share = new Share(shareName, sharePrice, numberOfShares);
							person.setValuable(share);										// Kopplar v�rdesaken till en specifik person.
							
							break;
						case 3: 															// Skapa ny apparat
							String applianceName = readString("Vad �r det f�r typ av apparat? ");
							int applianceWear = readInt("Hur sliten �r den (10 = ny, 1 = v�ldigt sliten)? ");
							int applianceRetailPrice = readInt("Vad var apparatens ink�pspris? ");
							
							appliance = new Appliance(applianceName , applianceWear, applianceRetailPrice);
							person.setValuable(appliance);									// Kopplar v�rdesaken till en specifik person.
							
							break;
					}
					saveOwnersList(owners);
					break;

				case 3: 																	// Lista alla �gare					
					System.out.println("\nI registret finns:\n");
					
					owners = getAllOwners();
					for(int i = 0; i < owners.size(); i++)
					{
						person = owners.get(i);
						System.out.println(person.getName() + ": " + person.getTotalWealth() + " SEK" );
					}
					
					break;
				case 4: 																	// Lista en enskild �gare
					name = readString("Vilken person vill du se? ");	
					showPersonsPossessions(name);
					
					break;
				case 5: 																	// Visa rikaste personen
					owners = getAllOwners();
					if(owners.size() >= 1)
					{
						String[][] unSortedOwners = new String[owners.size()][2];			// Skapar tempor�rt en osorterad 2D-array.
						
						for(int i = 0; i < owners.size(); i++)								// Flyttar �ver personens namn och totala rikedom till 2D-arrayen.
						{
							person = owners.get(i);
							personTotalWealth = person.getTotalWealth();
							unSortedOwners[i][0] = Integer.toString(personTotalWealth);
							unSortedOwners[i][1] = person.getName();		
						}
						
						String[][] sortedOwners = new String[owners.size()][2];				// Skapar tempor�rt en sorterad 2D-array.
						sortedOwners = sort2DArray(unSortedOwners);
						
						richestPerson = sortedOwners[sortedOwners.length - 1][1]; 			// Rikaste person �r sista personen i den sorterade arrayen.
						
						System.out.print(richestPerson + " �r rikast. ");
						showPersonsPossessions(richestPerson);
					}
					else
					{
						System.out.print("Det finns inga registrerade i registret.");
					}
					
					break;
				case 6: 																	// B�rskrasch	
					owners = getAllOwners();
					for(int i = 0; i < owners.size(); i++)
					{
						person = owners.get(i);
						person.resetAllShares();
					}
					saveOwnersList(owners);
					
					System.out.print("B�rskrasch!");
					
					break;
				case 7:																		// �ndra en akties pris	
					shareName = readString("Vilken aktie vill du �ndra? ");
					sharePrice = readInt("Vilket pris har aktien idag? ");
					
					owners = getAllOwners();
					for(int i = 0; i < owners.size(); i++)
					{
						person = owners.get(i);
						person.setSharePrice(shareName, sharePrice);
					}
					saveOwnersList(owners);
					
					System.out.print("Aktiens pris har nu �ndrats f�r ber�rda personer.");
			
					break;
				case 8: 																	// Avsluta programmet
					System.out.print("Programmet avslutat, hejd�!");
					System.exit(0);

			}
		}
	}

	/*
	 *  L�ser in alla undansparade personer fr�n filen.
	 */
	private static ArrayList<Person> getAllOwners()
	{
		ArrayList<Person> owners = new ArrayList<Person>();
		try
		{
			FileInputStream personFileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(personFileIn);
			
			while(personFileIn.available()>0)
			{
				Person existingPerson = (Person) in.readObject();
				owners.add(existingPerson);
			}
			in.close();
	        personFileIn.close();
		}
		catch(FileNotFoundException f)
		{
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException c)
		{
			
		}
		return owners;
	}
	
	/*
	 * Spara undan en lista inneh�llandes olika objekt p� lokal plats.
	 */
	private static void saveOwnersList(ArrayList<Person> list)					
	{
		try
		{
			FileOutputStream personFile = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(personFile);
			for(int i = 0; i < list.size(); i++)
			{
				out.writeObject(list.get(i));
			}
			
			out.close();
	        personFile.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * 	Kolla om angivet namn ovan existerar i owners listan som inneh�ller alla personer. 
	 * Om ja, ge oss aktuell position.
	 * Om nej, retunera -1.
	 */
	private static int getPositionInList(String name)
	{
		owners = getAllOwners();
		ownersListPosition = -1;
		
		for(int i = 0; i < owners.size(); i++)
		{
			String personName = (owners.get(i)).getName();
			if((personName.toLowerCase()).equals(name.toLowerCase()))
			{
				ownersListPosition = i;
				break;
			}
		}
		return ownersListPosition;
	}
	
	/*
	 *  Tar in en osorterad 2D-array och returnerar samma array nu sorterad.
	 */
	private static String[][] sort2DArray(String[][] array)
	{
		List<String[]> sublist = Arrays.asList(array).subList(0, array.length);
		Collections.sort(sublist, new Comparator<String[]>() 
		{
		    @Override
		    public int compare(String[] a1, String[] a2) 
		    {
		        return Float.valueOf(a1[0]).compareTo(Float.valueOf(a2[0]));
		    }
		});
		return array;
	}
	
	/*
	 *  G� igenom hela en existerande persons bank och skriv ut varje v�rdesaks namn och v�rde.
	 */
	private static void showPersonsPossessions(String name)
	{
		/* Kontroll f�r att kolla om personen existerar, eftersom existerande personer i listan har en position i owners-listan som >= 0 */
		ownersListPosition = getPositionInList(name);
		while(ownersListPosition == -1)
		{
			name = readString("Personen existerar inte, f�rs�k igen: ");
			ownersListPosition = getPositionInList(name);
		}	
		
		owners = getAllOwners();
		Person person = owners.get(ownersListPosition);
		System.out.println(person.getName() + " har sammanlagt " + person.getTotalWealth() + " SEK." );	

		/* G� igenom hela personens bank och skriv ut v�rdesakens namn och dess v�rde */
		bank = person.getBank();
		for(int i = 0; i < bank.size(); i++)
		{
			Valuable valuable = bank.get(i);
			if(valuable instanceof Share)
			{
				valueOfValuable = ((Share)valuable).getValue();
			}
			else if(valuable instanceof Jewelery)
			{
				valueOfValuable = ((Jewelery)valuable).getValue();
			}
			else if(valuable instanceof Appliance)
			{
				valueOfValuable = ((Appliance)valuable).getValue();
			}
			System.out.println(valuable.getName() + ": " + valueOfValuable + " SEK");
		}
	}
	
	/*
	 * Indatakontroll f�r Integer
	 */
	private static int readInt(String question)
	{
		for(;;)
		{
			try
			{
				System.out.print(question);
				return Integer.parseInt(keyboard.nextLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Fel - Det ska vara ett numeriskt v�rde. ");
			}
		}
	}
	
	/*
	 * Indata f�r String
	 */
	private static String readString(String question)
	{
		System.out.print(question);
		return keyboard.nextLine();
	}
}