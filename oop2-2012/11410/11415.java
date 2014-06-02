package Projekt;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
public class MainClass {

    public static void main(String[] args) {
        ArrayList<Djur> djurlista = new ArrayList<Djur>();
        try{
            FileInputStream f = new FileInputStream("SparaDjuren.obj");
            ObjectInputStream in = new ObjectInputStream(f);
            djurlista = (ArrayList<Djur>)in.readObject();
        }
        catch(FileNotFoundException e){
        }
        catch(IOException e){
            System.out.print("Ett fel påträffades!\nProgram avslutat.\n");
            System.exit(1);
        }
        catch(ClassNotFoundException e){
            System.out.print("Ett fel påträffades!\nProgram avslutat.\n");
            System.exit(1);
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("SKAPA DIG ETT EGET SUPERMONSTER\n\n");
        System.out.print("Välj ett djur nedan, och gör det till ett MONSTER!\n\n");
        System.out.print("*\n1. Skapa haj\n2. Skapa lejon\n3. Skapa orm\n4. Skapa spindel\n-\n5. Visa skapade djur\n6. Jaga\n7. Ta bort djur\n8. Töm registret\n9. Avsluta\n*\n\n");
        System.out.print("Kommando: ");
        int commando = returnInt();
        for(;;){
            if(commando == 1){
                hajskapande(djurlista);
                System.out.print("\n\n*\n1. Skapa haj\n2. Skapa lejon\n3. Skapa orm\n4. Skapa spindel\n-\n5. Visa skapade djur\n6. Jaga\n7. Ta bort djur\n8. Töm registret\n9. Avsluta\n*\n\nKommando: ");
                commando = returnInt();
            }
            else if(commando == 2){
                lejonskapande(djurlista);
                System.out.print("\n\n*\n1. Skapa haj\n2. Skapa lejon\n3. Skapa orm\n4. Skapa spindel\n-\n5. Visa skapade djur\n6. Jaga\n7. Jaga\n7. Ta bort djur\n8. Töm registret\n9. Avsluta\n*\n\nKommando: ");
                commando = returnInt();
            }
            else if(commando == 3){
                ormskapande(djurlista);
                System.out.print("\n\n*\n1. Skapa haj\n2. Skapa lejon\n3. Skapa orm\n4. Skapa spindel\n-\n5. Visa skapade djur\n6. Jaga\n7. Ta bort djur\n8. Töm registret\n9. Avsluta\n*\n\nKommando: ");
                commando = returnInt();
            }
            else if(commando == 4){
                spindelskapande(djurlista);
                System.out.print("\n\n*\n1. Skapa haj\n2. Skapa lejon\n3. Skapa orm\n4. Skapa spindel\n-\n5. Visa skapade djur\n6. Jaga\n7. Ta bort djur\n8. Töm registret\n9. Avsluta\n*\n\nKommando: ");
                commando = returnInt();
            
            }
            else if(commando == 5){
                kollaDjuren(djurlista);
                System.out.print("\n*\n1. Skapa haj\n2. Skapa lejon\n3. Skapa orm\n4. Skapa spindel\n-\n5. Visa skapade djur\n6. Jaga\n7. Ta bort djur\n8. Töm registret\n9. Avsluta\n*\n\nKommando: ");
                commando = returnInt();
            }
            else if(commando == 6){
                kollaDjuren4(djurlista);
                System.out.print("\n\n*\n1. Skapa haj\n2. Skapa lejon\n3. Skapa orm\n4. Skapa spindel\n-\n5. Visa skapade djur\n6. Jaga\n7. Ta bort djur\n8. Töm registret\n9. Avsluta\n*\n\nKommando: ");
                commando = returnInt();
            }
            else if(commando == 7){
                kollaDjuren2(djurlista);
                System.out.print("\n\n*\n1. Skapa haj\n2. Skapa lejon\n3. Skapa orm\n4. Skapa spindel\n-\n5. Visa skapade djur\n6. Jaga\n7. Ta bort djur\n8. Töm registret\n9. Avsluta\n*\n\nKommando: ");
                commando = returnInt();
            }
            else if(commando == 8){
                kollaDjuren3(djurlista);
                System.out.print("\n\n*\n1. Skapa haj\n2. Skapa lejon\n3. Skapa orm\n4. Skapa spindel\n-\n5. Visa skapade djur\n6. Jaga\n7. Ta bort djur\n8. Töm registret\n9. Avsluta\n*\n\nKommando: ");
                commando = returnInt();
            }
            else if(commando == 9){
                int kollar = 1;
                if(!(djurlista.isEmpty())){
                    kollar = 2;
                }
                try{
                    FileOutputStream f = new FileOutputStream("SparaDjuren.obj");
                    ObjectOutputStream out = new ObjectOutputStream(f);
                    out.writeObject(djurlista);
                }
                catch(IOException e){
                    System.out.print("\nEtt fel påträffades! Program avslutat.\n");
                    System.exit(1);
                }
                if(kollar == 2){
                    System.out.print("\nSparar djur...");
                    System.out.print("\nDjur sparade!\nProgram avslutat.\n");
                    System.exit(0); 
                }else{
                    System.out.print("\nProgram avslutat.\n");
                    System.exit(0);
                }
            }else{
                System.out.print("\nFel! Okänt kommando.\n\n*\n1. Skapa haj\n2. Skapa lejon\n3. Skapa orm\n4. Skapa spindel\n-\n5. Visa skapade djur\n6. Jaga\n7. Ta bort djur.\n8. Töm registret\n9. Avsluta\n*\n\nKommando: ");
                commando = returnInt();
            }
        }
    }
    private static void hajskapande(ArrayList<Djur> djurlista){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nSKAPA EN HAJ\n\nNamn: ");
        String namn = sc.nextLine();
        System.out.print("Vikt (kilogram): ");
        int vikt = returnInt();
        System.out.print("Antal tänder: ");
        int antalTänder = returnInt();
        System.out.print("Simhastiget (m/s): ");
        double simhastighet = returnDouble();
        System.out.print("Längd (meter): ");
        int längd = returnInt();
        Djur djur = new Haj(namn, vikt, antalTänder, simhastighet, längd);
        djurlista.add(djur);
        System.out.print("\n" + namn + " registrerad!");
    }
    private static void lejonskapande(ArrayList<Djur> djurlista){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nSKAPA ETT LEJON\n\nNamn: ");
        String namn = sc.nextLine();
        System.out.print("Vikt (kilogram): ");
        int vikt = returnInt();
        int mängdMuskler = lejonmuskler(vikt);
        Djur djur = new Lejon(namn, vikt, mängdMuskler);
        djurlista.add(djur);
        System.out.print("\n" + namn + " registrerad!");
    }
    private static int lejonmuskler(int vikt){
        Scanner sc = new Scanner(System.in);
        System.out.print("Mängd muskler (kilogram): ");
        int mängdMuskler = returnInt();
        while(mängdMuskler > vikt){
            System.out.print("\nFel! Mängden muskelmassa kan inte överstiga djurets totala vikt.\nMängd muskler (kilogram): ");
            mängdMuskler = returnInt();
        }
        return mängdMuskler;
    }
    private static void ormskapande(ArrayList<Djur> djurlista){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nSKAPA EN ORM\n\nNamn: ");
        String namn = sc.nextLine();
        System.out.print("Vikt (kilogram): ");
        int vikt = returnInt();
        System.out.print("Giftmängd per bett (milligram): ");
        double mängdGift = returnDouble();
        Djur djur = new Orm(namn, vikt, mängdGift);
        djurlista.add(djur);
        System.out.print("\n" + namn + " registrerad!");
    }
    private static void spindelskapande(ArrayList<Djur> djurlista){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nSKAPA EN SPINDEL\n\nNamn: ");
        String namn = sc.nextLine();
        System.out.print("Vikt (gram): ");
        int vikt = returnInt();
        System.out.print("Giftmängd per bett (milligram): ");
        double mängdGift = returnDouble();
        System.out.print("Antal taggar: ");
        int antalTaggar = returnInt();
        Djur djur = new Spindel(namn, vikt, antalTaggar, mängdGift);
        djurlista.add(djur);
        System.out.print("\n" + namn + " registrerad!");
    }
    private static void kollaDjuren(ArrayList<Djur> djurlista){
        int kontroll = 1;
        if(!(djurlista.isEmpty())){
            kontroll = 2;
            visaDjuren(djurlista);
        }
        if(kontroll == 1){
            System.out.print("\nInga djur finns registrerade!\n");
        }
    }
    private static void kollaDjuren2(ArrayList<Djur> djurlista){
        int kontroll = 1;
        if(!(djurlista.isEmpty())){
            kontroll = 2;
            taBortDjur(djurlista);
        }
        if(kontroll == 1){
            System.out.print("\nInga djur finns registrerade!");
        }
    }
    private static void kollaDjuren3(ArrayList<Djur> djurlista){
        int kontroll = 1;
        if(!(djurlista.isEmpty())){
            kontroll = 2;
            taBortAllaDjur(djurlista);
        }
        if(kontroll == 1){
            System.out.print("\nInga djur finns registrerade!");
        }
    }
    private static void kollaDjuren4(ArrayList<Djur> djurlista){
        int kontroll = 1;
        if(!(djurlista.isEmpty())){
            kontroll = 2;
            jaga(djurlista);
        }
        if(kontroll == 1){
            System.out.print("\nInga djur finns registrerade!");
        }
    }
    private static void visaDjuren(ArrayList<Djur> djurlista){
        double attackStyrka = 0.0;
        double mest = 0.0;
        String namn = "";
        System.out.print("\nREGISTRERADE DJUR:\n");
        for(int x = 0;x<djurlista.size();x++){
            System.out.print(djurlista.get(x));
            attackStyrka = attackStyrka + djurlista.get(x).attackStyrka();
            if(djurlista.get(x).attackStyrka() > mest){
                mest = djurlista.get(x).attackStyrka();
                namn = djurlista.get(x).returneraNamn();
            }
        }
        System.out.print("\nDjurens sammanslagna attackstyrka blir " + attackStyrka + ".\n" + namn + " är det mäktigaste djuret, med sin attackstyrka som når " + mest + ".\n");
    }
    private static void taBortDjur(ArrayList<Djur> djurlista){
        int v = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nTA BORT DJUR\n\nNamn: ");
        String namn = sc.nextLine();
        for(int x = 0;x<djurlista.size();x++){
            if(djurlista.get(x).returneraNamn().equals(namn)){
                djurlista.remove(x);
                v = 2;
                System.out.print("\n" + namn + " togs bort ut registret!");
            }
        }
        if(v == 1){
            System.out.print("\nFel! Kunde inte hitta " + namn + " i registret.");
        }
    }
   private static void taBortAllaDjur(ArrayList<Djur> djurlista){
        int kollar = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nTÖM REGISTRET\n\nVarning! Detta tar bort samtliga djur ur registret!\nFör att fortsätta, skriv talet 'elva' med siffror: ");
        int nummer = returnInt();
        if(nummer == 11){
            djurlista.clear();
            kollar = 2;
            System.out.print("\nRegistret tömt.");
        }
        if(kollar == 1){
            System.out.print("\nFel!");
        }
    }
   private static void jaga(ArrayList<Djur> djurlista){
        int kollar = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nJAGA\n\nNamn: ");
        String namn = sc.nextLine();
        for(int x = 0;x<djurlista.size();x++){
            if(djurlista.get(x).returneraNamn().equals(namn)){
                kollar = 2;
                System.out.print("Antal offer: ");
                int offer = returnInt();
                djurlista.get(x).ändraAttribut(offer);
            }
        }
        if(kollar == 1){
            System.out.print("\nFel! Kunde inte hitta " + namn + " i registret!");
        }
    }
   private static int returnInt(){
       for(;;){
           Scanner sc = new Scanner(System.in);
           try{
               int x = sc.nextInt();
               return x;
           }
           catch(InputMismatchException e){
               System.out.print("\nFel inmatning! F�rs�k igen: ");
           }
       }
   }
   private static double returnDouble(){
       for(;;){
           Scanner sc = new Scanner(System.in);
           try{
               double x = sc.nextInt();
               return x;
           }
           catch(InputMismatchException e){
               System.out.print("\nFel inmatning! Försök igen: ");
           }
       }
   }
}