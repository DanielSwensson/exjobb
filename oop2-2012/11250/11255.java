
import java.util.ArrayList;
import java.util.Scanner;
 
public class Register {
 
    private static Scanner keyboard;

	public static void main(String[] args) {
        keyboard = new Scanner(System.in);
        
        ArrayList<Person> PersonRegister = new ArrayList<Person>();
        while(true){
            System.out.println("1. Skapa person");
            System.out.println("2. Skapa pryl");
            System.out.println("3. Visa alla");
            System.out.println("4. Visa rikaste");
            System.out.println("5. Visa viss person");
            System.out.println("6. Börskrash");
            System.out.println("7. Avsluta");
            System.out.println( "Skriv in siffran som du vill göra: ");
            int val = keyboard.nextInt();
            switch(val){
 
            case 1:                
 
                System.out.print("Ange namnet på personen: ");
                String namn = keyboard.next();    
 
                boolean hittad = false;
                for (int x=0; x<PersonRegister.size(); x++){
                    if (PersonRegister.get(x).getNamn().equals(namn)){
                        System.out.println("Personen finns redan");
                        hittad = true;
                    }
                }
       
 
                if (hittad == false){
                    Person p = new Person(namn);
                    PersonRegister.add(p);
                    System.out.println("Personen " + namn + " är nu tillagd!");
                }
                break;                
 
            case 2:
                System.out.println("Vilken person ska äga prylen: ");
                String personnamn = keyboard.next();
                Person p = null;
                for (int x=0; x<PersonRegister.size(); x++){
                    if (PersonRegister.get(x).getNamn().equals(personnamn)){
                        p = PersonRegister.get(x);
                    }
                }
 
                if (p == null){
                    System.out.println("Personen finns inte");
                    break;
                }
 
                System.out.println("Vilken sorts pryl ska den äga: ");
                while(true){
                    System.out.println("1. Smycke");
                    System.out.println("2. Aktie");
                    System.out.println("3. Apparat");
                    int valtvå = keyboard.nextInt();
                    switch(valtvå){
 
                    case 1:
                        System.out.println("Vad är det för smycke (namn):  ");
                        String smyckesnamn = keyboard.next();
 
                        System.out.println("Vad är det för material (Guld eller Silver): ");
                        String material = keyboard.next();
 
                        System.out.println("Hur många ädelstenar: ");
                        int antalädelstenar = keyboard.nextInt();
 
 
 
                        Pryl a = new Smycken(smyckesnamn, material, antalädelstenar);
 
                        System.out.println("Smycket " + a + " är nu tillagd");
                        p.läggatillpryl(a);
                        break;
 
                    case 2:
                        System.out.println("Aktienamn: ");
                        String aktienamn = keyboard.next();
                        System.out.println("Antal aktier: ");
                        double aktieantal = keyboard.nextDouble();
                        System.out.println("Vad är priset på aktierna: ");
                        double aktiepris = keyboard.nextDouble();
 
                        Pryl ak = new Aktier(aktienamn, aktieantal, aktiepris);
 
                        System.out.println("Aktien " + ak + " är nu tillagd");
                        p.läggatillpryl(ak);
                        break;
 
                    case 3:
                        System.out.println("Vad är det för apparat: ");
                        String apparatnamn = keyboard.next();
                        System.out.println("Vilket var inköpspriset: ");
                        double inköpspris = keyboard.nextInt();
                        System.out.println("Hur mycket är slitaget (skala 1-10): ");
                        double slitage = keyboard.nextInt();
 
                        Pryl ap = new Apparater(apparatnamn, slitage, inköpspris);
 
                        System.out.println("Apparaten " + ap + " är nu tillagd");
                        p.läggatillpryl(ap);
                        break;
 
                    default:
                        System.out.println("Alternativet" + valtvå + " finns inte");
                        break;
 
                    }
                    break;
                }
                break;
            case 3:
                System.out.println("I Registret finns: ");
                System.out.println( PersonRegister.size() + " Stycken personer enligt följande: ");
                for(Person thisPerson: PersonRegister){
                    System.out.print(thisPerson);
 
 
                }
                break;
 
            case 4:
                Person p1 = new Person("ingen");
                for (int x=0; x<PersonRegister.size(); x++){
 
                    if (p1.totalVärde() < PersonRegister.get(x).totalVärde()){
                        p1 = PersonRegister.get(x);
                    }
                }
                System.out.println("Rikaste personen är: " + p1);
               
 
                break;
               
            case 6:    
                for (Person x: PersonRegister) {
                    for (Pryl thisPryl: x.getPryllista()){
                        if (thisPryl instanceof Aktier){
                            ((Aktier) thisPryl).setVärde0();
                        }
                    }
                }
                System.out.println("Alla aktier har nu värdet 0");
                break;
 
 
            case 5:
                System.out.println("Vilken person vill du lista: ");
                String personnamnet = keyboard.next();
                Person pe = null;
                for (int x=0; x<PersonRegister.size(); x++){
                    if (PersonRegister.get(x).getNamn().equals(personnamnet)){
                        pe = PersonRegister.get(x);
 
                    }
                }
 
                if (pe == null){
                    System.out.println("Personen finns inte");
 
                }
                for(Person thisPerson: PersonRegister){
                    System.out.println(thisPerson);    
                }
                break;
 
       
            case 7:
                System.exit(1);
                break;
            default:
                System.out.println("Alternativet" + val + " finns inte");
                break;
            }
        }
    }
 
}
