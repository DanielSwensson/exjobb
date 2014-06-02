import java.util.Scanner;
import java.util.ArrayList;

public class Registrering {

    ArrayList<Person> personer=new ArrayList<Person>();
    Scanner scan=new Scanner(System.in);
			
    int readInt(String fråga){
        for(;;){
            try{
            	System.out.print(fråga);
                int x=Integer.parseInt(scan.nextLine());
                return x;
  }		catch(NumberFormatException ex){
                System.out.println("Fel inmatning, ange med siffror!");
            }
        }
    }
    
    	String readString(String fråga){
        		System.out.print(fråga);
        String str=scan.nextLine();
        return str;
    }
	
    Person getPerson(String namn)	{
        if(personer.size()>0){
            for(Person p : personer)	{
                if(p.getNamn().equalsIgnoreCase(namn))
                    return p;
            }
        }
        return null;
    }
							
    void skapaAktier(Person p){
        String namn=readString("Vilken aktie? ");
        int pris=readInt("Hur mycket är aktien värd? ");
        int antal=readInt("Antal aktier?: ");
        p.addPryl(new Aktier(namn, antal, pris));
    }
    
    void skapaApparat(Person p){
        String namn=readString("Vilken sorts apparat? ");
        int pris=readInt("Inköpspris: ");
        int slitage=readInt("Slitage mellan (1-10): ");
        p.addPryl(new Apparat(namn, pris, slitage));
    }
    
    void skapaSmycken(Person p){
        String namn=readString("Vilken sorts smycke? ");
        int stenar=readInt("Hur många ädelstenar? ");
        String material;
        for(;;){
            material=readString(" Är smycket av guld? (ja/nej) ");
            if(material.equalsIgnoreCase("ja")||material.equalsIgnoreCase("nej")){
                break;
            }
            else
                System.out.print("Svara med ja eller nej.\n");
        }
        p.addPryl(new Smycken(namn, stenar, material));
    }
    
    
    void skapaPerson(){
        String namn = readString("Personens namn: ");
        Person p=getPerson(namn);
        if(p!=null)
            System.out.println("Personen finns redan.");
        else{
            Person nyperson=new Person(namn);
            personer.add(nyperson);
            System.out.print("Personen "+namn+" skapades.\n");
        }
        
    }
    
    void skapaPryl(){
        String namn=readString("Namn på ägare: ");
        Person p=getPerson(namn);
        if(p==null)
            System.out.println("Personen finns inte.\n");
        else{
            String typ;
            for(;;){
                typ=readString("Vilken typ av pryl? (smycken/apparat/aktier) ");
                if(typ.equalsIgnoreCase("smycken")||typ.equalsIgnoreCase("apparat")||typ.equalsIgnoreCase("aktier"))
                    break;
                else
                    System.out.print("\nSvara med smycke/apparat/aktie\n");        
            }
            if(typ.equalsIgnoreCase("Smycken")){
                skapaSmycken(p);
            }
            else if(typ.equalsIgnoreCase("Apparat")){
                skapaApparat(p);
            }
            else if(typ.equalsIgnoreCase("Aktier")){
                skapaAktier(p);
            }        
        }
    }
    
				
    void visaAlla(){
        String alla="";
        for(Person p : personer){
            alla+=p.toString();
        }
        System.out.print(alla);
    }
    
    void visaPerson(){
        String namn=readString("Ange namn på önskad person ");
        Person Ägare=getPerson(namn);
        if(Ägare!=null){
            System.out.print(Ägare);
            System.out.print(Ägare.visaPrylar());    
        }
        else
            System.out.print("Personen finns ej");
    }
    
    void visaRikast(){
        Person rikast=personer.get(0);
        for(Person p : personer){
            if(p.getRikast()>rikast.getRikast()){
                rikast=p;
            }
        }
        System.out.print(rikast);
        System.out.print(rikast.visaPrylar());
    }
    
				
    void börskrasch(){
        for(Person p : personer){
            for(Pryl pr : p.getPrylar()){
                if(pr instanceof Aktier){
                    ((Aktier)pr).krasch();
                }
            }
        }
        System.out.println("Börskrasch!");
    }
    

	
    public static void main(String[] args){
        Registrering hp=new Registrering();
        System.out.println("Välkommen till registrering av dina värdesaker!");
        System.out.println();
        System.out.println("//////////////////////");
        for(;;){
            System.out.print("\n\n1. Skapa person.\n2. Skapa pryl.\n3. Visa alla.\n4. Visa rikaste.\n5. Visa viss person.\n6. Börskrasch.\n7. Avsluta.\n\n");
            int kommando=hp.readInt("Välj ett kommando! ");
            switch(kommando){
            case 1: 
                hp.skapaPerson();
                break;
            case 2:
                hp.skapaPryl();
                break;
            case 3:
                hp.visaAlla();
                break;
            case 4:
                hp.visaRikast();
                break;
            case 5:
                hp.visaPerson();
                break;
            case 6:
                hp.börskrasch();
                break;
            case 7:
            	System.exit(0);
                break;
            default:
                break;
            }
        }
    }
}
