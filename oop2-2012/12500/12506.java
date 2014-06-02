public class Shoes extends Clothes{

	/* Shoes �r en subklass av klassen Clothes
	 * dess unika v�rde �r type som ska visa om t.ex skon �r en k�nga eller en sneaker*/
	
	private String type;
	
	
	/*Konstruktorn f�r Shoes*/
	
	public Shoes (int serialNr, String color, int year, int price, String size, String type, int washed, int value){
		super(serialNr,"Skor",color, year, price,size, washed, 5, value);
		this.size = size;
		this.type = type;

	}
	
	/*getValue �r Shoes egna metod f�r att r�kna ut dess v�rde.*/
	public int getValue(){
		int age = 2013-year;
		int value = price/(age+washed);
		return value;
	}

	/*washCloth �r Shoes egna metod f�r att p�verka objektet n�r anv�ndaren v�ljar att tv�tta alla objekt .*/
	

	public String toString(){
		return(serialNr +" �r En par skor i f�rgen "+color+" k�pta �r "+year+" som kostade "+price+" kr. Storleken "+size+" av typen "+type+".  Du har tv�ttat skorna "+washed+" g�nger och  Kvaliten p� skorna �r "+getQuality()+" secondhandv�rdet �r "+getValue()+" kr");
	}

	
	/* toString2 �r ett medelande som beskriver det objekt man just skapat*/
	public String toString2(){
		return("Du har lagt till ett par skor i f�rgen "+color+" som du k�pt �r: "+year+" och som kostade "+price+" kr. Storleken "+size+" och �r av typen "+type+".");
	}
}

