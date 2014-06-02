package value.register;

import java.util.*;


//Jakob Elldin Mårtensson
//DSV, Stockholm University
//Inlupp 2 för OOP


/*
Jag har valt ett relativt dumt sätt att lösa denna uppgift ser jag nu i efterhand
jag hade kunnat ha items listan som en attribut hos person och därmed kunnat kolla i listan med personer efter rätt namn och därefter letat efter items i den listan och adderat, detta hade dock inte gjort person så generel
eventuellt hade jag kunnat använda en map där personens namn hade varit en nyckel och listan med items varit value, och placerat denna map/table i denna class, vilket fortfarande låtit person vara generell

*/



public class ValueCalculator {

	public Scanner scan;
	
	public ValueCalculator () {
		
		ArrayList<Person> people = new ArrayList<Person>();
		ArrayList<Item> items = new ArrayList<Item>();
		
		scan = new Scanner(System.in);
		//commandoPrompt();
		
		System.out.println("WELCOME TO THE THE VALUE-TRON! \n Your one source of calculating values of items belonging to you, your friends, rivals, family or anyone!\n Use the command prompt below to work the program.\n");
		printCommands();
		
		for (;;){
			int cmdint= -1;				
				//dags att ta commando 
				String command = scan.nextLine();
				
				//sätter inten för switchen som kommer efter, måste docks se till att kommandon är korrekta först!
				if (command.equals("1") || command.equals("one") || command.equals("ONE") || command.equals("One") || command.equals("ap") || command.equals("Ap")  || command.equals("aP") || command.equals("AP") || command.equals("addp") || command.equals("addP") || command.equals("Addp") || command.equals("AddP") || command.equals("ADDP") || command.equals("person") || command.equals("Person") || command.equals("PERSON") || command.equals("addPerson") || command.equals("AddPerson") || command.equals("Addperson") || command.equals("addperson") || command.equals("ADDPERSON")){
					cmdint = 1; 
					}//end if 1
				else if (command.equals("2") || command.equals("two") || command.equals("Two") || command.equals("TWO") || command.equals("ai") || command.equals("Ai")  || command.equals("aI") || command.equals("AI") || command.equals("addi") || command.equals("addI") || command.equals("Addi") ||  command.equals("AddI") ||command.equals("ADDI") || command.equals("item") || command.equals("Item") || command.equals("ITEM") || command.equals("addItem") || command.equals("AddItem") || command.equals("Additem") || command.equals("additem") || command.equals("ADDITEM")){
					cmdint = 2; 
					}//end if 2
				else if (command.equals("3") || command.equals("three") || command.equals("Three") || command.equals("THREE") || command.equals("sa") || command.equals("Sa")  || command.equals("sA") || command.equals("SA") || command.equals("showa") || command.equals("showA") || command.equals("Showa") || command.equals("ShowA") || command.equals("SHOWA") || command.equals("all") || command.equals("All") || command.equals("ALL") || command.equals("showAll") || command.equals("ShowAll") || command.equals("Showall") || command.equals("showall") || command.equals("SHOWALL")){	
					cmdint = 3;
					}//end if 3 
				else if (command.equals("4") || command.equals("four") || command.equals("Four") || command.equals("FOUR") || command.equals("sn") || command.equals("Sn")  || command.equals("sN") || command.equals("SN") || command.equals("shown") || command.equals("showN") || command.equals("Shown") ||  command.equals("ShowN") ||command.equals("SHOWN") || command.equals("name") || command.equals("Name") || command.equals("NAME") || command.equals("showName") || command.equals("ShowName") || command.equals("Showname") || command.equals("showname") || command.equals("SHOWNAME")){
					cmdint = 4; 
					}//end if 4
				else if (command.equals("5") || command.equals("five") || command.equals("Five") || command.equals("FIVE") || command.equals("sr") || command.equals("Sr")  || command.equals("sR") || command.equals("SR") || command.equals("showr") || command.equals("showR") || command.equals("Showr") ||  command.equals("ShowR") ||command.equals("SHOWR") || command.equals("rich") || command.equals("Rich") || command.equals("RICH") || command.equals("showRich") || command.equals("ShowRich") || command.equals("Showrich") || command.equals("showrich") || command.equals("SHOWRICH")){
					cmdint = 5; 
					}//end if 5
				else if (command.equals("6") || command.equals("six") || command.equals("Six") || command.equals("SIX") || command.equals("smc") || command.equals("Smc")  || command.equals("sMc")  || command.equals("smC")  || command.equals("SmC")  || command.equals("SMc")  || command.equals("sMC")  || command.equals("SMC") || command.equals("smcrash") || command.equals("smCrash") || command.equals("Smcrash") ||  command.equals("SmCrash") ||command.equals("SMCRASH") || command.equals("crash") || command.equals("Crash") || command.equals("CRASH") || command.equals("stockmarketcrash") || command.equals("stockMarketcrash")  || command.equals("Stockmarketcrash") || command.equals("stockmarketCrash") || command.equals("StockMarketcrash") || command.equals("stockMarketCrash") || command.equals("StockmarketCrash") || command.equals("StockMarketCrash") || command.equals("STOCKMARKETCRASH")){
					cmdint = 6;
					}//end if 6 
				else if (command.equals("9") || command.equals("nine") || command.equals("Nine") || command.equals("NINE") || command.equals("cmd") || command.equals("Cmd") || command.equals("cMd") || command.equals("cmD") || command.equals("CMd") || command.equals("CmD") || command.equals("cMD") || command.equals("CMD") || command.equals("help") || command.equals("Help") || command.equals("HELP") || command.equals("HELP!") || command.equals("display") || command.equals("Display") || command.equals("DISPLAY") || command.equals("commands") || command.equals("Commands") || command.equals("COMMANDS") || command.equals("d") || command.equals("D") || command.equals("h") || command.equals("H") || command.equals("c") || command.equals("C")){
					cmdint = 9;
					}//end if 9 
				else if (command.equals("0") || command.equals("zero") || command.equals("Zero") || command.equals("ZERO") || command.equals("q") || command.equals("Q") || command.equals("e") || command.equals("E") || command.equals("quit") || command.equals("Quit") || command.equals("QUIT") || command.equals("exit") || command.equals("Exit") || command.equals("EXIT")){
					cmdint = 0;
					}//end if 0 
				else {
					cmdint = -1;
					}//end else

				switch(cmdint){ //använder inten från förra ifsatsen
				
				case 1:  addPerson(people);//lägger till en person
			 		break;
			 	case 2: addItem(items);//lägger till ett item
			 		break;
			 	case 3: showAll(people, items);//visar alla personer och deras värde
			 		break;
			 	case 4: showName(people, items);//visar ett namn och dess ögodelar
			 		break;
			 	case 5: showRichest(people, items);//visar rikaste
			 		break;
			 	case 6: stockMarketCrash(items);//crashar börsen
			 		break;
			 	case 9: printCommands();//metod för show commands
			 		break;
			 	case 0: System.exit(0); //stänger av programmet
			 		break;
			 	case -1: System.out.println("No command named "+command+" found. Please try again or type 'help' for the command list.");
			 		break; //skriver ut om det är fel
			 	default: System.out.println("No command named "+command+" found. Please try again or type 'help' for the command list.");
				}//end switch
		}//END FOR EVER
		

	}//end konstruktor
	
	
	public void addPerson(ArrayList<Person> p){
		//adds a person with a UNIQUE name to list: people
		//if name already exist, promt a new name
		
		System.out.print("Please type the name of the new person: ");
		String pname = scan.nextLine();
		boolean found = false; //checker om namnet finns
		for (Person i: p){
			if (i.getName().equals(pname)){
				found = true;				
			}//end if i.name==pname
		}//end for person i: p
		if (found == false){		
			Person newperson = new Person(pname); //skapa personen
			p.add(newperson); //lägga till personen i listan
			System.out.println("Added "+pname+".\n- - - - - - - - - - - -");
		}//end if found == false
		else{
			System.out.println("Person already exists!"); //felmeddelande
			//denna del kan tas bort om man vill att användaren ska komma ut till menyn igen istället
			addPerson(p); //starta om metoden, skriva nytt namn etcetc
		}//end else
	}//end addperson
	
	
	public void printCommands(){
		//prints commands till systemet
		//för att det ska bli lite mer lättläst i konstruktorn
		//samt för att kunna anropa dem igen när det behövs
		
		System.out.println("Commands ");
		System.out.println("1. Add person. Adds a person (commands: ap, addp, person & addPerson)");
		System.out.println("2. Add item. Adds an item to a person (commands: ai, addi, item & addItem)");
		System.out.println("3. Show all. Shows all owners and their added value (commands: sa, showa, all & showAll)");
		System.out.println("4. Show by name. Shows a person and their belonings by name (commands: sn, shown, name & showName)");
		System.out.println("5. Show richest. Adds a person (commands: sr, showr, rich & showrich");
		System.out.println("6. Stock market crash. Crashes the market, resulting in useless shares (commands: smc, smcrash, crash & stockMarketCrash)");
		System.out.println("9. Display commands. This list of commands (commands: h, d, c, help, display, commands, cmd)");
		System.out.println("0. Quit. Exits the program (commands: q, e, quit & exit");
		System.out.print("Insert command: ");
	}//end printCommands
	
	
	public void addItem(List<Item> i){
		//query om itemets attributer:
		//Ägare (string)
		//typ (smycke/aktie/apparat) skapa den sortens item, dvs måste skicka med olika saker och ha olika new, samt en egen lägga till i listan
		//namn (string)
		//om smycke, be om antal ädelstenar (int) samt om gold/silver(bool, true=gold)
		//om aktie, be om antal(int) samt pris (float)
		//om apparat, be om inköpspris(float) och slitage (double 1-10) 
		
		System.out.print("Who owns this object? ");
		String ownername = scan.nextLine();	
		int type = checkType(); //frågar efter item sort
		//körde med metod här istället för en stor do while loop, då det blev lite mindre "messy" kod här då
		System.out.print("Name of the item? ");		
		String itemname = scan.nextLine();		
		
		//skulle kanske kunnat ha resterande stycken i en metod också, men fick bli såhär
		if (type == 1){ //om smycke
			int noofstones = jewelNumberPrompt(); //metod som skapar prompt för antal stenar
			String material = jewelMaterialPrompt(); //metod som skapar prompt för material
			Jewelry newjewel = new Jewelry(ownername, itemname, noofstones, material);//skapa smycke
			i.add(newjewel);//lägg till smycke
			System.out.println("Added item: "+newjewel+"\n- - - - - - - - - - - -");
		}//end if type == 1 (jewelry)
		else if (type == 2){ //om share
			int noofshares = shareNumberPrompt(); //fråga efter antal
			float sharevalue = shareValuePrompt();//fråga efter värde / aktie
			Share newshare = new Share(ownername, itemname, noofshares, sharevalue);//skapa aktie
			i.add(newshare);//lägg till aktie
			System.out.println("Added item: "+newshare+"\n- - - - - - - - - - - -");	
		}//end if type == 2 (share)
		else if (type == 3){//om elektronik
			float price = devicePricePrompt(); //fråga pris
			float wear = deviceWearPrompt();//fråga wear
			Device newdevice = new Device(ownername, itemname, price, wear); //skapa till device
			i.add(newdevice); //lägga till device
			System.out.println("Added item: "+newdevice+"\n- - - - - - - - - - - -");
		}//end if type == 3	(device)
	}//end addItem
	
	
	private int shareNumberPrompt(){
		//frågar om antal aktier
		int shares;
		
		try {
			System.out.print("Number of shares? ");
			shares = Integer.parseInt(scan.nextLine());
			return shares;
		}//end try
		catch (NumberFormatException e){
			System.out.println("Number of shares must be an integer! ");
			shares = shareNumberPrompt();
			return shares;
		}//end catch
	}//end share number prompt
	
	
	private float shareValuePrompt(){
		//frågar om värdet på aktier
		float svalue;
		
		try {		
			System.out.print("Value of each share? ");
			svalue = Float.parseFloat(scan.nextLine());
			return svalue;
		}//end try
		catch (NumberFormatException e){
			System.out.println("Share value must be a number!");
			svalue = shareValuePrompt();
			return svalue;
		}//end catch
	}//end sharevalueprompt
	

