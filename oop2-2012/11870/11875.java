package prylregister;

import java.util.*;
public class Prylregister {
    Scanner keyboard = new Scanner(System.in);
    ArrayList<Person>people =new ArrayList<Person>();
	int readInt(String frågan){
            int val =0;
            boolean felaktigt;
                do{
                    System.out.print(frågan+" ");
                    try{
                        val =Integer.parseInt(keyboard.nextLine());
                        felaktigt =false;
                    }
                    catch (NumberFormatException e){
                        System.out.println("felaktigt värde. Skriv ett heltal");
                        felaktigt =true;
                    }
                }
        	while (felaktigt);
                return val;
        }
        String readString(String frågan){
            System.out.print(frågan+" ");
            String str =keyboard.nextLine();
            return str;
        }
        boolean compareStrings(String compare, String input){
            if(compare.equalsIgnoreCase(input)) {
                return true;
            }
            else {
                return false;
            }
        }
        Person getPerson(String name){
            for (Person p: people){
                if (compareStrings(p.getName(),name)) {
                    return p;
                }
            }
            return null;
        }
void createPerson(){
            String name =readString("Skriv ett namn för att lägga till en person:");
            Person p =getPerson(name);
            if (p !=null) {
                System.out.println("Person med angivet namn existerar redan");
            }
            else{
                Person p1 =new Person(name);
                people.add(p1);
                System.out.println(name +" har lagts till i registret.");
            }
        }
void createPryl (){
    String name =readString("Ange namn på ägare:");
    for (int x=0; x<people.size();x++){
        if(people.get(x).getName().equals(name)){
            int val =readInt("1: Smycke \n2: Aktie \n3: Apparat \n Välj (1-3)");
            if (val==1){
                String str =readString("Typ av smycke?");
                boolean bol =compareStrings(readString("Är det gjort av guld? (y/n)"),"y");
                int nrOfStones =readInt("antal ädelstenar?");
                Smycke s =new Smycke(str, bol, nrOfStones);
                people.get(x).addPryl(s);
            }
            if (val==2){
                String str =readString("Namn på aktie?");
                int nrOfStocks =readInt("Antal aktier?");
                double stockPrice =readInt("Inköpspris för aktien/erna?");
                Aktie a =new Aktie (str, nrOfStocks, stockPrice);
                people.get(x).addPryl(a);
            }
            if (val==3){
                String str =readString("Namn på apparat?");
                double buyingPrice =readInt("Inköpspriset för apparaten?");
                int currentWear =readInt ("Hur mycket slitage har apparaten?");
                Apparat t =new Apparat(str, buyingPrice, currentWear);
                people.get(x).addPryl(t);
            }
        }
    }
}
void visaAlla(){
    if (people.isEmpty()) {
        System.out.println("Registret är tomt.");
    }
    else{
        System.out.println("I registret finns: ");
        for (int x =0; x<people.size();x++) {
            System.out.println(people.get(x).getName()+"\t"+people.get(x).getTotalValue());
        }
    }
}
void visaRikaste(){
    if (people.isEmpty()) {
        System.out.println("Registret är tomt.");
    }
    else{
        Person rikaste =null;
        int rikasteSumma =0;
        for(int x =0; x<people.size();x++){
            if(people.get(x).getTotalValue()> rikasteSumma){
                rikasteSumma =people.get(x).getTotalValue();
                rikaste =people.get(x);
                System.out.println(rikasteSumma);
                }
            } System.out.println("Rikast är "+rikaste.getName()+" som äger prylar till ett värde på "+ rikaste.getTotalValue()+"\n"+rikaste.listPryl());
     }
}
void visaViss(){
    if (people.isEmpty()) {
        System.out.println("Registret är tomt.");
    }
    else{
         Person p;
         do{
             String name =readString("Skriv ett namn: ");
             p =getPerson(name);
             if(p==null) {
                 System.out.println("personen finns ej i registret");
             }
             else {
                 System.out.println(p.getName()+ " äger: \n"+p.listPryl());
             }
         }while(p == null);
    }    
}
void börskrasch(){
    for (Person p: people){
        p.setAktieValue(0);
    }
}        
    public static void main(String[] args) {
        Prylregister method =new Prylregister();
        System.out.println("Prylregister");
        System.out.println("\n1: Lägg till person\n2: Lägg till ägodel\n3: Visa alla personer i registret\n4: Visa den rikaste personen i registret\n5: Visa en viss person\n6: Börskrasch\n7: Avsluta Programmet\n");
        for(;;){
            int selection=method.readInt("Välj ett alternativ 1-7:");
            System.out.println("Du har valt "+selection);
                switch(selection){
                    case 1:method.createPerson();break;
                    case 2:method.createPryl();break;
                    case 3:method.visaAlla();break;
                    case 4:method.visaRikaste();break;
                    case 5:method.visaViss();break;
                    case 6:method.börskrasch();break;
                    case 7:System.out.print("Nu avslutas programmet");System.exit(0);
                    default:System.out.println("felaktigt kommando");
                        
                }
        }
    }
}