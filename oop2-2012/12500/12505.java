public class Shirt extends Clothes{

	/* Shirt är en subklass av klassen Clothes
	 * dess unika värde är collar "krage" */

	private String collar;
	
	/*Konstruktorn för Shirt*/

	
	public Shirt (int serialnr,String color, int year, int price, String collar, String size, int washed, int value){
		super(serialnr,"Skjortor",color, year, price,size, washed, 10, value);
		this.collar = collar;
	}
	

	public String toString(){
		return(serialNr +" Är En skjorta i färgen "+color+" köpt år "+year+" för "+price+" kr med en "+collar+" krage i stoleken "+size+"." +" Du har tvättat skjortan "+washed+" gånger och kvaliten på skjortan är "+getQuality()+". Secondhandvärdet är "+getValue()+"kr");
	}
	
	/* toString2 är den toString som kommer när man registrerat som beskriver det objekt man registrerat*/

	public String toString2(){
		return("Du har lagt till en skjorta i färgen " +color+" som du köpt "+year+" för "+price+" kr med en "+collar+" krage i stoleken "+size+".");
	}
	
}