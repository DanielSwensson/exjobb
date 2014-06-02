// 2013 Victor Egerö

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private ArrayList<Person> aPerson = new ArrayList<Person>();
	private ArrayList<Device> aDevice = new ArrayList<Device>();
	private ArrayList<Jewelry> aJewelry = new ArrayList<Jewelry>();
	private ArrayList<Stock> aStock = new ArrayList<Stock>();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Main mCommand = new Main();
		System.out.println("DSK1:OOP:Assignment 2");
		
		for(;;){
			try{
				int iCase=mCommand.readInt("1. Create person\n2. Create thing\n3. Show all persons\n4. Show person with things of highest value\n5. Show person of choice\n6. Stock exchange crash\n7. Exit\nCommand (1-7): ");
				switch (iCase){
					case 1:mCommand.createPerson();break;
					case 2:mCommand.createThing();break;
					case 3:mCommand.showAllPerson();break;
					case 4:mCommand.showPersonHighestValue();break;
					case 5:mCommand.showPerson();break;
					case 6:mCommand.runStockExchangeCrash();break;
					case 7:mCommand.exit();break;
					default:System.out.println("Error: has to be between 1-7");
				}
			}catch(NumberFormatException e){
				System.out.println("Error: has to be an integer");
			}
		}
	}
	
	private int readInt(String sQuestion){
		for(;;){
			try{
				System.out.print(sQuestion);
				int iTemp=Integer.parseInt(sc.nextLine());
				return iTemp;
			}catch(NumberFormatException e){
				System.out.println("Error: has to be an integer");
			}
		}
	}
	
	private String readString(String sQuestion){
		String sTemp="";
		while (sTemp.length()<1){
			System.out.print(sQuestion);
			sTemp=sc.nextLine();
			if (sTemp.length()<1){
				System.out.println("Error: there has to be at least one character");
			}
		}
		return sTemp;
	}
	
	private String readString(String sQuestion,String sError,String sWord1,String sWord2){
		String sTemp="";
		while(!sTemp.equalsIgnoreCase(sWord1)&&!sTemp.equalsIgnoreCase(sWord2)){
			sTemp=readString(sQuestion);
			if (!sTemp.equalsIgnoreCase(sWord1)&&!sTemp.equalsIgnoreCase(sWord2)){
				System.out.println(sError);
			}
		}
		return sTemp;
	}
	
	private Person getPerson(String sName){
		for (Person pTemp : aPerson){
			if (pTemp.getName().equalsIgnoreCase(sName)){
				return pTemp;
			}
		}
		return null;
	}
	
	private int getPersonIndex(String sName){
		int iIndex=0;
		for (Person pTemp : aPerson){
			if (pTemp.getName().equalsIgnoreCase(sName)){
				return iIndex;
			}
			iIndex++;
		}
		return -1;
	}
	
	private void createPerson(){
		boolean bCheck = false;
		while(bCheck != true){
			String sName = readString("Name: ");
			Person pCheck = getPerson(sName);
			if (pCheck!=null){
				System.out.println("Error: this person is already in the system");
			}else{
				Person pTemp2 = new Person(sName);
				aPerson.add(pTemp2);
				bCheck = true;
			}
		}
		
	}
	
	private void createThing(){ //code for creating thing
		if (aPerson.size()>0){
			String sNamePerson="",sNameThing,sElement;
			int iThing=0,iValue,iWear,iGems,iQuantity;
			for (boolean bTemp=true;bTemp==true;){
				sNamePerson = readString("Name of person to assign thing to: ");
				Person pCheck = getPerson(sNamePerson);
				if (pCheck!=null){
					bTemp=false;
				}else{
					System.out.println("Error: a person with that name is not in the system");
				}
			}
			
			for (;iThing<1||iThing>3;){
				iThing = readInt("Choose thing (1-3):\n1. Device\n2. Jewelry\n3. Stock\nThing: ");
				if (iThing<1||iThing>3){
					System.out.println("Error: must be between 1-3");
				}
			}
			
			switch(iThing){
				case 1:
					sNameThing = readString("Name of device: ");
					iValue = readInt("Value of device: ");
					iWear = readInt("Wear of device: ");
					aDevice.add(new Device(sNameThing,iValue,iWear));
					aPerson.get(getPersonIndex(sNamePerson)).addThing(aDevice);
					aDevice.clear();
					break;
				case 2:
					sNameThing = readString("Name of jewelry: ");
					iGems = readInt("Number of gems for jewelry: ");
					sElement = readString("Gold or Silver?\nElement: ","Error: has to be Gold or Silver","Gold","Silver");
					aJewelry.add(new Jewelry(sNameThing,iGems,sElement));
					aPerson.get(getPersonIndex(sNamePerson)).addThing(aJewelry);
					aJewelry.clear();
					break;
				case 3:
					sNameThing = readString("Name of stock: ");
					iValue = readInt("Value of stock: ");
					iQuantity = readInt("Quantity of stocks: ");
					aStock.add(new Stock(sNameThing,iValue,iQuantity));
					aPerson.get(getPersonIndex(sNamePerson)).addThing(aStock);
					aStock.clear();
					break;
			}
		}else{
			System.out.println("Error: there are no persons in the system to assign the thing to");
		}
	}
	
	private void showAllPerson(){ //code for showing all persons
		if (aPerson.size()>0){
			for (int iN=0;iN<aPerson.size();iN++){
				aPerson.get(iN).showNameTotalValue();
			}
		}else{
			System.out.println("Error: there are no persons in the system");
		}
		
	}
	
	private void showPersonHighestValue(){ //code for showing the person with the highest value
		if (aPerson.size()>0){
			int iHighestValue=0,iIndex=0;
			for (int iN=0;iN<aPerson.size();iN++){
				if(iHighestValue<aPerson.get(iN).getTotalValue()){
					iHighestValue = aPerson.get(iN).getTotalValue();
					iIndex = iN;
				}
			}
			System.out.println("The person with the highest value is "+aPerson.get(iIndex).getName()+" at "+aPerson.get(iIndex).getTotalValue());
			aPerson.get(iIndex).showAllThingValue();
		}else{
			System.out.println("Error: there are no persons in the system");
		}
		
	}
	
	private void showPerson(){ //code for showing person sName and all his things and their values
		if (aPerson.size()>0){
			String sName="";
			boolean bName = false;
			int iTries=0;
			while (bName != true){
				sName = readString("Name of person: ");
				Person pCheck = getPerson(sName);
				if (pCheck!=null){
					int iIndex = getPersonIndex(sName);
					aPerson.get(iIndex).showNameTotalValue();
					aPerson.get(iIndex).showAllThingValue();
					bName=true;
				}else{
					System.out.println("Error: no such person in the system");
					iTries++;
					if (iTries>3){
						String sShowPerson = readString("Show all persons?\n(yes,no): ");
						if (sShowPerson.equalsIgnoreCase("yes")){
							showAllPerson();
						}
					}
				}
			}
		}else{
			System.out.println("Error: there are no persons in the system");
		}
	}
	
	private void runStockExchangeCrash(){ //code for all stock value is reset to zero
		System.out.println("Oh no, all stocks have been reset to zero!");
		for (int iN=0;iN<aPerson.size();iN++){
			aPerson.get(iN).setAllStockValueZero();
		}
	}
	
	private void exit(){
		System.exit(0);
	}

}
