import java.util.Scanner;
import java.util.ArrayList;
public class ValuablesSystem 
{
	Scanner keyboard = new Scanner(System.in);
	private ArrayList<Valuable> allValuables = new ArrayList<Valuable>();
	private ArrayList<Owner> allOwners = new ArrayList<Owner>();
	private ArrayList<Owner> allRichestOwners = new ArrayList<Owner>();
	private ArrayList<Currency> allCurrencies = new ArrayList<Currency>();
	private Currency systemCurrency;
	private Currency currency;
	private int ownerID;
	private int valuableID;
	
//______________________________________________________________________________________________________________	
	public static void main (String [] args)
	{
		//Instantiation of ValuablesSystem to avoid static context:
		ValuablesSystem valuablesSystem = new ValuablesSystem();
		valuablesSystem.runValuablesSystem();
	}

//______________________________________________________________________________________________________________
	public void runValuablesSystem()
	{	
//		Setting the overall currency of the system:
		String systemCurrencyName = "SEK";
		systemCurrency = new Currency(systemCurrencyName, 1);
		allCurrencies.add(systemCurrency);

//______________________________________________________________________________________________________________	
//		Setting default currency (same currency as systemCurrency) for the valuables to be entered in 
//		(as the system is designed to be able to store valuables in different currencies):
		currency = new Currency(systemCurrency.getCurrencyName(), systemCurrency.getCurrencyRatio());
		allCurrencies.add(currency);

//______________________________________________________________________________________________________________		
		System.out.println("Välkommen!\n");
		
		boolean programRunning = true;
				
		do
		{	
			System.out.println("Välj funktion nedan.\n"
						+ "    1 = Registrera ny ägare\n"
						+ "    2 = Visa/redigera specifik ägare\n"
						+ "    3 = Visa/redigera specifikt värdeföremål\n"
						+ "    4 = Visa rikaste ägare\n"
						+ "    5 = Lista alla ägare\n"
						+ "    6 = Lista alla värdeföremål\n"
						+ "    7 = Visa totalvärdet på systemets alla värdeföremål\n"
						+ "    8 = Genomför börscrasch på hela systemet\n"
						+ "    9 = Avsluta programmet\n");
								
			int feature = catchNumberFormatExceptionInt();
					
				switch (feature)
				{
					case 1:
						addOwner();
						break;
					case 2:
						searchOwner();	
						break;
					case 3:
						searchValuable();
						break;
					case 4:	
						getRichestOwner();
						break;
					case 5:
						listAllOwners();
						break;
					case 6:
						listAllValuables();
						break;
					case 7:
						getSystemTotalValue();
						break;
					case 8:
						crashSystemStockMarket();
						break;
					case 9:
						exitSystem();
						break;
					default:
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 9.\n");
						break;
				}					
		}	
		while (programRunning != false);	
		
	}	
	
//______________________________________________________________________________________________________________
		public void addBling(Owner owner)
		{
			String material = null;
			
			System.out.print("Ange namn på smycket: ");
			String valuableName = keyboard.nextLine();
			System.out.println();
			
			boolean correctEnter = false;
			
			do
			{	
				
				System.out.println("Ange material.\n" 
								+ "    1 = guld\n"
								+ "    2 = silver\n");
			
				int feature = catchNumberFormatExceptionInt();
			
				switch (feature)
				{
					case 1:
						material = "guld";
						correctEnter = true;
						break;
					case 2:
						material = "silver";
						correctEnter = true;
						break;				
					default:
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 2.");
						break;
				}
				
			}
			while (correctEnter != true);
			
			System.out.print("Ange antal stenar: ");
			
			int stones = catchNumberFormatExceptionInt();
			
			valuableID++;
			
			Bling bling = new Bling(valuableName, valuableID, currency, owner, material, stones);
			
			allValuables.add(bling);
			
			owner.addValuable(bling);
			
			System.out.println("Du har nu lagt till följande värdeföremål i systemet:\n\n" + bling);
			
		}	
		
//______________________________________________________________________________________________________________	
		public void addBlockOfShares(Owner owner)
		{
			System.out.print("Ange namn på aktieposten: ");
	
			String valuableName = keyboard.nextLine();
					
			System.out.print("Ange antal aktier i aktieposten: ");
			
			int numberOfShares = catchNumberFormatExceptionInt();
					
			System.out.print("Ange aktuell aktiekurs (i " + systemCurrency.getCurrencyName() + "/aktie): ");
			double pricePerShare = catchNumberFormatExceptionDouble();
			
			valuableID++;
			
			BlockOfShares blockOfShares = new BlockOfShares(valuableName, valuableID, currency, owner,
											numberOfShares, pricePerShare);
			
			allValuables.add(blockOfShares);
			
			owner.addValuable(blockOfShares);
			
			System.out.println("Du har nu lagt till följande värdeföremål i systemet:\n\n" 
					+ blockOfShares);	
		}	
				
//______________________________________________________________________________________________________________	
		public String addCurrency()
		{
		System.out.println("valuta");
		
		String enteredCurrency = keyboard.nextLine();
		
		System.out.println("Värderatio i förhållande till" + systemCurrency.getCurrencyName() 
				+ "(decimaltal): ");
		
		double currencyRatio = catchNumberFormatExceptionDouble();
		
		Currency currency = new Currency(enteredCurrency, currencyRatio);
		allCurrencies.add(currency);
		
		return ("Du har nu lagt till följande valuta i systemet:\n\n" 
				+ currency);
				
		}
		
//______________________________________________________________________________________________________________	
		public void addOwner()
		{
			
			System.out.print("Ange ägarens namn: ");
			String ownerName = keyboard.nextLine();
		
			long nationalIdentityNumberRequest;
			
			boolean correctEnter;
			
			do
			{	
				nationalIdentityNumberRequest = enterNationalIdentityNumber();

				correctEnter = true;
				
				for (Owner owner : allOwners)
				{
					if(owner.getNationalIdentityNumber() == nationalIdentityNumberRequest)
					{
						System.out.println("Det finns redan en ägare med det personnumret i " +
								"systemet. Försök igen.");
						correctEnter = false;
						break;
					}
				}
			}
			while(correctEnter != true);
			
			long nationalIdentityNumber = nationalIdentityNumberRequest;
			System.out.println();
			
			ownerID += 1;
			
			Owner owner = new Owner(ownerName, nationalIdentityNumber, ownerID);
			
			allOwners.add(owner);
			
			
			System.out.println("Du har nu lagt till följande ägare i systemet:\n\n" 
					+ owner);
			
			menuOwner(owner);
			
		}
								
//______________________________________________________________________________________________________________
		public void addTechncialDevice(Owner owner)
		{
			System.out.print("Ange namn på teknikprodukten: ");

			String valuableName = keyboard.nextLine();
			
			System.out.print("Ange inköpspris: ");
			double purchasePrice = catchNumberFormatExceptionDouble();
			
			System.out.print("Ange skick på en skala mellan 1 och 10 (10 är nyskick): ");
			int condition = catchNumberFormatExceptionInt();
			
			valuableID++;
			
			TechnicalDevice technicalDevice = new TechnicalDevice(valuableName, valuableID, currency, owner,
												purchasePrice, condition);
			
			allValuables.add(technicalDevice);
			
			owner.addValuable(technicalDevice);
			
			System.out.println("Du har nu lagt till följande värdeföremål i systemet:\n\n" 
					+ technicalDevice);
		}	
		
//______________________________________________________________________________________________________________	
		public void addValuable(Owner owner)
		{
			boolean correctEnter = false;
		
			do
			{	
				System.out.print("Ange typ av värdeföremål.\n"
								+ "    1 = Smycke\n"
								+ "    2 = Teknikprodukt\n"
								+ "    3 = Aktiepost\n"
								+ "    4 = Avbryt\n\n");
			
				int feature = catchNumberFormatExceptionInt();
			
				switch (feature)
				{
					case 1:
						correctEnter = true;
						addBling(owner);
						break;
					case 2:
						correctEnter = true;
						addTechncialDevice(owner);
						break;
					case 3:
						correctEnter = true;
						addBlockOfShares(owner);
						break;
					case 4:
						correctEnter = true;
						System.out.println("Operationen avbryts.\n");
						break;
					default:
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 4.\n");
						break;
				}	
			}
			while (correctEnter != true);			
		}
		
//______________________________________________________________________________________________________________	
		//Try/catch method for checking that the user enters a double:
		public double catchNumberFormatExceptionDouble()
		{
			double userDoubleEntered = 0;
			boolean correctEnter;
			
			do
			{	
				correctEnter = true;
				
				try
				{
					userDoubleEntered = Double.parseDouble(keyboard.nextLine());
					System.out.println();
				}
				catch (NumberFormatException e)
				{
					System.out.println("\n" + "Felaktig inmatning, skriv in ett hel- eller decimaltal " +
							"(se till så du anger decimaltecken på rätt sätt).\n");
					correctEnter = false;
				}
			}
			while (correctEnter != true);
			
			return userDoubleEntered;
			
		}	
		
//______________________________________________________________________________________________________________		
		//Try/catch method for checking that the user enters an int:
		public int catchNumberFormatExceptionInt()
		{
			int userIntEntered = 0;
			boolean correctEnter;
			
			do
			{	
				correctEnter = true;
				
				try
				{
					userIntEntered = Integer.parseInt(keyboard.nextLine());
					System.out.println();
				}
				catch (NumberFormatException e)
				{
					System.out.println("\n" + "Felaktig inmatning, skriv in ett heltal.\n");
					correctEnter = false;
				}
			}
			while (correctEnter != true);
			
			return userIntEntered;
			
		}	
		
//______________________________________________________________________________________________________________		
		public void crashOwnerStockMarket(Owner owner)
 		{
	 		System.out.println("Är du säker på att du vill genomföra börscrash för " + owner.getOwnerName() 
	 				+ "? Alla aktier som finns lagrade på denna ägare kommer att bli värdelösa, och " 
	 				+ "åtgärden går ej att ångra.\n"
					+ "1 = Ja, genomför börscrash på denna specifika ägare\n"
					+ "2 = Avbryt");	
	 		
	 		boolean correctEnter;
			
	 		do
	 		{	
	 			int feature = catchNumberFormatExceptionInt();
		 		System.out.println();
		 		
		 		correctEnter = true;
		 		
				switch (feature)
				{
					case 1:
						owner.crashOwnerStockMarket();	
						System.out.println("Alla aktier tillhörande " + owner.getOwnerName() + " har nu " +
								"fått ett nollställt värde.\n");
						break;
					case 2:
						System.out.println("Börscrash har ej genomförts.\n");
						break;
					default:
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 2.");
						correctEnter = false;
						break;
				}
	 		}
	 		while (correctEnter != true);
				
		}
 		
