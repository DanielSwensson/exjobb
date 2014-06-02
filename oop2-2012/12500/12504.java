public class Pants extends Clothes{

	private String length;

	
	/*Konstruktorn f�r Pants*/

	public Pants (int serialNr,String color, int year, int price, String size, String length, int washed, int value){
		super(serialNr,"Byxor",color, year, price, size, washed, 4, value);
		this.length = length;

	}
	
	/*washCloth �r pants egna metod f�r att p�verka objektet n�r anv�ndaren v�ljar att tv�tta alla objekt .*/

	public int washCloth(){
		
		++washed;
		quality+=-3;
			if (quality<0){
				quality=0;}
		return quality;
	}
	
	
	/*getvalue �r pants egna metod f�r att r�kna ut v�rdet p� pants
	 *Den tar nuvarande �r minus �ret f�r ink�p sedan r�knar den ut en status d�r dividerar kvaliten med hur gammal kl�derna �r.
	 *Sedan tar man byxornas status och dividerar med ink�pspriset.*/

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
		return(serialNr +" �r En par byxor i f�rgen "+color+" som �r k�pta �r: "+year+" f�r "+price+" kr. Storleken i midja "+size+" och l�ngd "+length+". Du har tv�ttat byxorna "+washed+" g�nger och kvaliten p� byxorna �r "+getQuality()+" secondhandv�rdet �r "+getValue()+" kr");
	}
	
	
	/* toString2 �r ett medelande som beskriver det objekt man just skapat*/

	public String toString2(){
		return("Du har lagt till ett par byxor i f�rgen "+color+" som du k�pt �r "+year+" f�r "+price+" kr. Med midjestolek "+size+" och l�ngd " +length+".");
	}
	}