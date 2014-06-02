	import java.util.*;
	
	class HuvudProgram {
	
		Scanner tangentbord = new Scanner(System.in);	
		ArrayList<Person> personer = new ArrayList <Person>();
	
		Person getPerson(String namn){
		    for (Person p : personer)
			if (p.getNamn().equalsIgnoreCase(namn))
			    return p;
		    return null;
		}
		
		String readString(String fråga){
		    System.out.print(fråga);
		    String str=tangentbord.nextLine();
		    return str;
		}
		
		int readInt(String fråga){
		    for(;;){
			try{
			    System.out.print(fråga);
			    int x=Integer.parseInt(tangentbord.nextLine());
			    return x;
			}
			catch (NumberFormatException e){
			    System.out.println("Fel - ska vara ett numeriskt värde");
			}
		    }
		}
		
		int kommando(){
		    for(;;){
			int val=readInt("\n1 Skapa person\n2 Skapa pryl\n3 Visa alla" +
					"\n4 Visa rikaste\n5 Visa viss person\n6 Börskrasch" +
					"\n7 Avsluta\n\nDitt val: ");
			if (val>=1 && val<=7)
			    return val;
			System.out.println("Felaktigt kommando, ska vara 1-7\n");
		    }
		}
	
	
	
		void skapaPerson(){
		    String namn=readString("Namn: ");
		    if (getPerson(namn)!=null){
			System.out.println("Personen finns redan.");
			return;
		    }
		    Person ny=new Person(namn);
		    personer.add(ny);   
		}
		
		void skapaPryl(){
		    String pryl=readString("Vilken sorts pryl (Smycke, Aktie eller Apparat)?: ");
		    if (pryl.equalsIgnoreCase("Smycke")||pryl.equalsIgnoreCase("Aktie")||pryl.equalsIgnoreCase("Apparat")){
		
			String ägare=readString("Vilken person äger prylen: ");
			if (getPerson(ägare)==null){
			    System.out.println("Personen finns inte.");
			    return;
			}
			Person owner = getPerson(ägare);
			
			if (pryl.equalsIgnoreCase("Smycke")){
			    String sort=readString("Vilken sorts smycke?: ");
			    String material=readString("Är smycket av guld?: ");
			    int ädel=readInt("Antal ädelstenar: ");
			    Smycke nytt=new Smycke(sort, material, ädel);
			    owner.addPryl(nytt);
			}
			else if (pryl.equalsIgnoreCase("Aktie")){
			    String namn=readString("Namn på aktien: ");
			    int antal=readInt("Antal: ");
			    int pris=readInt("Pris: ");
			    Aktie ny=new Aktie(namn, antal, pris);
			    owner.addPryl(ny);
			}
			else if (pryl.equalsIgnoreCase("Apparat")){
			    String namn=readString("Namn: ");
			    int pris=readInt("Inköpspris: ");
			    int slitage=readInt("Slitage (1-10):");
			    Apparat ny=new Apparat(namn, pris, slitage);
			    owner.addPryl(ny);
		    }		
		    }
		    else
			System.out.println("Ogiltig pryl");
		}
	
			
	       
		void visaAlla(){            
		    System.out.println("I registret finns: ");
		    for (Person p : personer){
			System.out.println(p.getNamn()+"   " +p.summaVärde());
		    }
		}
		
		void visaRikaste(){        
		    int störstVärde = 0;
		    Person rikast = null;
		    if (personer.size()==0){
			System.out.println("Det finns inga personer i registret än");
			return;
		    }
		    for (Person p : personer){
			if (p.summaVärde()>=störstVärde){
			    störstVärde=p.summaVärde();
			    rikast=p;
			}
		    }
		    
		    System.out.println("Rikast är "+rikast.getNamn() +" som sammanlagt äger " +rikast.summaVärde());
		   
		    rikast.visaPrylar();
		}
	
		void visaVissPerson(){
		    String namn=readString("Namn: ");
		    for (Person p : personer)
			if (p.getNamn().equalsIgnoreCase(namn)){
			    System.out.println(namn+" äger sammanlagt "+p.summaVärde());
			    p.visaPrylar();
			}
		}
		
		void börskrasch(){
		    for (Person p : personer)
			p.börskrasch();
		}
		    
	
	
	
	       
		public static void main (String[]args){
		    HuvudProgram hp = new HuvudProgram();
		    System.out.println("Hej och välkommen till Prylprogrammet!");
		    int val=0;
		    
		    do{
			val=hp.kommando();
			switch (val) {
			case 1: hp.skapaPerson(); break;
			case 2: hp.skapaPryl(); break;
		    case 3: hp.visaAlla(); break;
			case 4: hp.visaRikaste(); break;
			case 5: hp.visaVissPerson(); break;
			case 6: hp.börskrasch(); break;
			case 7: System.out.println("Tack och hej då!");
			}
		    }
		    while (val!=7); 
		    
		}
	
	}
