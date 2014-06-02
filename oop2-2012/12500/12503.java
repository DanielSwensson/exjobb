public class Hat extends Clothes{


	/* Hats �r en subklass av Clothes
	 * dess unika v�rde �r type som beskriver vilken typ av huvudbonad det �r t.ex keps eller str�hatt. */
	
	private String type;

	/*Konstruktorn f�r Hat*/

	public Hat (int serialNr, String color, int year, int price, String type, int washed, int value){
		super(serialNr,"Hattar",color, year, price,"0", washed, 1, 5);
		this.type = type;

	}
	
	/* Detta �r Hats egna metod som g�ller n�r alla kl�der ska bli tv�ttade, id�en �r att en hatt blir f�rst�rd och tappar sin kvalit�
	 * n�r man k�r en tv�tt.*/
	/* getValue f�r Hats, v�rdet �r priset dividerat md kvalit�n */
	public int getValue(){
		
		int age = 2013 - year;
		if (age<=0){
			age=1;
			}
		int value = price/age;
		return value;
	}

	public String toString(){
		return(serialNr +" �r En "+type+ " i f�rgen "+color+" k�pt �r "+year+" f�r "+price+" kr."+". Du har tv�ttat huvudbonaden "+washed+" g�nger och kvaliten p� huvudbonaden �r "+getQuality()+" secondhandv�rdet �r "+getValue()+" kr");
	}
	
	/* toString2 �r ett medelande som beskriver det objekt man just skapat*/

	public String toString2(){
		return("Du har lagt till en "+type+ " i f�rgen "+color+" som du k�pt �r: "+year+" f�r "+price+" kr.");
				}
}