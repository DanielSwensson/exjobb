
public abstract class Pryl {
		private String �gare;
		private String Typ;
		
				
		
		public Pryl(String �, String t){
			�gare = �;
			Typ = t;

		}
		
		
		public String toString(){
			return �gare + "    " + getV�rde();
		}
		
		public abstract void nollV�rd();
		
		
		public String getTyp(){
			return Typ;
		}
		
		public abstract double getV�rde();
		
}
