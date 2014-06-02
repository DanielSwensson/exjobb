public class Belt extends Clothes {
	
	/* Belts är en subklass av Clothes
	 * dess unika värde är length "längd" */
	
	private String length;
	public Belt (int serialNr, String color, int year, int price, String length,int washed, int value){
		super(serialNr,"Bälten",color, year, price, "0", washed ,3, value);
		this.length =length;

	}
	
	public int getValue(){
		
		if(washed<0){
			washed = 1;
		}
	
		int value = price-washed / 2;
		
		return value;
	}
	
	public String toString(){
		return(serialNr +" Är En bälte i färgen "+color+" som är köpt år "+year+" som kostade "+price+" kr. Bältet är "+length+" cm långt.Du har tvättat bältet "+washed+" gånger och kvaliten på bältet är "+getQuality()+" secondhandvärdet är "+getValue()+" kr");
	}
	
	public String toString2(){
		return("Du har lagt till ett bälte i färgen "+color+" som du köpt år "+year+" som kostar "+price+" kr. Bältet är  "+length+" cm långt.");
	}
}
