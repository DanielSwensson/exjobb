
		public class Sweater extends Clothes{

			/* Sweaters är en subklass av Clothes
			 * dess unika värde är collar "krage"*/	
			
		private String collar;

		public Sweater (int serialNr, String color, int year, int price, String size, String collar, int washed, int value){
			super(serialNr, "Tröjor", color, year, price, size, washed, 8, value);
			this.collar = collar;
		}
		
		public String toString(){
			return(serialNr +" Är En tröja i färgen "+color+" köpt år "+year+" för "+price+" kr med en "+collar+" krage i stoleken "+size+". Secondhandvärdet är "+value);
		}
		
		/* toString2 är ett meddelande som beskriver det objekt man just skapat*/

		public String toString2(){
			return("Du har lagt till en tröja i färgen: " +color+" som du köpt "+year+" för "+price+" kr med en "+collar+" krage i stoleken "+size+".");
		}
	}

