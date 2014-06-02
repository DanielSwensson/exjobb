import java.util.Scanner;
abstract public class Clothes {

	/* Clothes �r en superklass f�r kl�der i garderoben,*/

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

	
	/* Clothes konstruktor f�r att skapa ett objekt av Clothes,*/

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

	/* getValue �r Clothes defalut metod f�r att r�kna ut v�rdet p� ett objekt i Clothes. Den tar nuvarande �r minus �ret 
	 * kl�desplagget var k�pt sen tar en det minus antalet g�nger plagget �r tv�ttat. */
		
	public int getValue(){
		int age = 2013 - year;
			if (age<0){
				age=1;
			}
		int status = washed+age;
		int value = price/status;
		
		return value;
	}

	/* washCloth �r en metod f�r att tv�tta alla kl�der, n�r metoden k�rs s� plussar den p� antalet g�nger ett klass har blivit tv�ttad. */
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

	/* returnerar objektets namn, alla objekt l�gger sj�lv till det namn f�r det objektet n�r man skapar en nytt objekt av den klassen
	 * t.ex n�r man l�gger till en skjorta s� l�gger skjorta sj�lv in att dess namn �r Skjortor, detta f�r att underl�tta n�r man s�ka
	 * efter plaggtyp i searchCloteType() i WarderobeRegister*/

	public String getName(){
		
		return name;
	}
	
	/* returnerar objektets f�rg*/
	public String getColor(){
		return color;
	}

	/* returnerar objektets year*/
	public int getYear(){
		return year;
	}
	
	/* returnerar objektets ink�ps pris*/
	public double getPrice(){
		return price;
	}
	
	/* returnerar hur m�nga g�nger ett objektet har blivit tv�ttat*/
	public int getTimesWashed(){
		return washed;
	}
	
	
	
	/* returnerar objektets kvalite som r�knas ut att man tar quality minus antal tv�ttar
	 * resultatet matchas sedan mot en skala mellan 0-6 d�r */
	
	public String getQuality(){
		
		String answer="nyk�pt";
			if(quality < 6){
			answer = "snart urtv�ttad";
		} else if (quality < 3){
			answer = "urtv�ttad";
	}			
		return answer;
}

}