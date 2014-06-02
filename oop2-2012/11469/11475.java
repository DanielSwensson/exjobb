
public abstract class Pryl {
		private String Ägare;
		private String Typ;
		
				
		
		public Pryl(String ä, String t){
			Ägare = ä;
			Typ = t;

		}
		
		
		public String toString(){
			return Ägare + "    " + getVärde();
		}
		
		public abstract void nollVärd();
		
		
		public String getTyp(){
			return Typ;
		}
		
		public abstract double getVärde();
		
}
