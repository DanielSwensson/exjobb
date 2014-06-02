package value.register;

import java.util.*;


//Jakob Elldin M�rtensson
//DSV, Stockholm University
//Inlupp 2 f�r OOP


/*
Jag har valt ett relativt dumt s�tt att l�sa denna uppgift ser jag nu i efterhand
jag hade kunnat ha items listan som en attribut hos person och d�rmed kunnat kolla i listan med personer efter r�tt namn och d�refter letat efter items i den listan och adderat, detta hade dock inte gjort person s� generel
eventuellt hade jag kunnat anv�nda en map d�r personens namn hade varit en nyckel och listan med items varit value, och placerat denna map/table i denna class, vilket fortfarande l�tit person vara generell

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
				
				//s�tter inten f�r switchen som kommer efter, m�ste docks se till att kommandon �r korrekta f�rst!
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

				switch(cmdint){ //anv�nder inten fr�n f�rra ifsatsen
				
				case 1:  addPerson(people);//l�gger till en person
			 		break;
			 	case 2: addItem(items);//l�gger till ett item
			 		break;
			 	case 3: showAll(people, items);//visar alla personer och deras v�rde
			 		break;
			 	case 4: showName(people, items);//visar ett namn och dess �godelar
			 		break;
			 	case 5: showRichest(people, items);//visar rikaste
			 		break;
			 	case 6: stockMarketCrash(items);//crashar b�rsen
			 		break;
			 	case 9: printCommands();//metod f�r show commands
			 		break;
			 	case 0: System.exit(0); //st�nger av programmet
			 		break;
			 	case -1: System.out.println("No command named "+command+" found. Please try again or type 'help' for the command list.");
			 		break; //skriver ut om det �r fel
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
			p.add(newperson); //l�gga till personen i listan
			System.out.println("Added "+pname+".\n- - - - - - - - - - - -");
		}//end if found == false
		else{
			System.out.println("Person already exists!"); //felmeddelande
			//denna del kan tas bort om man vill att anv�ndaren ska komma ut till menyn igen ist�llet
			addPerson(p); //starta om metoden, skriva nytt namn etcetc
		}//end else
	}//end addperson
	
	
	public void printCommands(){
		//prints commands till systemet
		//f�r att det ska bli lite mer l�ttl�st i konstruktorn
		//samt f�r att kunna anropa dem igen n�r det beh�vs
		
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
		//�gare (string)
		//typ (smycke/aktie/apparat) skapa den sortens item, dvs m�ste skicka med olika saker och ha olika new, samt en egen l�gga till i listan
		//namn (string)
		//om smycke, be om antal �delstenar (int) samt om gold/silver(bool, true=gold)
		//om aktie, be om antal(int) samt pris (float)
		//om apparat, be om ink�pspris(float) och slitage (double 1-10) 
		
		System.out.print("Who owns this object? ");
		String ownername = scan.nextLine();	
		int type = checkType(); //fr�gar efter item sort
		//k�rde med metod h�r ist�llet f�r en stor do while loop, d� det blev lite mindre "messy" kod h�r d�
		System.out.print("Name of the item? ");		
		String itemname = scan.nextLine();		
		
		//skulle kanske kunnat ha resterande stycken i en metod ocks�, men fick bli s�h�r
		if (type == 1){ //om smycke
			int noofstones = jewelNumberPrompt(); //metod som skapar prompt f�r antal stenar
			String material = jewelMaterialPrompt(); //metod som skapar prompt f�r material
			Jewelry newjewel = new Jewelry(ownername, itemname, noofstones, material);//skapa smycke
			i.add(newjewel);//l�gg till smycke
			System.out.println("Added item: "+newjewel+"\n- - - - - - - - - - - -");
		}//end if type == 1 (jewelry)
		else if (type == 2){ //om share
			int noofshares = shareNumberPrompt(); //fr�ga efter antal
			float sharevalue = shareValuePrompt();//fr�ga efter v�rde / aktie
			Share newshare = new Share(ownername, itemname, noofshares, sharevalue);//skapa aktie
			i.add(newshare);//l�gg till aktie
			System.out.println("Added item: "+newshare+"\n- - - - - - - - - - - -");	
		}//end if type == 2 (share)
		else if (type == 3){//om elektronik
			float price = devicePricePrompt(); //fr�ga pris
			float wear = deviceWearPrompt();//fr�ga wear
			Device newdevice = new Device(ownername, itemname, price, wear); //skapa till device
			i.add(newdevice); //l�gga till device
			System.out.println("Added item: "+newdevice+"\n- - - - - - - - - - - -");
		}//end if type == 3	(device)
	}//end addItem
	
	
	private int shareNumberPrompt(){
		//fr�gar om antal aktier
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
		//fr�gar om v�rdet p� aktier
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
		//fr�gar om antal stenar
		
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
		//fr�gar om material p� smycke
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
		//prompts wear, samt kollar att det �r inom r�tt skala
		float wear;
		try {
			do { //do loop smidigare �n metod.
				System.out.print("Wear? Scale 0 (destroyed) to 10 (perfect condition) " ); //float, kan �ven vara destroyed och inte v�rd ngt
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
		//hj�lpmetod f�r att hitta r�tt typ
		//kollar vilken sorts typ av f�rem�l det �r
		//kan byggas ut om det skulle beh�vas..
		int itemtype = 0; //initerar itemtype till false f�r do-while loopen
		
		do{
			//Scanner tc = new Scanner(System.in);
			System.out.print("Type: Jewelry, Share or Device? ");
			String t = scan.nextLine();
			//kolla med ifsats h�r sedan f�r att skapa objekt
			if (t.equals("jewelry") || t.equals("Jewelry") || t.equals("JEWELRY")){
				itemtype = 1;
			}//end if jewelry
			else if (t.equals("share") || t.equals("Share") || t.equals("SHARE")){
				itemtype = 2;
			}//end if share
			else if (t.equals("device") || t.equals("Device") || t.equals("DEVICE")){
				itemtype = 3;			
			}//end if device
			//template f�r att l�gga till fler items
			/*else if (t.equals("lowercase") || t.equals("Normal") || t.equals("UPPERCASE"))
			 	itemtype = n+1; */
			else{
				System.out.println("Type does not exist, please input an existing type! ");
				itemtype = checkType(); //forts�tter att fr�ga tills anv�ndaren g�r r�tt
			}//end else
		}//end do
		while (itemtype == 0 || itemtype < 0 || itemtype > 3);//f�r �ka countern om fler sorters items l�ggs till		
		return itemtype;
	}//end checktype
	
	
	public void showAll(List<Person> p, List<Item> i){
		//g� igenom listan f�r alla namn
		//f�r varje namn g� igenom listan f�r items och hitta deras items
		//summera alla items v�rde f�r den �garen (addTotalValue(float);) m�ste nollst�lla (setTotalValue(0)) f�rsta g�ngen man g�r in p� anv�ndaren dock f�r att inte r�ka g�ra fel
		//skriv ut namn + v�rde bredvid varandra		
		for (Person pers: p){
			pers.calcTotalValue(pers.getName(), i);
			System.out.println(pers);	
		}//end for pers in p
		System.out.println("- - - - - - - - - - - -"); //snygglines		
	}//end showall
	
	
	
	public void showRichest(List<Person> p, List<Item> i){
		//g� igenom listan med alla namn
		//f�r varje namn i listan nollst�lla deras value en g�ng (innan resten) (setTotalValue(0));
		//g� igenom listan med items och hitta de med samma namn (if name=inputname)
		//addera varje items v�rde via addTotalValue(getValue())
		//g� igenom listan med alla namn igen och hitta den med h�gst getTotalValue()
		//printa dennes namn och total value
		//samt g� igenom itemlistan igen och hitta alla dennes items samt printa dessa		
		
		for (Person pers: p){ //r�knar allas totalv�rde
			pers.calcTotalValue(pers.getName(), i);
		}//end for pers in p
		
		Person richest = new Person(null, 0) ; //ref till den rikaste
		
		for (Person pers: p){  //linj�rs�kning av listan efter st�rsta v�rdet
			//g�r igenom listan en g�ng, effektivt antar jag, kan inte komma p� ett smartare s�tt
			if (pers.getTotalValue() > richest.getTotalValue()) //om tv� har samma v�rde, blir den som d�k upp f�rst den som blir richest, detta d� programmet endast ska visa EN rikaste, d�rmed blir det den senaste inlagda personen (s�vida inte listan sorteras) som f�r prio
				richest = pers; //s�tter richest till pers s� att man kan s�lla bort de med mindre value f�r n�sta post etc.
		}//end for 
		
		System.out.println("Richest person: "+ richest); //skriver ut personen
		richest.listItems(richest, i); //skriver ut listan med items som denne �ger
		System.out.println("- - - - - - - - - - - -"); //snyggheten sj�lvt
	}//end showrichest
	
	
	
	public void showName(List<Person> p, List<Item> i){
		//promptar efter namn
		//leta genom listan efter en person med namn == inputname (namn �r unika)
		//om det inte finns n�gon i listan, printa ett felmeddelande
		//samt g� igenom itemlistan igen och hitta alla dennes items
		//printa namn + totalvalue + alla items
		

		System.out.print("Type the name of the person you are looking for: ");
		String inname = scan.nextLine();
		for (Person pers: p){
			if (inname.equals(pers.getName())){
				pers.calcTotalValue(pers.getName(), i); //r�kna ut totalv�rdet
				System.out.println(pers);
				pers.listItems(pers, i);
				System.out.println("- - - - - - - - - - - -");//snyggaste skiten evar	
				return;
			}//if name == name
		}//end for pers in p
		System.out.println("Could not find a person named "+inname+". ");
				
	}//end showname
	
	
	
	
	public void stockMarketCrash(List<Item> i){
		//g�r alla existerande akter v�rdel�sa (genom att s�tta price till 0(setPrice(0))) 
		//g�r igenom item listan och �ndrar alla shares price till 0
				
		for (Item it: i) {
			if (it instanceof Share) //om item �r en share
				((Share)it).setPrice(0); //casta item som share och s�tt pris till 0
		}//end for item in i
		System.out.println("Stock market crashed! Shares are worth zero. New shares may have value. \n- - - - - - - - - - - -");
	}//end stock market crash
	
	
	

	public static void main (String[]args){
		
		new ValueCalculator(); //startar konstruktorn f�r valuecalculatorn
		
	}//end main
	
}//end valuecalc class
