import java.util.ArrayList;
import java.util.Scanner;

public class Register {

		ArrayList<Person> all = new ArrayList<Person>();
		Scanner keyboard = new Scanner(System.in);
		
		public int readInt (String question){
			for (;;){
				try{
					System.out.print (question);
					int x = Integer.parseInt(keyboard.nextLine());
					return x;
				}
				catch (NumberFormatException e){
					System.out.println("Fel - skall vara numeriskt värde");
					}
			}
		}
		
		public String readString(String question){
			System.out.print(question);
			String str=keyboard.nextLine().toLowerCase();
			return str;
			}
		
		public Person getPerson(String name){ 
			for (Person p : all)
			if (p.getName ().equalsIgnoreCase(name))
			return p;
			return null;
			}
		
		public void addPerson(){
			String name = readString("Nya personens namn: ");
			Person p = getPerson(name);
			if (p!=null)
			System.out.println("Den personen finns redan");
			else{		
			Person anotherOne = new Person(name);
			all.add(anotherOne);
			}
		}
			
		public void createArticle (){
			int number;
			do {
				number = readInt ("Välj en siffra: \n 1) Smycke.\n 2) Aktie.\n 3) Apparat.\n 4) Till huvumenyn. ");
					
				if (number == 1){  
					String name1 = readString ("Typ av smycke (ring, halsband etc.): ");
					String sortGuldSilver = readString ("Guld eller silver? (g/s): ");
					int numberOfStones = readInt ("Ädelstenar? Ange antal (0 - ): ");
					Article newArticle1 = new Jewellery (name1, sortGuldSilver, numberOfStones);
					addArticle (newArticle1);
				} else if (number == 2){  
					String name2 = readString ("Aktie: ");
					int price2 = readInt ("Pris: ");
					int number2 = readInt ("Antal: ");
					Article newArticle2 = new Share (name2, price2, number2);
					addArticle (newArticle2);
				} else if (number == 3){  
						String name3 = readString ("Typ av apparat: ");
						int price3 = readInt ("Inköpspris: ");
						int wear3 = readInt ("Slitage (10 = helt ny, 1 = mycket sliten): ");
						Article newArticle3 = new Stuff (name3, price3, wear3);
						addArticle (newArticle3);
				}
				System.out.println ();
			} while (number>=1 && number <=3); 
		}
		
		public void addArticle (Article a) { //lägga till en artikel till befintlig person
			String nameOwner = readString ("Vem är ägaren? ");
			Person p = getPerson (nameOwner);
			if (p==null){
				System.out.println("Personen finns inte i registret. ");
			}else {getPerson (nameOwner).add(a);
			}	
		}
		
		public void viewAllPersons (){ //visar alla personer + deras totala förmögenhet
			System.out.println ("I registret finns: ");
				for (Person p : all){
					p.showTotalValue ();
					System.out.println (p.showTotalValue ());
			} 		
		}
		
		public String viewRichest (){ //Visar rikaste person och sammanlagda värde i heltal. 
			return "Rikast är: " + nameRichest () + " som sammanlagt äger "+ valueRichest () + " kronor. ";
		}
		
		public Person nameRichest () { // Visar rikaste personens namn. Anropas i viewRichest.
			String richestPerson = null;
			int index;
			Person person = null;
			for (Person p : all){
				if (p.getValue()== valueRichest ()){//sum
					//sum = p.getValue();
					richestPerson = p.getName();
					index = all.indexOf(getPerson (richestPerson));
					person = all.get(index);
					return person; 
				} 
			} return person;	
		}
		
		public int valueRichest () { // Rikaste personens sammanlagda förmögenhet. Anropas i viewRichest.
			int value = 0;
			for (Person p : all){
				if (p.getValue() > value){ //ändra namn ill engelska
					value = p.getValue();
				}
				}return value;
			}
		
		public Article particularPerson (){ //visaVissPerson 
			String namn = readString("Personens namn: ");
			Person p = getPerson(namn);
			Article article = null;
			int index = 0;
			if (p==null){
				System.out.println("Personen finns inte i registret. ");
			} else {
				System.out.println(p + " har: ");
				index = all.indexOf(getPerson (namn));	
				article = all.get(index).getArticles();
				return article;
			} return article;
		}

		public void marketCrash(){
			for (Person p : all){
				p.changePriceOfShare ();
				}
			}
		
		public static void main(String[] args) {
			Register register = new Register ();
				System.out.println ("Hej och välkommen till Prylregistret. ");
				
				for (;;) {
					int val = register.readInt ("Välj en siffra: \n1) Skapa person. 2) Skapa pryl. 3) Visa alla personer. 4) Visa rikaste.\n" +
							"5) Visa viss person. 6) Börskrasch. 7) Avsluta registrering. ");
					switch (val) {
						case 1:  
							register.addPerson(); 
							System.out.println();
							break;
						case 2: 
							register.createArticle ();
							System.out.println();
						break;
						case 3: 
							register.viewAllPersons (); 
							System.out.println();
							break;
						case 4: 
							System.out.println (register.viewRichest ()); 
							System.out.println();
							break;
						case 5: 
							register.particularPerson (); 
							System.out.println();
							break;
						case 6: 
							register.marketCrash(); 
							System.out.println(); 
							break;
						case 7: 
							System.out.println("Tack och hej då!"); 
							System.exit(0);
						default: 
							System.out.println("Fel kommando");
					}
				}			 
	}
	
}
