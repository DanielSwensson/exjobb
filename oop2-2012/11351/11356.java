package prylregister;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Prylregister{
    ArrayList<Person> allaPersoner = new ArrayList<>();
    Scanner tangentbord = new Scanner(System.in);
 
    private int readInt(String fråga){
        while (true){ 
            try{
                System.out.print(fråga);
                int x=Integer.parseInt(tangentbord.nextLine());
                return x;
            }
            catch (NumberFormatException e){
                System.out.println("Felaktig inmatning, måste vara ett nummer. Försök igen.");
            }
        }
    }
 
    private String readString(String fråga){
        while (true){
            System.out.print(fråga);
            String str = tangentbord.nextLine();
            if (str.isEmpty()){
                System.out.println("Felaktig inmatning, försök igen.");
            }else{
                return str;    
            }
        }
    }
 
    private boolean readBoolean(String fråga){
        while (true){
            System.out.print(fråga);
            String str = tangentbord.nextLine();
                if (str.equalsIgnoreCase("ja")){
                    boolean b = true;
                    return b;
                }else if (str.equalsIgnoreCase("nej")){
                    boolean b = false;
                    return b;
                }else{
                    System.out.println("Ogiltig inmatning.");
                } 
        }
    }
 
    private Person getPerson(String namn){
        for (Person p : allaPersoner){
            if (p.getNamn().equalsIgnoreCase(namn)){
                return p;
            }
        }
        return null;
    }
 
    private void skapaPerson(){
        String namn = readString("Personens namn: ");
        Person p = getPerson(namn);
        if (p != null){
            System.out.println("Den personen finns redan");
        }else{
            Person ny = new Person(namn);
            allaPersoner.add(ny);
            System.out.println("> "+namn+" är skapad.");
            System.out.println();
            System.out.println();
        }
    }
 
    private void skapaPryl() {
        Person ägare;
        while (true) {
            String namn = readString("Vilken person äger prylen: ");
            ägare = getPerson(namn);
            if (ägare != null) {
                break;
            } else {
                System.out.println("Personen du angav finns inte. Försök igen.");
            }
        }
        while (true){
            int sort = readInt("Vilken sorts pryl? 1 = Smycke, 2 = Aktie, 3 = Apparat: ");
            Pryl ny;
            if (sort == 1){
                String namnSmycke = readString("Vilken sorts smycke: ");
                int ädelstenAntal = readInt("Hur många ädelstenar har smycket? ");
                boolean avGuld = readBoolean("Är smycket av guld, ja/nej? ");
 
                ny = new Smycke(namnSmycke, ädelstenAntal, avGuld);
                ägare.prylsamling.add(ny);
                System.out.println("> "+namnSmycke+" lades till bland smyckena i "+ägare+"s prylsamling.");
                System.out.println();
                return;
            }
            if (sort == 2){
                String namnAktie = readString("I vilket företag gäller aktien? ");
                int antalAktie = readInt("Hur många aktier? ");
                int prisPer = readInt("Vad är priset per aktie? ");
 
                ny = new Aktie(namnAktie, antalAktie, prisPer);
                ägare.prylsamling.add(ny);
                System.out.println("> "+namnAktie+" lades till bland aktierna i "+ägare+"s prylsamling.");
                System.out.println();
                return;
            }
            if (sort == 3){
                String namnApparat = readString("Vilken typ av apparat? ");
                int prisInköp = readInt("Inköpspris: ");
                int apparatSlitage = readInt("Ange slitage, värde 1-10 (1 = mycket dåligt skick, 10 = nyskick): ");
 
                ny = new Apparat(namnApparat, prisInköp, apparatSlitage);
                ägare.prylsamling.add(ny);
                System.out.println("> "+namnApparat+" lades till bland apparaterna i "+ägare+"s prylsamling.");
                System.out.println();
                return;
            }else{
                System.out.println("Ogiltigt val, försök igen");
            }
        }
    }
 
    private void visaAlla(){
       System.out.println("I registret finns: ");
       for (Person p : allaPersoner) {
            System.out.print(p.getNamn());
            System.out.print(" har prylar med ett sammanlagt värde av ");
            System.out.println(p.getTotaltVärde());
            System.out.println();
        }
    }
 
    private void visaRikaste(){
        int jämförVärde = 0;
        String rikast = null;
        for (Person p : allaPersoner){
            if (p.getTotaltVärde() > jämförVärde){
                rikast = p.getNamn();
                jämförVärde = p.getTotaltVärde();
            }
        }
        System.out.println("Rikaste är "+rikast+" med det totala värdet "+jämförVärde+"");
        System.out.println();
    }
 
    private void visaViss(){
        while (true){
            String person = readString("Vems prylar vill du visa? ");
            for (Person p : allaPersoner){
                if (p.getNamn().equalsIgnoreCase(person)){
                    System.out.print(person);
                    System.out.println(" äger följande prylar: ");
                    System.out.println(p.getPryllista());
                    System.out.println();
                    return;
                }
            }
            System.out.println("Personen du angav finns inte med i registret");
        }
    } 
 
    private void börskrasch(){
        System.out.println("Oj, nu tryckte du på något som kraschade hela börsen... ");
        for (Person p : allaPersoner){
            for (Pryl pr : p.prylsamling){
                if (pr instanceof Aktie){
                    p.krasch();
                }
            }
        }
        System.out.println("Nu har alla aktier tappat sitt värde.");
        System.out.println();
    }
 
    public static void main(String[] args){
        Prylregister pr = new Prylregister();
        System.out.println("Hej och välkommen till register över värdesaker!");
        System.out.println();
 
        while (true){
            System.out.println("Kommandomeny: ");
            System.out.println();
            System.out.println("1. Skapa ny person");
            System.out.println("2. Skapa ny pryl");
            System.out.println("3. Visa alla");
            System.out.println("4. Visa rikaste person");
            System.out.println("5. Visa viss person");
            System.out.println("6. Börskrasch!");
            System.out.println("7. Avsluta program");
            System.out.println();
 
            int val = pr.readInt("Välj vad du vill göra: ");
 
            switch (val){
                case 1:
                    pr.skapaPerson();
                    break;
                case 2:
                    pr.skapaPryl();              
                    break;
                case 3:
                    pr.visaAlla();
                    break;
                case 4:
                    pr.visaRikaste();
                    break;
                case 5:
                    pr.visaViss();
                    break;
                case 6:
                    pr.börskrasch();
                    break;
                case 7:
                    System.out.println("Programmet avslutas.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Felaktigt kommando.");
            }//switch
        } //while
    } //main
} //class