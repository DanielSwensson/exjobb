
abstract public class Article {

		private String name;
		
		public Article (String name){
			this.name=name;
			
		}
		
		abstract double value ();
		
		public String toString() {
			return  name + " med värdet: " + value (); 
			}
		
}
