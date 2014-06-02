import java.util.ArrayList;

	public class Person {
	
		private String name;
	
		private ArrayList<Article> articles = new ArrayList<Article>(); 

		public Person (String name){
		this.name = name;
		}
	
		public void add (Article a) {
		articles.add(a);
		}
			
		public String showTotalValue (){//visar alla personer + total förmögenhet i heltal.
			return name + "   " + "Kapital: " + getValue () + " kronor. ";
		}
		
		public Article getArticles () { 
			Article c = null;
				for (Article a : articles) {
					System.out.println(a + " "); 
					c=a;
				} return c;
		}
		
		public String toString() {
			return name + "";
		}
		
		public String getName (){ 
			return name;
		}
	
		public int getValue () {
			int sum = 0;
			for (Article aktuell : articles) {
				sum += aktuell.value();
			} return sum;
		}
		
		public void changePriceOfShare (){ 
			for (Article a : articles) {
				if (a instanceof Share){
					((Share) a).changePrice ();
					System.out.println(a);
				} 
			}
		}		
		
}