 //______________________________________________________________________________________________________________	
		public void crashSystemStockMarket()
		{
			System.out.println("Är du säker på att du vill genomföra börscrash på hela systemet? "
					+ "Alla aktier för samtliga ägare som finns "
					+ "lagrade i systemet för kommer att bli värdelösa, och åtgärden går ej att ångra.\n"
					+ "    1 = Ja, genomför börscrash på hela systemet\n"
					+ "    2 = Avbryt\n");
			
			
			
			boolean correctEnter;
			
			do 
			{	
			
				int feature = catchNumberFormatExceptionInt();
				
				correctEnter = true;
				
				switch (feature)
				{	
	
					case 1:
						for (Valuable valuable : allValuables)
						{
							if (valuable instanceof BlockOfShares)
							{	
								((BlockOfShares)valuable).setPricePerShare(0);
							}
						}
				
						System.out.println("Alla aktier i systemet har nu fått ett nollställt värde.");
						break;
					
					case 2:
						System.out.println("Börscrash har ej genomförts.");
						break;
					
					default:	
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 2.");
						correctEnter = false;
						break;
				}		
	
			}	
			while(correctEnter != true);
			
			System.out.println();		
		}	

//______________________________________________________________________________________________________________
		public void editNumberOfShares(BlockOfShares blockOfShares)
		{
			System.out.print("Ange antal aktier du vill lägga till i aktieposten " 
					+ blockOfShares.getValuableName() +
					" (om du vill ta bort aktier anger du ett negativt tal): "); 
			
			int addedShares = catchNumberFormatExceptionInt();
			
			blockOfShares.editNumberOfShares(addedShares);
		}

//______________________________________________________________________________________________________________	
		//Making sure the user enters a valid national identity number:
		public long enterNationalIdentityNumber()
		{
			
			long nationalIdentityNumberLong = 0;
			String nationalIdentityNumberString;
			
			boolean correctEnter;
			
			System.out.print("Ange ägarens personummer(ÅÅÅÅMMDDXXXX): ");

			do
			{
				do
				{	
					correctEnter = true;
					
					try
					{
						nationalIdentityNumberLong = Long.parseLong(keyboard.nextLine());
						System.out.println();
					}
					catch (NumberFormatException e)
					{
						System.out.println("\n" + "Felaktig inmatning, endast siffror är " +
								"tillåtna. Försök igen: \n");
						correctEnter = false;
					}
				}
				while (correctEnter != true);
				
				nationalIdentityNumberString = "" + nationalIdentityNumberLong;
			
				if (nationalIdentityNumberString.length() != 12)
				{	
					correctEnter = false;
					System.out.print("Felaktig inmatning, personnumret " +
							"måste vara 12 tecken långt. Försök igen: ");			
				}
				
			}
			while (correctEnter != true);
			
			long nationalIdentityNumberRequest = Long.parseLong(nationalIdentityNumberString);
			
			return nationalIdentityNumberRequest;
		}	
//______________________________________________________________________________________________________________
		//Exiting the system:
		private void exitSystem()
		{
			System.out.println("När du avslutar försvinner all information du matat in i systemet." 
					+ " Är du säker på att du vill avsluta?\n"
					+ "    1 = Ja\n"
					+ "    2 = Avbryt\n");
			
			boolean correctEnter;
			
			do
			{	
				int feature = catchNumberFormatExceptionInt();
				
				correctEnter = true;
				
				switch (feature)
				{
					case 1:
						System.out.println("Tack och hej!");
						System.exit(0);
						break;
					case 2:
						System.out.println("Programmet avslutades inte. Du skickas nu " +
									"tillbaka till huvudmenyn.\n");
						break;
					default:
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 2.\n");
						correctEnter = false;
						break;
				}
			}
			while (correctEnter != true);
		}	
		
//______________________________________________________________________________________________________________		
		public void getRichestOwner()
		{

			allRichestOwners.clear();
			
			Owner richestOwner = new Owner();
			
			for (Owner owner : allOwners)
			{
				if (owner.getWealth() > richestOwner.getWealth())
				{
					richestOwner = owner;
					allRichestOwners.clear();
					allRichestOwners.add(richestOwner);
				}
				else if (owner.getWealth() == richestOwner.getWealth())
				{
					allRichestOwners.add(owner);
				}
			}	
			
			if (allRichestOwners.size() == 0)
			{
				System.out.println("Det finns inga ägare registrerade i systemet.\n");
			}
			else
			{	
				System.out.println("Systemets rikaste ägare:\n");					
				listAllRichestOwners();
			}				
		}
		
//______________________________________________________________________________________________________________	
		public void getSystemTotalValue()
		{
			double systemTotalValue = 0;
			
			for (Valuable valuable : allValuables)
			{
				systemTotalValue += valuable.getValue();
			}
			
			System.out.println("Det sammanlagda värdet för samtliga värdesaker som " +
					"för närvarande finns i systemet är " + systemTotalValue + " " 
					+ systemCurrency.getCurrencyName() + ".\n");
		}
		
//______________________________________________________________________________________________________________
		public void listAllCurrencies()
		{
			
			if (allCurrencies.size() == 0)
			{
				System.out.println("Det finns inga valutor lagrade i systemet.");
			}
			else
			{
				System.out.println("Följande valutor finns registrerade i systemet:\n");
				
				for (Currency currency : allCurrencies)
				{
					System.out.println(currency);
				}
			}
			
			System.out.println();
		}
		
//______________________________________________________________________________________________________________
		public void listAllOwners()
		{
			if (allOwners.size() == 0)
			{
				System.out.println("Det finns inga ägare registrerade i systemet.");
			}
			
			else
			{
				System.out.println("Följande ägare finns registrerade i systemet:\n");
				
				for (Owner owner : allOwners)
				{
					System.out.println(owner);
				}
				
			}	
			
			System.out.println();	
		}	
		
//______________________________________________________________________________________________________________
		public void listAllRichestOwners()
		{
			for (Owner owner : allRichestOwners)
			{
				System.out.println("Namn: " + owner.getOwnerName() + "\n"
						+ "Förmögenhet: " + owner.getWealth() + " " + systemCurrency.getCurrencyName() + ".\n");
			}
		}
		
//______________________________________________________________________________________________________________		
		public void listAllValuables()
		{
			if (allValuables.size() == 0)
			{
				System.out.println("Det finns inga värdeföremål registrerade i systemet.");
			}
			
			else
			{
				System.out.println("Följande värdeföremål finns registrerade i systemet:\n");
				
				for (Valuable valuable : allValuables)
				{			
					System.out.println(valuable);
				}
			}	
			
			System.out.println();
		}
		
//______________________________________________________________________________________________________________	
		public void menuBling(Bling bling)
		{						
			boolean correctEnter;
								
			do 
			{	
				System.out.println("Välj vilken åtgärd du vill utföra för smycket "
								+ bling.getValuableName() + ".\n"
								+ "    1 = Visa information\n" 
								+ "    2 = Radera smycket\n");
								
				int feature = catchNumberFormatExceptionInt();

				correctEnter = true;
						
				switch (feature)
				{
					case 1:
						System.out.println(bling);
						break;
					case 2:
						removeValuable(bling);
						break;
					default:
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 2.");
						correctEnter = false;
						break;
				}
			}	
			while (correctEnter != true);
		}	
			
//______________________________________________________________________________________________________________	
		public void menuBlockOfShares(BlockOfShares blockOfShares)
		{
			boolean correctEnter;
			do 
			{	
				System.out.println("Ange vilken åtgärd du vill utföra för aktieposten " 
								+ blockOfShares.getValuableName() + ".\n"
								+ "    1 = Visa information\n"
								+ "    2 = Ändra antalet aktier\n" 
								+ "    3 = Ändra aktiekurs\n"
								+ "    4 = Radera aktieposten\n");
						
				int feature = catchNumberFormatExceptionInt();
					
				correctEnter = true;
					
				switch (feature)
				{
					case 1:
						System.out.println(blockOfShares);
						break;
					case 2:	
						editNumberOfShares(blockOfShares);
						break;						
					case 3:
						setPricePerShare(blockOfShares);
						break;
					case 4:
						removeValuable(blockOfShares);
						break;
					default:
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 4.");
						correctEnter = false;
						break;
				}
			}	
			while (correctEnter != true);
		}	
				
//______________________________________________________________________________________________________________	
		public void menuOwner(Owner owner)
		{
			System.out.println("Välj vilken åtgärd du vill utföra för ägaren " + owner.getOwnerName() + ".\n"
						+ "    1 = Visa ägaruppgifter\n"
						+ "    2 = Lista alla ägarens värdeföremål\n"
						+ "    3 = Registrera nytt värdeförmål bland ägarens tillgångar\n"
						+ "    4 = Genomför börscrasch för ägaren\n"
						+ "    5 = Tillbaka till huvudmenyn\n");

			
			boolean correctEnter;
			
			do
			{	
				
				int feature = catchNumberFormatExceptionInt();
				
				correctEnter = true;
				
				switch (feature)
				{
					case 1:
						System.out.println(owner);
						break;
					case 2:	
						owner.listOwnerAllValuables();
						break;
					case 3:
						addValuable(owner);	
						break;
					case 4:	
						crashOwnerStockMarket(owner);
						break;
					case 5:
						break;
					default:
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 5.\n");
						correctEnter = false;
						break;			
				}
			}
			while (correctEnter != true);
		}	
		
//______________________________________________________________________________________________________________
		public void menuTechnicalDevice(TechnicalDevice technicalDevice)
		{
							
			boolean correctEnter;
											
			do 
			{	
				System.out.println("Välj vilken åtgärd du vill utföra för teknikprodukten "
								+ technicalDevice.getValuableName() + ".\n"
								+ "    1 = Visa information\n" 
								+ "    2 = Radera teknikprodukten\n");
									
				int feature = catchNumberFormatExceptionInt();
										
				correctEnter = true;
									
				switch (feature)
				{
					case 1:
						System.out.println(technicalDevice);
						break;
					case 2:
						removeValuable(technicalDevice);
						break;
					default:
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 2.");
						correctEnter = false;
						break;
				}
			}	
			while (correctEnter != true);
		}			
				
//______________________________________________________________________________________________________________		
		public void removeValuable(Valuable valuable)
		{
			System.out.println("Är du säker på att du vill ta bort värdeföremålet "
						+ valuable.getValuableName() + "? Åtgärden går inte att ångra.\n"
						+ "    1 = Ja\n"
						+ "    2 = Avbryt\n");
			
			boolean correctEnter;
			
			do 
			{	
				int feature = catchNumberFormatExceptionInt();

				correctEnter = true;
			
				switch (feature)
				{
					case 1:
						valuable.getOwner().removeValuable(valuable);
						allValuables.remove(valuable);
						System.out.println("Värdeföremålet " + valuable.getValuableName() 
								+ " är nu raderat ur systemet.\n");
						break;
					case 2:
						System.out.println("Operationen avbröts.\n");
						break;
					default:
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 2.\n");
						correctEnter = false;
						break;
				}	
			}
			while (correctEnter != true);
		}
		
//______________________________________________________________________________________________________________		
		public void setPricePerShare(BlockOfShares blockOfShares)
		{
			System.out.print("Ange det nya priset per aktie i aktieposten " 
						+ blockOfShares.getValuableName() + ": "); 
			
			double pricePerShare = catchNumberFormatExceptionDouble();
			
			blockOfShares.setPricePerShare(pricePerShare);
			
			System.out.println ("Du har nu ändrat kursen på " + blockOfShares.getValuableName() 
						+ " till " + pricePerShare + " " + blockOfShares.getCurrencyName() + "/aktie.\n"		
						+ "Aktuellt värde på aktieposten: "+ blockOfShares.getValue() + " " 
						+ blockOfShares.getCurrencyName() + "\n");

		}
		
//______________________________________________________________________________________________________________
		public void searchOwner()
		{
			System.out.println("Ange hur du vill söka efter ägaren.\n"
					+ "    1 = Sök på namn\n"
					+ "    2 = Sök på personnummer\n"
					+ "    3 = Avbryt\n");
			
			boolean correctEnter;
			
			do
			{
				int feature = catchNumberFormatExceptionInt();
				
				correctEnter = true;
				
				switch (feature)
				{
					case 1:
						searchOwnerByName();
						break;
					case 2:
						searchOwnerByNationalIdentityNumber();
						break;
					case 3:	
						System.out.println("Operationen avbröts.\n");
						break;
					default:
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 3.\n");
						correctEnter = false;
						break;
				}
			}
			while (correctEnter != true);
		}
		
//______________________________________________________________________________________________________________
		public void searchOwnerByName()
		{
			boolean endOperation = false;
		
			do 
			{	
				System.out.print("Ange namn på ägaren du vill visa: ");

				String ownerNameRequest = keyboard.nextLine();
				System.out.println();
				
				int namesFound = 0;
				
				for (Owner owner : allOwners)
				{
					if (owner.getOwnerName().equalsIgnoreCase(ownerNameRequest))
					{
						namesFound++;
					}
				}
			
				if (namesFound == 0)
				{
					System.out.println("Det finns ingen ägare med det namnet registrerad" 
										+ " i systemet. Vill du göra ett nytt försök?\n"
										+ "    1 = Ja\n"
										+ "    2 = Avbryt\n");
					
					
					
					boolean correctEnter;
					
					do
					{	
						int feature = catchNumberFormatExceptionInt();
						
						correctEnter = true;
						switch (feature)
						{
							case 1:
								break;
							case 2:
								System.out.println("Operationen avbröts.\n");
								endOperation = true;
								break;
							default:
								System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 2.\n");
								correctEnter = false;
								break;
						}
					}
					while (correctEnter != true);
					
				}
				
				else if (namesFound == 1)
				{
					for (Owner owner : allOwners)
					{	
						if(owner.getOwnerName().equalsIgnoreCase(ownerNameRequest))
						{
							owner.toString();
							endOperation = true;
							menuOwner(owner);
							break;
						}
					}
					
				}
				else
				{
					System.out.println("Det finns flera ägare med det namnet registrerade " +
							"i systemet. Välj ett alternativ nedan.\n"
							+ "    1 = Försök igen\n"
							+ "    2 = Sök på personnummer\n"
							+ "    3 = Avbryt\n");
					
					
					
					boolean correctEnter;
					
					do
					{	
						
						int feature = catchNumberFormatExceptionInt();
						
						correctEnter = true;
						
						switch (feature)
						{
							case 1:
								break;
							case 2:
								endOperation = true;
								searchOwnerByNationalIdentityNumber();
								break;
							case 3:
								System.out.println("Operationen avbröts.\n");
								endOperation = true;
								break;
							default:
								System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 3.\n");
								correctEnter = false;
								break;
						}
					}
					while (correctEnter != true);
				}	
						
			}
			while (endOperation != true);
		}	

//______________________________________________________________________________________________________________
		public void searchOwnerByNationalIdentityNumber()
		{
			boolean endOperation = false;
			
			do		
			{
			
				long nationalIdentityNumberRequest = enterNationalIdentityNumber();
						
				int numbersFound = 0;
						
				for (Owner owner : allOwners)
				{
					if (owner.getNationalIdentityNumber() == nationalIdentityNumberRequest)
					{
						numbersFound++;
						break;
					}
				}
					
				if (numbersFound == 1)
				{
					for (Owner owner : allOwners)
					{
						if (owner.getNationalIdentityNumber() == nationalIdentityNumberRequest)
						{	
							System.out.println("Är det följande ägare du menar?\n" + owner.toString() + "\n"
										+ "    1 = Ja\n"
										+ "    2 = Nej, försök igen\n"
										+ "    3 = Avbryt\n");				
					
							boolean correctEnter;
									
							do
							{			
								int feature = catchNumberFormatExceptionInt();
								
								correctEnter = true;
								
								switch (feature)
								{
									case 1:
										endOperation = true;
										menuOwner(owner);				
										break;
									case 2:
										break;
									case 3:	
										System.out.println("Operationen avbröts.\n");
										break;
									default:
										System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 3.\n");
										correctEnter = false;
										break;
								}
							}
							while (correctEnter != true);
									
							break;
								
						}	
					}	
							
				}
				else
				{
					System.out.println("Det finns ingen ägare med det personnumret registrerat" 
								+ " i systemet. Välj ett alternativ nedan.\n"
								+ "    1 = Försök igen\n"
								+ "    2 = Sök på namn\n"
								+ "    3 = Avbryt\n");
					
					boolean correctEnter;
					
					do
					{	
						int feature = catchNumberFormatExceptionInt();
						
						correctEnter = true;
						
						switch (feature)
						{
							case 1:
								break;
							case 2:
								endOperation = true;
								searchOwnerByName();
								break;
							case 3:
								System.out.println("Operationen avbröts.\n");
								endOperation = true;
								break;
							default:
								System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 3.\n");
								correctEnter = false;
								break;
						}
					}
					while (correctEnter != true);
				}
				
			}
			while(endOperation != true);
		}
		
//______________________________________________________________________________________________________________
		public void searchValuable()
		{
			System.out.println("Ange hur du vill söka efter värdeföremålet.\n"
					+ "    1 = Sök på namn\n"
					+ "    2 = Sök på värdeföremåls-ID\n"
					+ "    3 = Avbryt\n");
			
			boolean correctEnter;
			
			do
			{
				int feature = catchNumberFormatExceptionInt();
				
				correctEnter = true;
				
				switch (feature)
				{
					case 1:	
						searchValuableByName();
						break;
					case 2:
						searchValuableByID();
						break;
					case 3:	
						System.out.println("Operationen avbröts.\n");
						break;
					default:
						System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 3.\n");
						correctEnter = false;
						break;
				}
			}
			while (correctEnter != true);
		}
		
//______________________________________________________________________________________________________________
		public void searchValuableByID()
		{
			boolean endOperation = false;
					
			do		
			{
				System.out.print("Ange värdeföremåls-ID på värdeföremålet du vill visa: ");

				int valuableIDRequest = catchNumberFormatExceptionInt();
								
				int numbersFound = 0;
								
				for (Valuable valuable : allValuables)
				{
					if (valuable.getValuableID() == (valuableIDRequest))
					{
						numbersFound++;
			
						System.out.println("Är det följande värdeföremål du menar?\n" + valuable.toString() + "\n"
												+ "    1 = Ja\n"
												+ "    2 = Nej, försök igen\n"
												+ "    3 = Avbryt\n");
														
						boolean correctEnter;
											
						do
						{	
							correctEnter = true;
							
							int feature = catchNumberFormatExceptionInt();
									
							switch (feature)
							{
								case 1:
									endOperation = true;
												
									if (valuable instanceof Bling)
									{	
										menuBling((Bling)valuable);
									}
											
									else if (valuable instanceof TechnicalDevice)
									{
										menuTechnicalDevice((TechnicalDevice)valuable);
									}
													
									else if (valuable instanceof BlockOfShares)
									{
										menuBlockOfShares((BlockOfShares)valuable);
									}
					
									break;
								case 2:
									break;
								case 3:	
									System.out.println("Operationen avbröts.\n");
									endOperation = true;
									break;
								default:
									System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 3.\n");
									correctEnter = false;
									break;
							}
						}
						while (correctEnter != true);		

						break;	
					}	
				}	

				if (numbersFound == 0)
				{
					System.out.println("Det finns inget värdeföremål med det ID-numret registrerat" 
											+ " i systemet. Välj ett alternativ nedan.\n"
											+ "    1 = Försök igen\n"
											+ "    2 = Sök på värdeföremålsnamn\n "
											+ "    3 = Avbryt\n");
								
					boolean correctEnter;
								
					do
					{	
						int feature = catchNumberFormatExceptionInt();
									
						correctEnter = true;
									
						switch (feature)
						{
							case 1:
								break;
							case 2:	
								endOperation = true;
								searchOwnerByName();
								break;
							case 3:
								System.out.println("Operationen avbröts.\n");
								endOperation = true;
								break;
							default:
								System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 3");
								correctEnter = false;
								break;
						}
					}
					while (correctEnter != true);
				}
							
			}
			while(endOperation != true);
		}
				
//______________________________________________________________________________________________________________		
		public void searchValuableByName()
		{
			boolean endOperation = false;
			
			do 
			{	
				System.out.print("Ange namn på värdeföremålet du vill visa: ");

				String valuableNameRequest = keyboard.nextLine();
				System.out.println();
				
				int namesFound = 0;
				
				for (Valuable valuable : allValuables)
				{
					if (valuable.getValuableName().equalsIgnoreCase(valuableNameRequest))
					{
						namesFound++;
					}
				}
			
				if (namesFound == 0)
				{
					System.out.println("Det finns inget värdeföremål med det namnet registrerad" 
										+ " i systemet. Vill du göra ett nytt försök?\n"
										+ "    1 = Ja\n"
										+ "    2 = Avbryt\n");
					
					boolean correctEnter = false;
					
					do
					{
						int feature = catchNumberFormatExceptionInt();
						
						switch (feature)
						{
							case 1:
								correctEnter = true;
								break;
							case 2:
								System.out.println("Operationen avbröts.\n");
								correctEnter = true;
								endOperation = true;
								break;
							default:
								System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 2.\n");
								break;
						}
					}
					while (correctEnter != true);

				}
				
				else if (namesFound == 1)
				{
					
					for (Valuable valuable : allValuables)
					{
						if (valuable.getValuableName().equalsIgnoreCase(valuableNameRequest))
						{	
							valuable.toString();
							
							endOperation = true;
							
							if (valuable instanceof Bling)
							{	
								menuBling((Bling)valuable);
							}
							
							else if (valuable instanceof TechnicalDevice)
							{
								menuTechnicalDevice((TechnicalDevice)valuable);
							}
							
							else if (valuable instanceof BlockOfShares)
							{
								menuBlockOfShares((BlockOfShares)valuable);
							}
							
							break;
						}	
					}
				}	
		
				else
				{
					System.out.println("Det finns flera värdeföremål med det namnet registrerade " +
							"i systemet. Välj ett alternativ nedan.\n "
							+ "    1 = Försök igen\n"
							+ "    2 = Sök på värdeföremåls-ID\n"
							+ "    3 = Avbryt\n");
					
					boolean correctEnter;
					
					do
					{	
						int feature = catchNumberFormatExceptionInt();
						
						correctEnter = true;
						
						switch (feature)
						{
							case 1:
								break;
							case 2:
								endOperation = true;
								searchValuableByID();
								break;
							case 3:
								System.out.println("Operationen avbröts.\n");
								endOperation = true;
								break;
							default:
								System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 3.");
								correctEnter = false;
								break;
						}
					}
					while (correctEnter != true);
				}	
						
			}
			while (endOperation != true);
		}
		
//______________________________________________________________________________________________________________		
		
}		