	private int jewelNumberPrompt(){ 
		//frågar om antal stenar
		
		int stones;
		try{
			System.out.print("Number of stones? ");
			stones = Integer.parseInt(scan.nextLine());
			return stones;			
		}//end try
		catch (NumberFormatException e){
			System.out.println("Error! Number of stones must be an integer! ");
			stones = jewelNumberPrompt();
			return stones;
		}//end catch
	}//end jewelnumberprompt
	
	
	private String jewelMaterialPrompt(){
		//frågar om material på smycke
		System.out.print("Material? (Gold/Silver/Other) ");
		String mat = scan.nextLine();
		return mat;
	}//end jewelmaterialprompt
	
	
	private float devicePricePrompt(){
		//promptar pris
		float dprice;
		try{
			System.out.print("Original price? "); //float
			dprice = Float.parseFloat(scan.nextLine());
			return dprice;
		}//end try
		catch (NumberFormatException e){
			System.out.println("Price must be a number!");
			dprice = devicePricePrompt();
			return dprice;
		}//end catch
	}//end device price prompt
	
	
	private float deviceWearPrompt(){
		//prompts wear, samt kollar att det är inom rätt skala
		float wear;
		try {
			do { //do loop smidigare än metod.
				System.out.print("Wear? Scale 0 (destroyed) to 10 (perfect condition) " ); //float, kan även vara destroyed och inte värd ngt
				wear = Float.parseFloat(scan.nextLine());
				if (wear > 10 || wear < 0)
					System.out.println("Wear must be in a scale from 0 to 10, please try again. ");
			}//end do
			while (wear > 10 || wear < 0);
			return wear;
		}//end try
		catch (NumberFormatException e){
			System.out.println("Wear must be a number from 0 to 10!");
			wear = deviceWearPrompt();
			return wear;
		}//end catch
	}//end devicewearprompt
	
	
	private int checkType(){
		//hjälpmetod för att hitta rätt typ
		//kollar vilken sorts typ av föremål det är
		//kan byggas ut om det skulle behövas..
		int itemtype = 0; //initerar itemtype till false för do-while loopen
		
		do{
			//Scanner tc = new Scanner(System.in);
			System.out.print("Type: Jewelry, Share or Device? ");
			String t = scan.nextLine();
			//kolla med ifsats här sedan för att skapa objekt
			if (t.equals("jewelry") || t.equals("Jewelry") || t.equals("JEWELRY")){
				itemtype = 1;
			}//end if jewelry
			else if (t.equals("share") || t.equals("Share") || t.equals("SHARE")){
				itemtype = 2;
			}//end if share
			else if (t.equals("device") || t.equals("Device") || t.equals("DEVICE")){
				itemtype = 3;			
			}//end if device
			//template för att lägga till fler items
			/*else if (t.equals("lowercase") || t.equals("Normal") || t.equals("UPPERCASE"))
			 	itemtype = n+1; */
			else{
				System.out.println("Type does not exist, please input an existing type! ");
				itemtype = checkType(); //fortsätter att fråga tills användaren gör rätt
			}//end else
		}//end do
		while (itemtype == 0 || itemtype < 0 || itemtype > 3);//får öka countern om fler sorters items läggs till		
		return itemtype;
	}//end checktype
	
	
	public void showAll(List<Person> p, List<Item> i){
		//gå igenom listan för alla namn
		//för varje namn gå igenom listan för items och hitta deras items
		//summera alla items värde för den ägaren (addTotalValue(float);) måste nollställa (setTotalValue(0)) första gången man går in på användaren dock för att inte råka göra fel
		//skriv ut namn + värde bredvid varandra		
		for (Person pers: p){
			pers.calcTotalValue(pers.getName(), i);
			System.out.println(pers);	
		}//end for pers in p
		System.out.println("- - - - - - - - - - - -"); //snygglines		
	}//end showall
	
	
	
