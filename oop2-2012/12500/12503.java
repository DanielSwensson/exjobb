public class Hat extends Clothes{


	/* Hats är en subklass av Clothes
	 * dess unika värde är type som beskriver vilken typ av huvudbonad det är t.ex keps eller stråhatt. */
	
	private String type;

	/*Konstruktorn för Hat*/

	public Hat (int serialNr, String color, int year, int price, String type, int washed, int value){
		super(serialNr,"Hattar",color, year, price,"0", washed, 1, 5);
		this.type = type;

	}
	
	/* Detta är Hats egna metod som gäller när alla kläder ska bli tvättade, idéen är att en hatt blir förstörd och tappar sin kvalité
	 * när man kör en tvätt.*/
	/* getValue för Hats, värdet är priset dividerat md kvalitén */
	public int getValue(){
		
		int age = 2013 - year;
		if (age<=0){
			age=1;
			}
		int value = price/age;
		return value;
	}

	public String toString(){
		return(serialNr +" Är En "+type+ " i färgen "+color+" köpt år "+year+" för "+price+" kr."+". Du har tvättat huvudbonaden "+washed+" gånger och kvaliten på huvudbonaden är "+getQuality()+" secondhandvärdet är "+getValue()+" kr");
	}
	
	/* toString2 är ett medelande som beskriver det objekt man just skapat*/

	public String toString2(){
		return("Du har lagt till en "+type+ " i färgen "+color+" som du köpt år: "+year+" för "+price+" kr.");
				}
}