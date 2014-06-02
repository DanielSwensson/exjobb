import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    Scanner keyboard;	
    ArrayList<Person> personlist;

    public Register(){
        keyboard = new Scanner(System.in);	
        personlist = new ArrayList<Person>();

        while(true){ 
            decision();
            try{
            switch (Integer.parseInt(keyboard.nextLine())){
                case 1:
                    createPerson();
                break;
                case 2:

                    int type = getItemType();

                    Person person = determinePerson();

                    switch (type)
                    {
                        case 1:
                        
                            Smycke smycke = createSmycke();
                            AddToPerson(person, smycke);
                            break;
                        case 2:						
                            Aktie aktie = createAktie();
                            AddToPerson(person, aktie);
                        break;
                        
                        case 3: Apparat apparat = createApparat();
                        		AddToPerson(person, apparat);
                    
                    }

                break;
                case 3:
                    listPeople();
                    break;
                case 4:
                    getRichestPerson();
                    break;
                case 5:
                    getSpecificPerson();
                    break;
                case 6: 
                    craschStock();
                    break;
                case 7:
                    System.exit(0);
            
            }}
            catch(NumberFormatException e){
            	System.out.println("Skriv en siffra");
            }
        }
    }

    public void decision() {
        System.out.println();
        System.out.print("Hejsan, vad vill du gšra? VŠlj ett kommando av 1 - 7.\n" + "1 = Skapa en ny person \n" + "2 = Skapa en ny pryl\n" + "3 = Visa alla personer\n" + "4 = Visa rikaste person\n"+ "5 = Visa viss person\n" + "6 = Bšrskrasch\n" + "7 = Avsluta\n" + "Vad vill du gšra?: ");
    }

    public int getItemType(){
        System.out.println("Ange typ: \n 1. LŠgg till ett smycke \n 2. LŠgg till en aktie \n 3. LŠgg till en apparat");
        String type = keyboard.nextLine();

        return Integer.parseInt(type);
    }

    public void createPerson(){
        System.out.print("Ange personens namn: ");
        String name = keyboard.nextLine(); 
        
	Boolean nameTaken = false;

        for (int i = 0; i<personlist.size(); i++){

            Person personCurrentlyInLoop = personlist.get(i);
             if (name.equals(personCurrentlyInLoop.getName())) {
           	nameTaken = true;
             }
	}

	if(nameTaken == true){
		System.out.println("En person med namnet "+name+" finns redan.");
	}
	else{
		personlist.add(new Person(name));	
	}
}


    public Smycke createSmycke(){
        
    	
    	System.out.print("Ange typ av smycke: ");
    	String name = keyboard.nextLine();
    	
        System.out.print("Ange antal juveler: ");
        String jewels = keyboard.nextLine();

        System.out.print("1. Guld \n2. Silver \nAnge typ:");
        String type = keyboard.nextLine();
        
        return new Smycke(name, Integer.parseInt(jewels), Integer.parseInt(type)); 
        
    	
    	}

    public Aktie createAktie(){
        System.out.print("Ange aktiens namn: ");
        String name = keyboard.nextLine();

        System.out.print("Ange antal aktier: ");
        String amount = keyboard.nextLine();

        System.out.print("Ange hur mycket varje aktie Šr vŠrd: ");
        String price = keyboard.nextLine();

        return new Aktie(name, Integer.parseInt(amount), Integer.parseInt(price));
    }

    	public Apparat createApparat(){
    		
    		System.out.print("Ange vilken typ av apparat: ");
            String name = keyboard.nextLine();
            
            System.out.print("Ange priset på apparaten: ");
            String price = keyboard.nextLine(); 
            
            System.out.print("Ange slitaget på apparaten, mellan 1-10 (10=inget slitage): ");
            String slitage = keyboard.nextLine();
            return new Apparat(name, Integer.parseInt(price), Integer.parseInt(slitage));
    		}
            
            
    	
    	public void listPeople(){
        if(personlist.size() <= 0){

            System.out.println("Det finns inga personer"); 
        }
        else{
            System.out.println("I registret finns: ");
            for(int i = 0; i < personlist.size(); i++){
                System.out.print(personlist.get(i).toString() + " " + personlist.get(i).getValueOfStuff());
                System.out.println();
            }
        }
    }


    public void AddToPerson(Person person, Pryl item){
        person.addStuff(item);
    }

    public Person determinePerson(){

        Boolean personFound = false;

        while(!personFound){
            System.out.print("Vem tillhšr prylen?: ");
            String name = keyboard.nextLine();

            for(int i = 0; i < personlist.size(); i++){	
                if(personlist.get(i).getName().equals(name)){
                    return personlist.get(i);
                }
            }
        }

        return personlist.get(0);
    }

    public void getRichestPerson(){

        if(personlist.size() > 0){

            Person richestPerson = personlist.get(0);
            int highestSoFar = 0;

            for(int i = 0; i < personlist.size(); i++){
                int sum = personlist.get(i).getValueOfStuff();

                if(sum >= highestSoFar){
                    richestPerson = personlist.get(i);
                    highestSoFar = sum;
                }
            }

            System.out.print("Rikast Šr " + (richestPerson.toString() + " som sammanlagt Šger "));
            System.out.println(richestPerson.getValueOfStuff());
            richestPerson.listStuff();

        }
        else{
            System.out.println("Det finns inga personer");
        }
    }

    public void getSpecificPerson(){

        System.out.print("Ange personens namn: ");
        String name = keyboard.nextLine();

        for (int i = 0; i<personlist.size(); i++){

            Person specificPerson = personlist.get(i);

            if(name.equals(specificPerson.getName())) {
                System.out.println(personlist.get(i).toString());
                personlist.get(i).listStuff();
                return;
            }
        }
        
        System.out.println("Personen fanns inte");
    }

    public void craschStock(){
        if(personlist.size() > 0){

            for(int i = 0; i < personlist.size(); i++){	

                ArrayList<Pryl> currentPersonStuff = personlist.get(i).getStuff();

                for(int j = 0; j < currentPersonStuff.size(); j++){
                    
                    if(currentPersonStuff.get(j) instanceof Aktie){
                        Aktie stock = (Aktie)currentPersonStuff.get(j);
                        stock.setPriceAndMarketValue(0);
                        System.out.println(stock.toString());
                    }
                }
            }
        }
        else{
            System.out.println("Det finns inga personer."); 
        }

    }

    public static void main (String[] args){
        Register r = new Register();
    }
}