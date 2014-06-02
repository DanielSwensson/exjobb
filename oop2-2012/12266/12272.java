import java.util.Scanner;
import java.util.ArrayList;

public class TestProgram {
	
	static ArrayList<Person> allaPersoner= new ArrayList<Person>();
	static Scanner keyboard= new Scanner(System.in);
	
	public void listaAllaPrylar(){
		String n= readString("Vems prylar ska listas: ");
		Person p = getPerson(n);
		
		if(p==null){
			System.out.println("Den h�r personen finns inte");
		}else{
			for(int x = 0; x<p.antalPrylar();x++){
				System.out.println(p.getPrylar(x));
			}
		}
	}

	
	public Person getPerson(String namn){ 
	        if(allaPersoner.size()>0){ 
	            for(Person p : allaPersoner){ 
	                if(p.getNamn().equalsIgnoreCase(namn)) 
	                    return p; 
	            }
	        }
	        return null;
	}
	
	public void skapaPerson() {
		String namn = readString("Nya personens namn: ");
		Person p =getPerson(namn);
		if(p!=null){
			System.out.println("Den personen finns redan");
		}else{
			Person ny= new Person(namn);
			allaPersoner.add(ny);
			System.out.println(ny.getNamn()+" har lagts till i registret");
		}
	}
	

	public void skapaPryl (){
		String n= readString("Namn p� �gare: ");
		Person p = getPerson(n);
		if(p==null){
			System.out.println("Den h�r personen finns inte");
		}else{
		
			int sort = readInt("Vilken sorts pryl: (1=Apparat, 2=Aktie, 3=Smycke): ");
			
			if(sort==1){	
				String namn= readString("Namnge apparat: ");
				int ink�pspris = readInt("Ange Ink�pspris: ");
				int slitage = readInt("Ange slitage:(1-Mycket sliten, 10-Helt ny):  ");	
			 Prylar a= new Apparater(namn, ink�pspris, slitage);	
				p.l�ggTillPryl(a);
			}
		
			else if(sort==2){
				String namn= readString("Namnge aktie: ");
				System.out.print("Aktie");
				double prisAktie= readDouble("Ange pris per aktie: ");
				int antalAktier= readInt("Ange antal aktier: ");
				p.l�ggTillPryl(new Aktier(namn, prisAktie, antalAktier));
			
			}else{
				String namn= readString("Namnge smycke: ");
				String metall = readString("Ange typ av metall: (Guld eller Silver: ");
				int �delstenar= readInt("Ange antal �delstenar: ");
				p.l�ggTillPryl(new Smycken(namn, metall, �delstenar));
			
		}
		}System.out.println("Prylen har lagts till i registret");	
		
		
	}
	
	
	public void visaAllaPersoner(){
		System.out.println("I registret finns: ");
		for(int x = 0; x<allaPersoner.size();x++){
			Person p= allaPersoner.get(x);
			System.out.println(allaPersoner.get(x)+"    Totalt v�rde:"+p.summaPrylar());
		}System.out.println();
	}
	
	public void visaRikaste(){
		Person rikast= allaPersoner.get(0);
		 for(int y=0; y<allaPersoner.size(); y++){
			
			Person p= allaPersoner.get(y);
			if(p.summaPrylar()>rikast.summaPrylar()){
				rikast = p;	
			}
			
		
		 }System.out.println(rikast.toString()+"    Total f�rm�genhet: "+rikast.summaPrylar());
	}
	
	public void visaVissPerson(){
		String n= readString("Vilken person ska listas: ");
		System.out.println();
		Person p= getPerson(n);
		if(p==null){
			System.out.println("Den h�r personen finns inte");
		}else{
			
			System.out.println(getPerson(n)+ "Total f�rm�genhet: "+p.summaPrylar());
			System.out.println();
			for(int x=0; x<p.antalPrylar(); x++){
				
				System.out.println(p.getPrylar(x));
			
			}
		
		}
	}

	public void b�rsKrasch(){
		Prylar a= null;
		 Person p=null;
		 
		 for(int y=0; y<allaPersoner.size(); y++){
			 p= allaPersoner.get(y);
		 
			 for(int x=0; x<p.antalPrylar(); x++){
		
				 a= p.getPrylar(x);
				if(a instanceof Aktier){
				 a.krasch();
				}
			 }
		 }System.out.println("B�rskrasch!!!");
			 
		 
	  }   

	
	public void avslutaProgrammet(){
		System.out.println("Avslutar programmet");
		System.exit(0);
	}
	
	public int readInt(String fr�ga){
		for(;;){		
			try{
				System.out.print(fr�ga);
				int	x = Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Fel - skall vara numeriskt v�rde");
			}
		}	
	}
	
	public double readDouble(String fr�ga){
		for(;;){
			try{
				System.out.print(fr�ga);
				double x = Double.parseDouble(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Fel - skall vara decimal tal - ex 1.0");
			}
		}
	}
	
	public String readString(String fr�ga){
		System.out.print(fr�ga);
		String str= keyboard.nextLine();
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println("Hej och v�lkommen till PrylProgrammet");
		
		TestProgram tp = new TestProgram();
		System.out.println("1. Skapa ny person. \n2. Lista alla personer \n3. Skapa Pryl \n4.Lista viss persons alla prylar \n5.B�rskrasch  \n6. Visa rikaste \n7. Avsluta programmet");
	
		for(;;){
			
			System.out.print(">");
			
			String command = keyboard.nextLine();
			
			switch(command){	
			
				case "dir":
					System.out.println("1. Skapa ny person. \n21. Lista alla personer \n3. Skapa Pryl \n4.Lista viss persons alla prylar" +
							" \n5.B�rskrasch \n6. Visa rikaste \n7. Avsluta programmet");
					break;
						
				case "1": tp.skapaPerson();	break;
							
				case "2": tp.visaAllaPersoner(); break;
					
				case "3": tp.skapaPryl(); break;
		
				case "4": tp.visaVissPerson(); break;	
				
				case "5": tp.b�rsKrasch(); break;
				
				case "6": tp.visaRikaste(); break;
				
				case "7": tp.avslutaProgrammet(); break;
			
				default :
					System.out.println();
					System.out.println("Felaktigt kommando");
			
			
	
			}//switch
	
		}//for
		
	
		
		
	
		
		
		
	//	System.out.println(p.allaPrylar.get(0));
	
		

	}

}
