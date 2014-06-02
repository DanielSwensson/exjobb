
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
            System.out.println("6. B�rskrash");
            System.out.println("7. Avsluta");
            System.out.println( "Skriv in siffran som du vill g�ra: ");
            int val = keyboard.nextInt();
            switch(val){
 
            case 1:                
 
                System.out.print("Ange namnet p� personen: ");
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
                    System.out.println("Personen " + namn + " �r nu tillagd!");
                }
                break;                
 
            case 2:
                System.out.println("Vilken person ska �ga prylen: ");
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
 
                System.out.println("Vilken sorts pryl ska den �ga: ");
                while(true){
                    System.out.println("1. Smycke");
                    System.out.println("2. Aktie");
                    System.out.println("3. Apparat");
                    int valtv� = keyboard.nextInt();
                    switch(valtv�){
 
                    case 1:
                        System.out.println("Vad �r det f�r smycke (namn):  ");
                        String smyckesnamn = keyboard.next();
 
                        System.out.println("Vad �r det f�r material (Guld eller Silver): ");
                        String material = keyboard.next();
 
                        System.out.println("Hur m�nga �delstenar: ");
                        int antal�delstenar = keyboard.nextInt();
 
 
 
                        Pryl a = new Smycken(smyckesnamn, material, antal�delstenar);
 
                        System.out.println("Smycket " + a + " �r nu tillagd");
                        p.l�ggatillpryl(a);
                        break;
 
                    case 2:
                        System.out.println("Aktienamn: ");
                        String aktienamn = keyboard.next();
                        System.out.println("Antal aktier: ");
                        double aktieantal = keyboard.nextDouble();
                        System.out.println("Vad �r priset p� aktierna: ");
                        double aktiepris = keyboard.nextDouble();
 
                        Pryl ak = new Aktier(aktienamn, aktieantal, aktiepris);
 
                        System.out.println("Aktien " + ak + " �r nu tillagd");
                        p.l�ggatillpryl(ak);
                        break;
 
                    case 3:
                        System.out.println("Vad �r det f�r apparat: ");
                        String apparatnamn = keyboard.next();
                        System.out.println("Vilket var ink�pspriset: ");
                        double ink�pspris = keyboard.nextInt();
                        System.out.println("Hur mycket �r slitaget (skala 1-10): ");
                        double slitage = keyboard.nextInt();
 
                        Pryl ap = new Apparater(apparatnamn, slitage, ink�pspris);
 
                        System.out.println("Apparaten " + ap + " �r nu tillagd");
                        p.l�ggatillpryl(ap);
                        break;
 
                    default:
                        System.out.println("Alternativet" + valtv� + " finns inte");
                        break;
 
                    }
                    break;
                }
                break;
            case 3:
                System.out.println("I Registret finns: ");
                System.out.println( PersonRegister.size() + " Stycken personer enligt f�ljande: ");
                for(Person thisPerson: PersonRegister){
                    System.out.print(thisPerson);
 
 
                }
                break;
 
            case 4:
                Person p1 = new Person("ingen");
                for (int x=0; x<PersonRegister.size(); x++){
 
                    if (p1.totalV�rde() < PersonRegister.get(x).totalV�rde()){
                        p1 = PersonRegister.get(x);
                    }
                }
                System.out.println("Rikaste personen �r: " + p1);
               
 
                break;
               
            case 6:    
                for (Person x: PersonRegister) {
                    for (Pryl thisPryl: x.getPryllista()){
                        if (thisPryl instanceof Aktier){
                            ((Aktier) thisPryl).setV�rde0();
                        }
                    }
                }
                System.out.println("Alla aktier har nu v�rdet 0");
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
