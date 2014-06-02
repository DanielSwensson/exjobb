/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vardesaksregister;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Krille
 */
public class Vardesaksregister {

    /**
     * @param args the command line arguments
     */
    private String sort;
    private String agare;
    private String sortSmycke;
    private String benamning;
    private String guld = "";
    private String namn;
    private boolean personHittades;
    private double index;
    private int antal;
    private int slitage;
    private int inkopspris;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Person> personLista = new ArrayList<>();
    private Object[] tempArray;
    private int stenar;

    public Vardesaksregister() {
        // exempelGubbar(); //Metod för test, skapar personer med ägodelar.
        while (true) {
            switch (meny()) {
                case 1:
                    skapaPerson();
                    break;
                case 2:
                    skapaPryl();
                    break;
                case 3:
                    visaAlla();
                    break;
                case 4:
                    visaRikaste();
                    break;
                case 5:
                    visaPerson();
                    break;
                case 6:
                    borskrasch();
                    break;
                case 7:
                    System.exit(0);

            }
        }
    }

    private int meny() {
        System.out.println("Meny");
        System.out.println("1. Skapa person");
        System.out.println("2. Skapa pryl");
        System.out.println("3. Visa alla");
        System.out.println("4. Visa rikaste");
        System.out.println("5. Visa viss person");
        System.out.println("6. Börskrasch");
        System.out.println("7. Avsluta");
        int tmp = 0;
        try {
            tmp = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Felaktig inmatning");
        }
        return tmp;
    }
    //Menyval:

    private void skapaPerson() {
        String namn = "";
        System.out.println("Skapa person: ");
        System.out.print("Namn: ");
        try {
            namn = sc.nextLine();
        } catch (Exception e) {
        }
        //Kontrollera om namnet redan finns
        for (Person p : personLista) {
            if (namn.equalsIgnoreCase(p.getNamn())) {
                System.out.println("Namnet finns redan regisrerat!");
                return;
            }
        }
        personLista.add(new Person(namn));
        System.out.println("Ny person inlagd i registret!");
    }

    private void skapaPryl() {

        personHittades = false;
        System.out.println("Skapa pryl");
        System.out.println("Namn på prylens ägare: ");
        agare = sc.nextLine();

        for (Person p : personLista) {
            if (p.getNamn().equalsIgnoreCase(agare)) {
                personHittades = true;
            }
        }
        if (!personHittades) {
            System.out.println("Anvigna ägaren till prylen hittades ej i registeret!");
        } else {
            System.out.println("Vilken sorts pryl? ");
            sort = sc.nextLine();

            if (sort.equalsIgnoreCase("smycke")) {
                skapaSmycke();
            } else if (sort.equalsIgnoreCase("apparat")) {
                skapaApparat();
            } else if (sort.equalsIgnoreCase("aktie")) {
                skapaAktie();
            } else {
                System.out.println("Felaktig inmatning");
                System.out.println("Var god börja om");
            }
        }


    }

    public void skapaSmycke() {
        System.out.println("Vilken benämning av smycket?");
        sortSmycke = sc.nextLine();

        do{
        System.out.println("Är smycket av guld? J/N ");
        guld = sc.nextLine();
        }while(!(guld.equalsIgnoreCase("J") || guld.equalsIgnoreCase("N")));
       
        
        System.out.println("Antal ädelstenar: ");
        boolean daligInmatning = true;
        while (daligInmatning) {
            try {
                daligInmatning = false;
                stenar = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Felaktig inmatning, försök igen \n");
                daligInmatning = true;
            }

        }
        for (Person p : personLista) {
            if (p.getNamn().equalsIgnoreCase(agare)) {
                p.addPryl(new Smycke(sort, sortSmycke, guld, stenar));
                personHittades = true;
                //System.out.println(p.toString());
                break;
            }
        }



    }

    public void skapaAktie() {

        System.out.println("Namn på aktie: ");
        benamning = sc.nextLine();
        while (true) {
            try {
                System.out.println("Antal?");
                antal = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Felaktig inmatning. Använd endast siffror");
            }
        }

        while (true) {
            try {
                System.out.println("Värde?");
                index = Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Felaktig inmatning. Använd endast siffror");
            }
            break;
        }
        for (Person p : personLista) {
            if (p.getNamn().equalsIgnoreCase(agare)) {
                p.addPryl(new Aktie(sort, benamning, antal, index));
                personHittades = true;
                //System.out.println(p.toString());
                break;
            }
        }



    }

    public void borskrasch() {

        for (Person p : personLista) {
            for (Pryl pr : p.getPrylar()) {
                if (pr instanceof Aktie) {
                    // System.out.println("boom");
                    pr.borskrasch();
                    //  System.out.println(pr.toString());
                }
            }
        }
        //  System.out.println(personLista.get(0).toString());
        System.out.println("Alla aktier blev värdelösa!!");
    }

    public void skapaApparat() {
        System.out.println("Benämning på apparat: ");
        benamning = sc.nextLine();
        while (true) {
            try {
                System.out.println("Inköpspris?");
                inkopspris = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Felatkig inmatning. Använd endast siffror.");
            }
        }

        while (true) {
            try {
                System.out.println("Slitage?");
                slitage = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Felaktig inmatning. Använd endast siffror.");
            }
        }
        for (Person p : personLista) {
            if (p.getNamn().equalsIgnoreCase(agare)) {
                p.addPryl(new Apparat(sort, benamning, inkopspris, slitage));
                personHittades = true;
                //System.out.println(p.toString());
                break;
            }
        }
    }

    public void visaAlla() {
        for (Person p : personLista) {
            System.out.println(p);
            System.out.println("");

        }

    }

    public void visaPerson() {
        System.out.println("Vem söker du?");
        namn = sc.nextLine();
        for (Person p : personLista) {
            if (p.getNamn().equalsIgnoreCase(namn)) {
                System.out.println(p.toStringPrylsamling());
                return;
            }
        }
        System.out.println("Personen hittates ej!");

    }

    public void visaRikaste() {
        tempArray = personLista.toArray();
        Arrays.sort(tempArray);
        /*   for(Object tmp: tempArray){
         System.out.println(tmp);
         }*/
        System.out.println(tempArray[tempArray.length - 1]);
        tempArray = null;
    }

    public void exempelGubbar() {
        personLista.add(new Person("Kalle"));
        personLista.get(0).addPryl(new Aktie("aktie", "Volvo AB", 120, 3.5));
        personLista.get(0).addPryl(new Apparat("apparat", "TV", 10000, 7));

        personLista.add(new Person("Olle"));
        personLista.get(1).addPryl(new Smycke("smycke", "halsband", "j", 3));

        personLista.add(new Person("Linnea"));
        personLista.get(2).addPryl(new Apparat("apparat", "armbandsur", 25000, 3));
        personLista.get(2).addPryl(new Smycke("smycke", "örgängen", "j", 11));
        personLista.add(new Person("Susanna"));
        personLista.get(3).addPryl(new Aktie("aktie", "HM", 11111, 4.65));
        personLista.add(new Person("Hannah"));
        personLista.get(4).addPryl(new Aktie("aktie", "Åhlens", 25000, 12.2));
        personLista.get(4).addPryl(new Apparat("apparat", "Privatjet", 2200000, 8));
        personLista.add(new Person("Evelina"));
        personLista.get(5).addPryl(new Smycke("smycke", "MEGABLING", "n", 4000));

    }
}