	public void showRichest(List<Person> p, List<Item> i){
		//gå igenom listan med alla namn
		//för varje namn i listan nollställa deras value en gång (innan resten) (setTotalValue(0));
		//gå igenom listan med items och hitta de med samma namn (if name=inputname)
		//addera varje items värde via addTotalValue(getValue())
		//gå igenom listan med alla namn igen och hitta den med högst getTotalValue()
		//printa dennes namn och total value
		//samt gå igenom itemlistan igen och hitta alla dennes items samt printa dessa		
		
		for (Person pers: p){ //räknar allas totalvärde
			pers.calcTotalValue(pers.getName(), i);
		}//end for pers in p
		
		Person richest = new Person(null, 0) ; //ref till den rikaste
		
		for (Person pers: p){  //linjärsökning av listan efter största värdet
			//går igenom listan en gång, effektivt antar jag, kan inte komma på ett smartare sätt
			if (pers.getTotalValue() > richest.getTotalValue()) //om två har samma värde, blir den som dök upp först den som blir richest, detta då programmet endast ska visa EN rikaste, därmed blir det den senaste inlagda personen (såvida inte listan sorteras) som får prio
				richest = pers; //sätter richest till pers så att man kan sålla bort de med mindre value för nästa post etc.
		}//end for 
		
		System.out.println("Richest person: "+ richest); //skriver ut personen
		richest.listItems(richest, i); //skriver ut listan med items som denne äger
		System.out.println("- - - - - - - - - - - -"); //snyggheten självt
	}//end showrichest
	
	
	
