import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    private static final boolean String = false;
	Scanner keyboard;	
    ArrayList<Individual> individuallist;

    public Register(){
    	keyboard = new Scanner(System.in);	
        individuallist = new ArrayList<Individual>();

        while(true){ 
            val();
            try{
            switch (Integer.parseInt(keyboard.nextLine())){
                case 1:
                    createIndividual();
                break;
                case 2:

                    int type = getItemType();

                    Individual individual = determineIndividual();

                    switch (type)
                    {
                        case 1:
                        
                            Jewelery jewelery = createJewelery();
                            AddToIndividual(individual, jewelery);
                            break;
                        case 2:						
                            Stock stock = createStock();
                            AddToIndividual(individual, stock);
                        break;
                        
                        case 3: Appliance appliance = createAppliance();
                        		AddToIndividual(individual, appliance);
                        		break;
                    }
                case 3:
                    listIndividual();
                    break;
                case 4:
                    getRichestIndividual();
                    break;
                case 5:
                    getSpecificIndividual();
                    break;
                case 6: 
                    craschStock();
                    break;
                case 7:
                    System.exit(0);
                   
            }
            }
            catch(NumberFormatException e){
            	System.out.println("Type in a number");
            }
        }
    }

    public void val() {
        System.out.println();
        System.out.print("Hello! What do you want to do? Choose a commando between 1 - 7.\n" + "1 = Create a new individual \n" + "2 = Create a new item\n" + "3 = Show all individuals\n" + "4 = Shows the richest individual\n"+ "5 = Show a specific individual\n" + "6 = Stock market crash\n" + "7 = Quit\n" + "What do you want to do: ");
    }

    public int getItemType(){
        System.out.println("Submit type: \n 1. Add a jewelery \n 2. Add a stock \n 3. Add an appliance");
        String type = keyboard.nextLine();

        return Integer.parseInt(type);
    }

    public void createIndividual(){
        System.out.print("Type in the name of the individual: ");
        String name = keyboard.nextLine(); 
     
	Boolean nameTaken = false;
	
        for (int i = 0; i<individuallist.size(); i++){

        	Individual individualCurrentlyInLoop = individuallist.get(i);
             if (name.equals(individualCurrentlyInLoop.getName())) {
           	nameTaken = true;
             }
	}

	if(nameTaken == true){
		System.out.println("The individual with the name "+name+" already exists.");
	}
	else{
		individuallist.add(new Individual(name));	
	}
}


    public Jewelery createJewelery(){
        
    	
    	System.out.print("Type in the type of jewelery you wish to submit: ");
    	String name = keyboard.nextLine();
    	
        System.out.print("Type in the amout of jewelerys: ");
        String jewels = keyboard.nextLine();

        System.out.print("1. Gold \n2. Silver \nSubmit type:");
        String type = keyboard.nextLine();
        
        return new Jewelery(Integer.parseInt(type), Integer.parseInt(jewels), name); 
        
    	
    	}

    public Stock createStock(){
        System.out.print("Type in the name of the stock: ");
        String name = keyboard.nextLine();

        System.out.print("Type in the amout of stocks: ");
        String amount = keyboard.nextLine();

        System.out.print("Type in the value of each stock: ");
        String price = keyboard.nextLine();

        return new Stock(name, Integer.parseInt(amount), Integer.parseInt(price));
    }

    	public Appliance createAppliance(){
    		
    		System.out.print("Type in what kind of appliance it is: ");
            String name = keyboard.nextLine();
            
            System.out.print("Type in the price of the appliance: ");
            String price = keyboard.nextLine(); 
            
            System.out.print("Type in the wear and tear to the appliance, between 1-10 (10= no wear and tear): ");
            String slitage = keyboard.nextLine();
            return new Appliance(name, Integer.parseInt(price), Integer.parseInt(slitage));
    		}
            
            
    	
    	public void listIndividual(){
        if(individuallist.size() <= 0){

            System.out.println("There is no individuals."); 
        }
        else{
            System.out.println("The register contains: ");
            for(int i = 0; i < individuallist.size(); i++){
                System.out.print(individuallist.get(i).toString() + " " + individuallist.get(i).getValueOfAssets());
                System.out.println();
            }
        }
    }


    public void AddToIndividual(Individual individual, Item item){
        individual.addAssets(item);
    }

    public Individual determineIndividual(){

        Boolean individualFound = false;

        while(!individualFound){
            System.out.print("To whom does the item belong to?: ");
            String name = keyboard.nextLine();

            for(int i = 0; i < individuallist.size(); i++){	
                if(individuallist.get(i).getName().equals(name)){
                    return individuallist.get(i);
                }
            }
        }

        return individuallist.get(0);
    }

    public void getRichestIndividual(){

        if(individuallist.size() > 0){

            Individual richestIndividual = individuallist.get(0);
            int highestSoFar = 0;

            for(int i = 0; i < individuallist.size(); i++){
                int sum = individuallist.get(i).getValueOfAssets();

                if(sum >= highestSoFar){
                    richestIndividual = individuallist.get(i);
                    highestSoFar = sum;
                }
            }

            System.out.print("The richest is " + (richestIndividual.toString() + " that owns "));
            System.out.println(richestIndividual.getValueOfAssets());
            richestIndividual.listAssets();

        }
        else{
            System.out.println("There is no individuals.");
        }
    }

    public void getSpecificIndividual(){

        System.out.print("Type in the name of the individual: ");
        String name = keyboard.nextLine();

        for (int i = 0; i<individuallist.size(); i++){

            Individual specificIndividual = individuallist.get(i);

            if(name.equals(specificIndividual.getName())) {
                System.out.println(individuallist.get(i).toString());
                individuallist.get(i).listAssets();
                return;
            }
        }
        
        System.out.println("The idividual doesn't exist.");
    }

    public void craschStock(){
        if(individuallist.size() > 0){

            for(int i = 0; i < individuallist.size(); i++){	

                ArrayList<Item> currentIndividualStuff = individuallist.get(i).getAssets();

                for(int j = 0; j < currentIndividualStuff.size(); j++){
                    
                    if(currentIndividualStuff.get(j) instanceof Stock){
                        Stock stock = (Stock)currentIndividualStuff.get(j);
                        stock.setPriceAndMarketValue(0);
                        System.out.println(stock.toString());
                    }
                }
            }
        }
        else{
            System.out.println("There is no individuals."); 
        }

    }

    public static void main (String[] args){
        Register r = new Register();
    }
}