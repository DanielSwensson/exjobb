public class Shirt extends Clothes{

	/* Shirt �r en subklass av klassen Clothes
	 * dess unika v�rde �r collar "krage" */

	private String collar;
	
	/*Konstruktorn f�r Shirt*/

	
	public Shirt (int serialnr,String color, int year, int price, String collar, String size, int washed, int value){
		super(serialnr,"Skjortor",color, year, price,size, washed, 10, value);
		this.collar = collar;
	}
	

	public String toString(){
		return(serialNr +" �r En skjorta i f�rgen "+color+" k�pt �r "+year+" f�r "+price+" kr med en "+collar+" krage i stoleken "+size+"." +" Du har tv�ttat skjortan "+washed+" g�nger och kvaliten p� skjortan �r "+getQuality()+". Secondhandv�rdet �r "+getValue()+"kr");
	}
	
	/* toString2 �r den toString som kommer n�r man registrerat som beskriver det objekt man registrerat*/

	public String toString2(){
		return("Du har lagt till en skjorta i f�rgen " +color+" som du k�pt "+year+" f�r "+price+" kr med en "+collar+" krage i stoleken "+size+".");
	}
	
}