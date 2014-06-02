public class Pants extends Clothes{

	private String length;

	
	/*Konstruktorn för Pants*/

	public Pants (int serialNr,String color, int year, int price, String size, String length, int washed, int value){
		super(serialNr,"Byxor",color, year, price, size, washed, 4, value);
		this.length = length;

	}
	
	/*washCloth är pants egna metod för att påverka objektet när användaren väljar att tvätta alla objekt .*/

	public int washCloth(){
		
		++washed;
		quality+=-3;
			if (quality<0){
				quality=0;}
		return quality;
	}
	
	
	/*getvalue är pants egna metod för att räkna ut värdet på pants
	 *Den tar nuvarande år minus året för inköp sedan räknar den ut en status där dividerar kvaliten med hur gammal kläderna är.
	 *Sedan tar man byxornas status och dividerar med inköpspriset.*/

	public int getValue(){
		int age = 2013 - year;
			if (age<=0){
				age=1;
				}
		int status = age+washed;
		int value = price/status;
		return value;
	}

	public String toString(){
		return(serialNr +" Är En par byxor i färgen "+color+" som är köpta år: "+year+" för "+price+" kr. Storleken i midja "+size+" och längd "+length+". Du har tvättat byxorna "+washed+" gånger och kvaliten på byxorna är "+getQuality()+" secondhandvärdet är "+getValue()+" kr");
	}
	
	
	/* toString2 är ett medelande som beskriver det objekt man just skapat*/

	public String toString2(){
		return("Du har lagt till ett par byxor i färgen "+color+" som du köpt år "+year+" för "+price+" kr. Med midjestolek "+size+" och längd " +length+".");
	}
	}