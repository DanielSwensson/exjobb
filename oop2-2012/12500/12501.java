public class Belt extends Clothes {
	
	/* Belts �r en subklass av Clothes
	 * dess unika v�rde �r length "l�ngd" */
	
	private String length;
	public Belt (int serialNr, String color, int year, int price, String length,int washed, int value){
		super(serialNr,"B�lten",color, year, price, "0", washed ,3, value);
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
		return(serialNr +" �r En b�lte i f�rgen "+color+" som �r k�pt �r "+year+" som kostade "+price+" kr. B�ltet �r "+length+" cm l�ngt.Du har tv�ttat b�ltet "+washed+" g�nger och kvaliten p� b�ltet �r "+getQuality()+" secondhandv�rdet �r "+getValue()+" kr");
	}
	
	public String toString2(){
		return("Du har lagt till ett b�lte i f�rgen "+color+" som du k�pt �r "+year+" som kostar "+price+" kr. B�ltet �r  "+length+" cm l�ngt.");
	}
}
