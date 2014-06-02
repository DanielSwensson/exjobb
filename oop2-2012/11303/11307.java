import java.util.Scanner;
import java.util.ArrayList;




public class Register
{
	
	Scanner keyboard = new Scanner(System.in);
	
	ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	
	ArrayList<Car> allCars = new ArrayList<Car>();
	
	ArrayList<Plane> allPlanes = new ArrayList<Plane>();
	
	ArrayList<Boat> allBoats = new ArrayList<Boat>();
	
	int moneyEarnedCars;
	int moneyEarnedBoats;
	int moneyEarnedPlanes;
	
	int readInt	(String question){
		
	for	(;;)	{
			
		try	{
			
				System.out.print(question);
			
				int menuChoise = Integer.parseInt(keyboard.nextLine());
			
				return menuChoise;
			
		}
			
		catch	(NumberFormatException e)	{
				
				System.out.print("You must enter a number, please try again.\n");
				
		}		
	}
}
	
	
	
	
	void menu()
	{
		
		System.out.print("\n--MAIN MENU--" +
				"\n____________________________________________________________________________________\n" +
				"[1]	Purchase a new vehicle\n" +
				"[2]	Veiw list of owned vehicles\n" +
				"[3]	Sell a vehicle\n" +
				"[4]	View total amount spent on vehicles\n" +
				"[5]	View total amount earned selling vehicles\n" +
				"[6]	Exit\n" +
				"____________________________________________________________________________________\n");	
	}
	
	
	
	
	void purchaseVehicle()
	{
		int buyingChoice;
		do
		{
			buyingChoice = readInt("\n--PERCHASE VEHICLE--" +
					"\n____________________________________________________________________________________\n" +
					"Select the type of vehilce you wish to purchase\n" +
					"____________________________________________________________________________________\n" +
					"[1]	Car\n" +
					"[2]	Boat\n" +
					"[3]	Plane\n" +
					"____________________________________________________________________________________\n" +
					"Enter your choice here: ");
		
			switch (buyingChoice)	
			{
		
			case 1 : addCar(); break;
			case 2 : addBoat(); break;
			case 3 : addPlane(); break;
			default : System.out.print("\nInvalid choice, please try again.\n");
		
			}	
		
		}	while(buyingChoice != 1 && buyingChoice != 2 && buyingChoice != 3);
	}
	
	
	
	
	void addPlane()
	{
		String brand = null;
		String colour = null;
		int sellingPrice = 0;
		int buyingPrice = 0;
		int buyPlaneChoice;
		int planeColourChoice;
		
		do
		{
			buyPlaneChoice = readInt("\n--ENTER PLANE INFO--\n" +
					"____________________________________________________________________________________\n" +
					"Brand:\n" +
					"[1]	Nova - Price: 7,000,000.00$ - Sell price: 3,500,000.00$\n" +
					"[2]	Geminin Jets  - Price: 10,500,000.00$ - Sell price: 5,250,000.00$\n" +
					"[3]	Falcon - Price: 13,000,000.00$ - Sell price: 6,500,000.00$\n" +
					"____________________________________________________________________________________\n" +
					"Enter your choice here: ");
		
			if (buyPlaneChoice == 1){
			
				brand = "Nova";
				buyingPrice = 7000000;
				sellingPrice = 3500000;
				
			
			}	else if (buyPlaneChoice == 2){
			
				brand = "Geminin Jets";
				buyingPrice = 10500000;
				sellingPrice = 5250000;
				
			
			}	else if (buyPlaneChoice == 3){
			
				brand = "Falcon";
				buyingPrice = 13000000;
				sellingPrice = 6500000;
				
			
			}	else	{
			
				System.out.print("\nInvalid choice, please try again.\n");
			
			}
			
		}	while(buyPlaneChoice != 1 && buyPlaneChoice != 2 && buyPlaneChoice != 3);
		
		do
		{
			planeColourChoice = readInt("\n____________________________________________________________________________________\n" +
					"Colour:\n" +
					"[1]	White\n" +
					"[2]	Red\n" +
					"[3]	Black\n" +
					"____________________________________________________________________________________\n" +
					"Enter your choice here: ");
		
			
			if (planeColourChoice == 1){
				
				colour = "White";
				
			}	else if (planeColourChoice == 2){
				
				colour = "Red";
				
			}	else if (planeColourChoice == 3){
				
				colour = "Black";
				
			}	else	{
				
				System.out.print("\nInvalid choice, please try again.\n");
				
			}
			
		}	while(planeColourChoice!= 1 && planeColourChoice != 2 && planeColourChoice != 3);
		
		System.out.println("\nAdded plane " + brand + " to owned vehicles.");
		
		
		
		Plane plane = new Plane(brand, colour, buyingPrice, sellingPrice);
		
		allVehicles.add(plane);
		allPlanes.add(plane);
		
		
	}
	
	
	
	
	void addBoat()
	{
		
		String brand = null;
		String colour = null;
		int sellingPrice = 0;
		int buyingPrice = 0;
		int buyBoatChoice;
		int boatColourChoice;
		
		do
		{
			buyBoatChoice = readInt("\n--ENTER BOAT INFO--\n" +
				"____________________________________________________________________________________\n" +
				"Brand:\n" +
				"[1]	Robalo - Price: 3,100,000.00$ - Sell price: 1,550,000.00$\n" +
				"[2]	Sailfish  - Price: 4,500,000.00$ - Sell price: 2,250,000.00$\n" +
				"[3]	Scout - Price: 2,000,000.00$ - Sell price: 1,000,000.00$\n" +
				"____________________________________________________________________________________\n" +
				"Enter your choice here: ");
		
			if (buyBoatChoice == 1){
			
				brand = "Robalo";
				buyingPrice = 3100000;
				sellingPrice = 1550000;
				
			
			}	else if (buyBoatChoice == 2){
			
				brand = "Sailfish";
				buyingPrice = 4500000;
				sellingPrice = 2250000;
				
			
			}	else if (buyBoatChoice == 3){
			
				brand = "Scout";
				buyingPrice = 2000000;
				sellingPrice = 1000000;
				
			
			}	else	{
			
				System.out.print("\nInvalid choice, please try again.\n");
			
			}
			
		}	while(buyBoatChoice != 1 && buyBoatChoice != 2 && buyBoatChoice != 3);
		
		do
		{
			boatColourChoice = readInt("\n____________________________________________________________________________________\n" +
				"Colour:\n" +
				"[1]	White\n" +
				"[2]	Red\n" +
				"[3]	Black\n" +
				"____________________________________________________________________________________\n" +
				"Enter your choice here: ");
		
			
			if (boatColourChoice == 1){
				
				colour = "White";
				
			}	else if (boatColourChoice == 2){
				
				colour = "Red";
				
			}	else if (boatColourChoice == 3){
				
				colour = "Black";
				
			}	else	{
				
				System.out.print("\nInvalid choice, please try again.\n");
				
			}
			
		}	while(boatColourChoice != 1 && boatColourChoice != 2 && boatColourChoice != 3);
		
		System.out.println("\nAdded boat " + brand + " to owned vechicles.");
		
		
		
		Boat boat = new Boat(brand, colour, buyingPrice, sellingPrice);
		
		allVehicles.add(boat);
		allBoats.add(boat);
	}
	
	
	
	
	void addCar()
	{
		
		String brand = null;
		String colour = null;
		int sellingPrice = 0;
		int buyingPrice = 0;
		int buyCarChoice;
		int carColourChoice;
		
		do
		{
			buyCarChoice = readInt("\n--ENTER CAR INFO--\n" +
				"____________________________________________________________________________________\n" +
				"Brand:\n" +
				"[1]	Skoda - Price: 1,100,000.00$ - Sell price: 550,000.00$\n" +
				"[2]	Ford  - Price: 1,300,000.00$ - Sell price: 650,000.00$\n" +
				"[3]	Volvo - Price: 1,000,000.00$ - Sell price: 500,000.00$\n" +
				"____________________________________________________________________________________\n" +
				"Enter your choice here: ");
		
			if (buyCarChoice == 1){
			
				brand = "Skoda";
				buyingPrice = 1100000;
				sellingPrice = 550000;
				
			
			}	else if (buyCarChoice == 2){
			
				brand = "Ford";
				buyingPrice = 1300000;
				sellingPrice = 650000;
				
			
			}	else if (buyCarChoice == 3){
			
				brand = "Volvo";
				buyingPrice = 1000000;
				sellingPrice = 500000;
				
			
			}	else	{
			
				System.out.print("\nInvalid choice, please try again.\n");
			
			}
			
		}	while(buyCarChoice != 1 && buyCarChoice != 2 && buyCarChoice != 3);
		
		do
		{
			carColourChoice = readInt("\n____________________________________________________________________________________\n" +
				"Colour:\n" +
				"[1]	White\n" +
				"[2]	Red\n" +
				"[3]	Black\n" +
				"____________________________________________________________________________________\n" +
				"Enter your choice here: ");
		
			
			if (carColourChoice == 1){
				
				colour = "White";
				
			}	else if (carColourChoice == 2){
				
				colour = "Red";
				
			}	else if (carColourChoice == 3){
				
				colour = "Black";
				
			}	else	{
				
				System.out.print("\nInvalid choice, please try again.\n");
				
			}
			
		}	while(carColourChoice != 1 && carColourChoice != 2 && carColourChoice != 3);
		
		System.out.println("\nAdded car " + brand + " to owned vechicles.");
		
		
		
		Car car = new Car(brand, colour, buyingPrice, sellingPrice);
		
		allVehicles.add(car);
		allCars.add(car);
	}
	
	
	
	
	void listOfVehicles()
	{
		int ownedVehicleChoice;
		do
		{
			ownedVehicleChoice = readInt("\n--VIEW OWNED VEHICLES--" +
				"\n____________________________________________________________________________________\n" +
				"Select the type of vehilce you wish to see\n" +
				"____________________________________________________________________________________\n" +
				"[1]	Cars owned now\n" +
				"[2]	Boats owned now\n" +
				"[3]	Planes owned now\n" +
				"[4]	Histroy of all vehicles that you have owned\n" +
				"____________________________________________________________________________________\n" +
				"Enter your choice here: ");
		
			switch (ownedVehicleChoice)	{
		
			case 1 : 
				
				if(allCars.size() > 0)
				{
					for(int x = 0; x < allCars.size(); x++)
					{

						System.out.println("List number: " + x + "\t" + allCars.get(x));
			
					}
					
				}	else	{
					
					System.out.println("You don't own any cars.");
					
				}
				
				break;
		
			case 2 :
				
				if(allBoats.size() > 0)
				{
					for(int x = 0; x < allBoats.size(); x++)
					{
				
						System.out.println("List number: " + x + "\t" + allBoats.get(x));
				
					}
					
				}	else	{
					
					System.out.println("You don't own any boats.");
					
				}
				break;
			
			case 3 :
				
			    if(allPlanes.size() > 0)
			    {
			    	for(int x = 0; x < allPlanes.size(); x++)
			    	{
				
			    		System.out.println("List number: " + x + "\t" + allPlanes.get(x));
				
			    	}
			    	
			    }	else	{
				
			    	System.out.println("You don't own any planes.");
				
			    }
				break;
			
			case 4 :
				
				if(allVehicles.size() > 0)
				{
					for(int x = 0; x < allVehicles.size(); x++)
					{
				
						System.out.println("List number: " + x + "\t" + allVehicles.get(x));
				
					}
				
				}	else	{
					
					System.out.println("You havn't owned any vehicles.");
					
				}
				break;
			
			default : System.out.println("Invalid choice, please try again.\n");
		
		}
			
		}	while(ownedVehicleChoice != 1 && ownedVehicleChoice != 2 && ownedVehicleChoice != 3 && ownedVehicleChoice != 4);
	}
	
	
	
	
	void sellVehicle()
	{
		
		int sellVehicleChoice;
		do
		{
			sellVehicleChoice = readInt("\n--SELL VECHICLE--" +
				"\n____________________________________________________________________________________\n" +
				"Select the type of vechilce you wish to sell\n" +
				"____________________________________________________________________________________\n" +
				"[1]	Car\n" +
				"[2]	Boat\n" +
				"[3]	Plane\n" +
				"____________________________________________________________________________________\n" +
				"Enter your choice here: ");
			
			if(sellVehicleChoice == 1)
			{
				
				for(int x = 0; x < allCars.size(); x++)
				{
					
					System.out.println("List number: " + x + "\t" + allCars.get(x));
					
				}
				
				int sellCar = readInt("\nWrite the listnumber of the car you wish to sell: ");
				
				
				
				if(sellCar >= 0 && sellCar < allCars.size()){
						
					moneyEarnedCars += allCars.get(sellCar).getSellingPrice();
					allCars.remove(sellCar);
					
				}	else	{
					
					System.out.print("Car not in list, can't remove nonexsisting cars.");
					
				}	
				
			}
			
			else if(sellVehicleChoice == 2)
			{
				
				for(int x = 0; x < allBoats.size(); x++)
				{
					
					System.out.println("List number: " + x + "\t" + allBoats.get(x));
					
				}
				
				int sellBoat = readInt("\nWrite the listnumber of the boat you wish to sell: ");
				
				
				
				if(sellBoat >= 0 && sellBoat < allBoats.size()){
					
					moneyEarnedBoats += allBoats.get(sellBoat).getSellingPrice();
					allBoats.remove(sellBoat);
						
				}	else	{
					
					System.out.print("Boat not in list, can't remove nonexsisting boats.");
					
				}	
				
				
			}
			
			if(sellVehicleChoice == 3)
			{
				
				for(int x = 0; x < allPlanes.size(); x++)
				{
					
					System.out.println("List number: " + x + "\t" + allPlanes.get(x));
					
				}
				
				int sellPlane = readInt("\nWrite the listnumber of the plane you wish to sell: ");
				
				
				
				if(sellPlane >= 0 && sellPlane < allPlanes.size()){
						
					moneyEarnedPlanes += allPlanes.get(sellPlane).getSellingPrice();
					allPlanes.remove(sellPlane);
						
				}	else	{
					
					System.out.print("Plane not in list, can't remove nonexsisting planes.");
					
				}	
				
			}
		
		}	while(sellVehicleChoice != 1 && sellVehicleChoice != 2 && sellVehicleChoice != 3);
	}
	
	
	
	
	void moneySpent()
	{
		int moneySpentCars = 0;
		int moneySpentBoats = 0;
		int moneySpentPlanes = 0;
		int moneySpentTotal = 0;
		int moneySpentChoice;
		do
		{
			moneySpentChoice = readInt("\n--MONEY SPENT--" +
				"\n____________________________________________________________________________________\n" +
				"Select the type of vehilce you wish to see the total amount of money spent on\n" +
				"____________________________________________________________________________________\n" +
				"[1]	Car\n" +
				"[2]	Boat\n" +
				"[3]	Plane\n" +
				"[4]	All\n" +
				"____________________________________________________________________________________\n" +
				"Enter your choice here: ");
		
			switch(moneySpentChoice)
			{
			
			case 1 :	
				
				for(int x = 0; x < allVehicles.size(); x++)
				{
						if(allVehicles.get(x).getBrand().equals("Skoda") || allVehicles.get(x).getBrand().equals("Ford") || allVehicles.get(x).getBrand().equals("Volvo"))
						{
								
							moneySpentCars += allVehicles.get(x).getBuyingPrice();
								
						}
								
				}
						
				System.out.println("\nTotal money spent on cars: " + moneySpentCars);
				
			break;	
				
			case 2 :	
			
				for(int x = 0; x < allVehicles.size(); x++)
				{
						if(allVehicles.get(x).getBrand().equals("Robalo") || allVehicles.get(x).getBrand().equals("Sailfish") || allVehicles.get(x).getBrand().equals("Scout"))
						{
								
							moneySpentBoats += allVehicles.get(x).getBuyingPrice();
								
						}
								
				}
				
				System.out.println("\nTotal money spent on boats: " + moneySpentBoats);
			
			break;	
			
			case 3 :	
			
				for(int x = 0; x < allVehicles.size(); x++)
				{
						if(allVehicles.get(x).getBrand().equals("Nova") || allVehicles.get(x).getBrand().equals("Geminin Jets") || allVehicles.get(x).getBrand().equals("Falcon"))
						{
								
							moneySpentPlanes += allVehicles.get(x).getBuyingPrice();
								
						}
								
				}
		
			System.out.println("\nTotal money spent on planes: " + moneySpentPlanes);
			
			break;	
			
			case 4 :	
			
				for(int x = 0; x < allVehicles.size(); x++)
				{
			
					moneySpentTotal += allVehicles.get(x).getBuyingPrice();
			
				}
		
				System.out.println("\nTotal money spent: " + moneySpentTotal);
			
			break;
			
			default :	System.out.println("\nInvalid choice, please try again.");
			
			}
		
		
		}	while(moneySpentChoice != 1 && moneySpentChoice != 2 && moneySpentChoice != 3 && moneySpentChoice != 4);
		
	}
	
	
	
	
	void moneyEarned()
	{
		int moneyEarnedChoice;
		int moneyEarnedTotal = moneyEarnedCars + moneyEarnedBoats + moneyEarnedPlanes;
		do
		{
			moneyEarnedChoice = readInt("\n--MONEY EARNED--" +
				"\n____________________________________________________________________________________\n" +
				"Select the type of vehilce you wish to see the total amount of money earned\n" +
				"____________________________________________________________________________________\n" +
				"[1]	Car\n" +
				"[2]	Boat\n" +
				"[3]	Plane\n" +
				"[4]	All\n" +
				"____________________________________________________________________________________\n" +
				"Enter your choice here: ");
		
			switch(moneyEarnedChoice)
			{
				
			case 1 : System.out.println("\nTotal money earned by selling cars: " + moneyEarnedCars);
			break;
			
			case 2 : System.out.println("\nTotal money earned by selling boats: " + moneyEarnedBoats);
			break;
			
			case 3 : System.out.println("\nTotal money earned by selling planes: " + moneyEarnedPlanes);
			break;
			
			case 4 : System.out.println("\nTotal money earned by selling vehicles: " + moneyEarnedTotal);
			break;
			
			default : System.out.println("\nInvalid choice, please try again.");
			}
		
		}	while(moneyEarnedChoice != 1 && moneyEarnedChoice != 2 && moneyEarnedChoice != 3 && moneyEarnedChoice != 4);
	}
		
	
	
	
	public static void main	(String [] angs)
	{
		
		Register register = new Register();
		int mainMenuChoice;
		do
		{
			
			register.menu();
		
			mainMenuChoice = register.readInt("Enter your choice here: ");
		
			switch (mainMenuChoice)
			{
		
			case 1 : register.purchaseVehicle(); break;
			case 2 : register.listOfVehicles(); break;
			case 3 : register.sellVehicle(); break;
			case 4 : register.moneySpent(); break;
			case 5 : register.moneyEarned(); break;
			case 6 : System.out.print("\n\nGoodbye."); break;
			default : System.out.println("Invalid choice, please try again.\n"); 
		
			}	
			
		}	while (mainMenuChoice != 6);
	}
}
