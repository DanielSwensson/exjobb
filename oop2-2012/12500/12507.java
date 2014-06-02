
		public class Sweater extends Clothes{

			/* Sweaters �r en subklass av Clothes
			 * dess unika v�rde �r collar "krage"*/	
			
		private String collar;

		public Sweater (int serialNr, String color, int year, int price, String size, String collar, int washed, int value){
			super(serialNr, "Tr�jor", color, year, price, size, washed, 8, value);
			this.collar = collar;
		}
		
		public String toString(){
			return(serialNr +" �r En tr�ja i f�rgen "+color+" k�pt �r "+year+" f�r "+price+" kr med en "+collar+" krage i stoleken "+size+". Secondhandv�rdet �r "+value);
		}
		
		/* toString2 �r ett meddelande som beskriver det objekt man just skapat*/

		public String toString2(){
			return("Du har lagt till en tr�ja i f�rgen: " +color+" som du k�pt "+year+" f�r "+price+" kr med en "+collar+" krage i stoleken "+size+".");
		}
	}

