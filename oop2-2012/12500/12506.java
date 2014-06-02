public class Shoes extends Clothes{

	/* Shoes är en subklass av klassen Clothes
	 * dess unika värde är type som ska visa om t.ex skon är en känga eller en sneaker*/
	
	private String type;
	
	
	/*Konstruktorn för Shoes*/
	
	public Shoes (int serialNr, String color, int year, int price, String size, String type, int washed, int value){
		super(serialNr,"Skor",color, year, price,size, washed, 5, value);
		this.size = size;
		this.type = type;

	}
	
	/*getValue är Shoes egna metod för att räkna ut dess värde.*/
	public int getValue(){
		int age = 2013-year;
		int value = price/(age+washed);
		return value;
	}

	/*washCloth är Shoes egna metod för att påverka objektet när användaren väljar att tvätta alla objekt .*/
	

	public String toString(){
		return(serialNr +" Är En par skor i färgen "+color+" köpta år "+year+" som kostade "+price+" kr. Storleken "+size+" av typen "+type+".  Du har tvättat skorna "+washed+" gånger och  Kvaliten på skorna är "+getQuality()+" secondhandvärdet är "+getValue()+" kr");
	}

	
	/* toString2 är ett medelande som beskriver det objekt man just skapat*/
	public String toString2(){
		return("Du har lagt till ett par skor i färgen "+color+" som du köpt år: "+year+" och som kostade "+price+" kr. Storleken "+size+" och är av typen "+type+".");
	}
}

