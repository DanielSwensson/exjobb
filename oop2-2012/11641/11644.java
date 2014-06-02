import java.util.ArrayList;
import java.util.Scanner;


public class MainLoop {
    ArrayList<Person> personer = new ArrayList<Person>();
    Scanner keyboard = new Scanner(System.in);

    int readInt(String fråga)
    {
        for(;;)
        {
            try
            {
                System.out.print(fråga);
                int x=Integer.parseInt(keyboard.nextLine());
                return x;
            }
            catch (NumberFormatException e)
            {
            System.out.println("Fel - skall vara numeriskt värde");
            }
        }
    }

    String readString(String fråga)
    {
        System.out.print(fråga);
        String str=keyboard.nextLine();
        return str;
    }

    Person getPerson(String namn)
    {
        for (Person p : personer)
            if (p.getNamn().equalsIgnoreCase(namn))
                return p;
        return null;
    }

    void nyPerson()
    {
        String namn = readString("Nya personens namn: ");
        Person p = getPerson(namn);
        if (p!=null)
            System.out.println("Den personen finns redan!");
        else
        {
            Person ny = new Person(namn);
            personer.add(ny);
        }
    }

    void nyPryl()
    {
        String namn = readString("Till vilken person? ");
        String pryl = readString("Vilken slags pryl? ");

        if ("Smycke".equalsIgnoreCase(pryl))
        {
            String typ = readString("Vilken sorts smycke? ");
            String material = readString("Är smycket av guld? ");
            int ädelstenar = readInt("Antal ädelstenar: ");

            Smycke nytt = new Smycke(typ, ädelstenar, material);
            Person p = getPerson(namn);
            
            p.addPryl(nytt);
        }

        if ("Aktie".equalsIgnoreCase(pryl))
        {
            String typ = readString("Vad heter aktien? ");
            int antal = readInt("Antal aktier: ");
            double pris = readInt("Vad är aktiernas pris? ");

            Aktie nytt = new Aktie(typ, antal, pris);

            Person p = getPerson(namn);
            p.addPryl(nytt);
        }

        if ("Apparat".equalsIgnoreCase(pryl))
        {
            String typ = readString("Vilken sorts apparat? ");
            int pris = readInt("Apparatens inköpspris? ");
            int slitage = readInt("Apparatens slitage? ");
            while (slitage > 10 || slitage <= 0)
            {
                System.out.println("Slitaget ska vara från 1-10, skriv rätt!");
                slitage = readInt("Apparatens slitage? ");
            }


            Apparat nytt = new Apparat(typ, pris, slitage);

            Person p = getPerson(namn);
            p.addPryl(nytt);
        }
    }

    void visaAlla()
    {
        System.out.println("I registret finns:");

        for (Person p : personer)
        {
            System.out.println(p);
        }
    }

    void visaRikaste()
    {
        int rikast = 0;
        String rikastPerson = null;

        for (Person p : personer)
        {
            if (p.getSammanlagtVärde() > rikast)
            {
                rikastPerson = p.getNamn();
                rikast = p.getSammanlagtVärde();
            }
        }

        System.out.println("Rikast är " + rikastPerson + " som sammanlagt äger " + rikast);

        for (Person p : personer)
        {
            if (rikastPerson.equalsIgnoreCase(p.getNamn()))
            {
                for (Pryl x : p.samling)
                {
                    System.out.println(x);
                }
            }
        }

    }

    void visaVissPerson()
    {
        String namn = readString("Vem ska visas? ");

        Person p = getPerson(namn);
        System.out.println(namn + " har sammanlagt " + p.getSammanlagtVärde());
        for (Pryl x : p.samling)
            {
                System.out.println(x);
            }
    }

    void börskrasch()
    {
        for (Person p : personer)
        {
            p.börsKrasch();
        }
    }

    public static void main(String[] args)
    {
        MainLoop hp = new MainLoop();
        for(;;)
        {
            int val=hp.readInt("Ange kommando 1-7: ");
            switch (val)
            {
                case 1: hp.nyPerson(); break;
                case 2: hp.nyPryl(); break;
                case 3: hp.visaAlla(); break;
                case 4: hp.visaRikaste(); break;
                case 5: hp.visaVissPerson(); break;
                case 6: hp.börskrasch(); break;
                case 7: System.out.println("Tack och hej då!");
                System.exit(0);
                default: System.out.println("Fel kommando");
            }

        }
    }
}
