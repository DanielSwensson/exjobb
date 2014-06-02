import java.util.Scanner;
abstract public class Clothes {

	/* Clothes är en superklass för kläder i garderoben,*/

	Scanner keyboard = new Scanner(System.in);
	protected int serialNr;
	protected String color;
	protected int year;
	protected int price;
	protected int washed;
	protected int quality;
	protected String name;
	protected String size;
	protected int value;

	
	/* Clothes konstruktor för att skapa ett objekt av Clothes,*/

	public Clothes (int serialNr, String name, String color, int year, int price, String size, int washed, int quality, int value){

		this.color = color;
		this.year = year;
		this.price = price;
		this.washed = washed;
		this.name = name;
		this.quality=quality;
		this.serialNr=serialNr;
		this.value=value;
		this.size=size;
	}

	/* getValue är Clothes defalut metod för att räkna ut värdet på ett objekt i Clothes. Den tar nuvarande år minus året 
	 * klädesplagget var köpt sen tar en det minus antalet gånger plagget är tvättat. */
		
	public int getValue(){
		int age = 2013 - year;
			if (age<0){
				age=1;
			}
		int status = washed+age;
		int value = price/status;
		
		return value;
	}

	/* washCloth är en metod för att tvätta alla kläder, när metoden körs så plussar den på antalet gånger ett klass har blivit tvättad. */
	public int washCloth(){
		
	++washed;
	quality+=-1;
		if (quality<0){
				quality=0;}
	return quality;
	}
	
	/* returnerar objektets serienummer*/
	public int getSerialNumber(){
		return serialNr;
	}
	
	/* returnerar objektets storlek*/
	public String getSize(){
		
		return size;
	}

	/* returnerar objektets namn, alla objekt lägger själv till det namn för det objektet när man skapar en nytt objekt av den klassen
	 * t.ex när man lägger till en skjorta så lägger skjorta själv in att dess namn är Skjortor, detta för att underlätta när man söka
	 * efter plaggtyp i searchCloteType() i WarderobeRegister*/

	public String getName(){
		
		return name;
	}
	
	/* returnerar objektets färg*/
	public String getColor(){
		return color;
	}

	/* returnerar objektets year*/
	public int getYear(){
		return year;
	}
	
	/* returnerar objektets inköps pris*/
	public double getPrice(){
		return price;
	}
	
	/* returnerar hur många gånger ett objektet har blivit tvättat*/
	public int getTimesWashed(){
		return washed;
	}
	
	
	
	/* returnerar objektets kvalite som räknas ut att man tar quality minus antal tvättar
	 * resultatet matchas sedan mot en skala mellan 0-6 där */
	
	public String getQuality(){
		
		String answer="nyköpt";
			if(quality < 6){
			answer = "snart urtvättad";
		} else if (quality < 3){
			answer = "urtvättad";
	}			
		return answer;
}

}