	public void showName(List<Person> p, List<Item> i){
		//promptar efter namn
		//leta genom listan efter en person med namn == inputname (namn är unika)
		//om det inte finns någon i listan, printa ett felmeddelande
		//samt gå igenom itemlistan igen och hitta alla dennes items
		//printa namn + totalvalue + alla items
		

		System.out.print("Type the name of the person you are looking for: ");
		String inname = scan.nextLine();
		for (Person pers: p){
			if (inname.equals(pers.getName())){
				pers.calcTotalValue(pers.getName(), i); //räkna ut totalvärdet
				System.out.println(pers);
				pers.listItems(pers, i);
				System.out.println("- - - - - - - - - - - -");//snyggaste skiten evar	
				return;
			}//if name == name
		}//end for pers in p
		System.out.println("Could not find a person named "+inname+". ");
				
	}//end showname
	
	
	
	
	public void stockMarketCrash(List<Item> i){
		//gör alla existerande akter värdelösa (genom att sätta price till 0(setPrice(0))) 
		//går igenom item listan och ändrar alla shares price till 0
				
		for (Item it: i) {
			if (it instanceof Share) //om item är en share
				((Share)it).setPrice(0); //casta item som share och sätt pris till 0
		}//end for item in i
		System.out.println("Stock market crashed! Shares are worth zero. New shares may have value. \n- - - - - - - - - - - -");
	}//end stock market crash
	
	
	

	public static void main (String[]args){
		
		new ValueCalculator(); //startar konstruktorn för valuecalculatorn
		
	}//end main
	
}//end valuecalc class