//______________________________________________________________________________________________________________
	// Unfinished method for removing owner. It works except for the for loop that creates
	//a run-time error of type "checkForComodification()" that I have not found a solution to:
	
	//public void removeOwner(Owner owner)
	//{
	//	System.out.println("Är du säker på att du vill radera ägaren "
	//				+ owner.getOwnerName() + " med samtliga dess tillgångar ur systemet? Åtgärden går" +
	//						" inte att ångra.\n"
	//				+ "    1 = Ja\n"
	//				+ "    2 = Avbryt\n");
	//	
	//	boolean correctEnter;
	//	
	//	do 
	//	{	
	//		int feature = catchNumberFormatExceptionInt();
	//		
	//		correctEnter = true;
	//	
	//		switch (feature)
	//		{
	//			case 1:		
	//				for (Valuable valuable : allValuables)
	//				{
	//					if (valuable.getOwnerID() == owner.getOwnerID())
	//					{
	//						allValuables.remove(valuable);
	//					}
	//				}
	//				
	//
	//				owner.clearAllValuables();
	//				allOwners.remove(owner);
	//				
	//				System.out.println("Ägaren " + owner.getOwnerName() 
	//						+ " är nu raderad ur systemet.\n");
	//				break;
	//			case 2:
	//				System.out.println("Operationen avbröts.\n");
	//				break;
	//			default:
	//				System.out.println("Felaktig inmatning, skriv in en siffra mellan 1 och 2.\n");
	//				correctEnter = false;
	//				break;
	//		}	
	//	}
	//	while (correctEnter != true);
	//}
	//
		
		