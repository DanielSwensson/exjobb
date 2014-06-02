/*Author: Fredrik Birath Hasselgren 
 * 
 *Det här är programmets huvudklass som sköter de kommandon som använderna vill utföra.
 *Den samverkar främst med instanser av klassen person.
 *För information om enskilda metoder har varje metod kommentarer som förklarar vad den gör
 */
package valuegister;

import java.util.ArrayList;
import java.util.Scanner;

public class Handler {

    private ArrayList<Person> persons = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void printMeny() {//Skriver ut de olika alternativ användaren har att välja på
        System.out.println("1. Lägg till person");
        System.out.println("2. Lägg till pryl");
        System.out.println("3. Visa alla personer");
        System.out.println("4. Visa rikaste person");
        System.out.println("5. Visa person");
        System.out.println("6. Börskrasch");
        System.out.println("7. Avsluta");
    }

    public void choice() {//Anropar metoder beroende på vad använder vill göra
        printMeny();//Skriv ut meny
        int s = readInt("Välj ett alternativ genom att skriva in en siffra och tryck sedan på enter");//Ta bara emot en int som svar
        switch (s) {//Switcha på svaret
            case 1:
                addPerson();//Lägg till person
                break;
            case 2:
                addThing();//Lägg till ny pryl hos befintlig person
                break;
            case 3:
                showAll();//Visa alla personer
                break;
            case 4:
                showRichest();//Visa den rikaste personen
                break;
            case 5:
                showPerson();//Visa enskild persons alla prylar
                break;
            case 6:
                stockCrash();//Börskrasch, aktier värda 0
                break;
            case 7:
                System.out.println("Tack och välkommen åter!");
                System.exit(0);//Avsluta program
            default:
                System.out.println("Vänligen välj ett giltigt alternativ");
        }
    }

    public void addPerson() {//Lägger till en ny person i listan över personer
        String name = readString("Vad heter personen?");
        Person p = new Person(name);//skapa ny person
        if (!findPerson(name)) {//personens namn finns inte sparat sen tidigare
            System.out.println(name + " är sparad!");
            persons.add(p);//lägg till i arraylist över personer
        } else {
            System.out.println("Personen fanns redan sparad");
        }
    }

    public void addThing() {//Lägger till en ny pryl hos en tidigare sparad person
        String person;//Vem ska få den nya prylen?
        String answer;//vilken typ av pryl vill användaren lägga till?
        String name;//namn på smycke, aktie eller apparat
        if (hasPersons()) {//Om det finns personer sparade
            printPersons();//visa personer
            person = readString("Vilken person äger prylen?");
            if (findPerson(person)) {//om befintlig person vald
                answer = readString("Vilken sorts pryl? (smycke, aktie eller apparat)");
                if (answer.equalsIgnoreCase("smycke")) {//Smycke
                    name = readString("Vad för typ av smycke?");//smyckets typ
                    boolean isGold = readBool("Är smycket av guld?");//Är det av guld eller silver?
                    int numberOfDiamonds = readInt("Hur många ädelstenar?");//Antal ädelstenar
                    Jewelry j = new Jewelry(name, isGold, numberOfDiamonds);//skapa ett nytt smycke
                    persons.get(findPersonIndex(person)).addThing(j);//lägg till i personens lista av saker
                    if (isGold) {//Skriv ut bekräftelse på smycket av guld
                        System.out.println(persons.get(findPersonIndex(person)).getName() + " äger nu " + name + " av guld med " + numberOfDiamonds + " ädelstenar");
                    } else {//Skriv ut bekräftelse på smycket av silver
                        System.out.println(persons.get(findPersonIndex(person)).getName() + " äger nu " + name + " av silver med " + numberOfDiamonds + " ädelstenar");
                    }//metod avslutad
                } else if (answer.equalsIgnoreCase("aktie")) {//Aktie
                    name = readString("Vilken aktie?");//aktiens namn
                    int numberOfPosts = readInt("Hur många aktieposter?");//antal
                    double price = readDouble("Vad var aktiens pris?");//priset
                    Stock s = new Stock(name, numberOfPosts, price);//skapa ny aktie
                    persons.get(findPersonIndex(person)).addThing(s);//lägg till i persoenns lista av saker
                    System.out.println(persons.get(findPersonIndex(person)).getName() + " äger nu " + numberOfPosts + " " + name + "aktier med styckpris på " + price);
                } else if (answer.equalsIgnoreCase("apparat")) {//Apparat
                    name = readString("Vad för apparat?");//vilken apparat?
                    int purchasePrice = readInt("Vad kostade apparaten?");//inköpspris
                    int wear;//slitage
                    do {//loopa tills wear har ett värde mellan 10 och 1
                        wear = readInt("Gradera slitaget på apparaten, 10 betyder helt ny och 1 är mycket sliten");
                    } while (!isInRange(wear, 10, 1));
                    Device d = new Device(name, purchasePrice, wear);//skapa apparaten
                    persons.get(findPersonIndex(person)).addThing(d);//lägg till i listan av saker
                    System.out.println(persons.get(findPersonIndex(person)).getName() + " äger nu " + name + " till inköpspriset " + purchasePrice);

                } else {//användaren matade en ogiltig pryl
                    System.out.println("Det är tyvärr inte möjligt att lägga till " + answer);
                }
            } else {//den person användaren matade in finns inte
                System.out.println("Personen finns inte");
            }
        }
    }

    public void showAll() {//skriver ut alla personer samt deras samlande tillgångar
        if (hasPersons()) {//om personer finns sparade
            System.out.println("Dessa personer finns sparade: ");
            for (Person p : persons) {//loopa igenom listan över personer
                System.out.println(p.getName() + "       " + p.sumThings());//skriv ut persons namn samt samlade tillgångar
            }
        }
    }

    public void showRichest() {//Ta reda på vem av personerna som har störst tillgångar och skriv ut dess namn och tillgångar
        int richest = 0;//rikaste personen
        if (hasPersons()) {//om det finns personer sparade
            for (int i = 0, j = 1; i < persons.size(); i++, j++) {//gå igenom alla personer
                if (persons.get(i).sumThings() > persons.get(richest).sumThings()) {//Om person i har större tillgångar än nuvarande rikaste
                    richest = i;//uppdatera index för den rikaste
                }
            }//skriv ut den rikaste
            System.out.println("Den rikaste är " + persons.get(richest).getName() + " med tillgångar till ett värde av " + persons.get(richest).sumThings());
            persons.get(richest).showThings();
        }
    }

    public void showPerson() {//skriv ut enskild person och dess tillgångar
        String person;//personen vi vill välja
        printPersons();//skriv ut alla sparade personer
        person = readString("Välj en person");
        if (findPerson(person)) {//Om personen finns
            persons.get(findPersonIndex(person)).showThings();//skriv ut personen prylar
        } else {//personen fanns ej
            System.out.println(person + " fanns ej sparad.");
        }
    }

    public void stockCrash() {//En börskrasch äger rum, alla aktier blir värda 0
        if (hasPersons()) {//om det finns sparade person
            for (int i = 0; i < persons.size(); i++) {//loopa personer
                persons.get(i).crashStocks();//krascha personens eventuella aktier
            }
            System.out.println("Börsen kraschade! Alla aktier är nu värda 0");
        }
    }

    //HJÄLPMETODER NEDAN
    private boolean hasPersons() {//returner true om personlistan ej är tom
        if (!persons.isEmpty()) {//det finns personer sparade
            return true;
        }
        System.out.println("Det finns inga personer");//listan var tom
        return false;
    }

    private void printPersons() {//skriver ut alla sparade personers namn
        for (int i = 0; i < persons.size(); i++) {//gå igenom personlistan
            System.out.println(persons.get(i).getName());//skriv ut personens namn
        }
    }

    private boolean findPerson(String name) {//returnerar true om en person med ett visst namn finns sparad
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getName().equalsIgnoreCase(name)) {//om argumentet är lika med en persons namn
                return true;
            }
        }
        return false;//argumentet var inte lika med en sparad persons namn
    }

    private int findPersonIndex(String name) {//Hitta en sparad persons index i listan 
        int index = 0;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getName().equalsIgnoreCase(name)) {//om argument stämmer med sparad persons namn
                index = i;//personens index i arraylisten
            }
        }
        return index;//returnera personens index
    }

    private int readInt(String question) {//Grundad på metod av Stefan Möller. Möjliggör säker inmatning av heltal
        for (;;) {//loopa tills funktion returnerar något
            try {
                System.out.println(question);//skriv ut argumentsträngen
                int number = Integer.parseInt(input.nextLine());//tilldela number ett heltal
                return number;//returnera talet
            } catch (NumberFormatException e) {//inmatningen var ej ett heltal
                System.out.println("Vänligen skriv ett tal");
            }
        }
    }

    private double readDouble(String question) {//Grundad på metod av Stefan Möller. Möjliggör säker inmatning av flyttal
        for (;;) {//loopa tills funktion returnerar något
            try {
                System.out.println(question);//skriv ut argumentsträngen
                double number = Double.parseDouble(input.nextLine());//tilldela number ett flyttal
                return number;//returnera talet
            } catch (NumberFormatException e) {//inmatningen var ej flyttal
                System.out.println("Vänligen skriv ett tal");
            }
        }
    }

    private String readString(String question) {//Grundad på metod av Stefan Möller. tilldelar en sträng användarens inmatning
        String str;//strängen som ska tilldels användarens inmatning
        System.out.println(question);//Skriv ut argumentsträng
        do {//loopa tills vi har en sträng som innehåller något eller bara består av ett mellanslag
            str = input.nextLine();
        } while ("".equals(str) || " ".equals(str));//tillåt inga mellanslag eller tomma strängar
        return str;//returnera giltig sträng
    }

    private boolean readBool(String question) {//tilldelar en boolean true eller false
        String answer;//användares svar
        boolean giltigt = false;//är användarens inmatning ett giltigt svar?
        System.out.println(question + ". Ja eller Nej?");//skriv argumentsträng samt alternativ
        do {//loopa tills giltigt == true
            answer = input.nextLine();
            if (answer.equalsIgnoreCase("Ja") || answer.equalsIgnoreCase("Nej")) {//Om användarens svar är Ja elle Nej
                giltigt = true;//giltigt val
            } else {//ogiltigt val
                System.out.println("Vänligen svara Ja eller Nej.");
            }
        } while (!giltigt);
        if (answer.equalsIgnoreCase("Ja")) {//Om användarens svar var ja
            return true;//returnera sant
        } else {//användarens svar var nej
            return false;//returnera falskt
        }

    }

    private boolean isInRange(int number, int max, int min) {//tar ett heltal samt ett max och minvärde och returner true om talet är inom max eller min
        if (number <= max && number >= min) {//argumenttalet är mindre eller lika med max OCH större eller lika med min
            return true;
        }
        System.out.println("Skriv in ett tal mellan " + min + " och " + max);//talet var inte inom max eller min
        return false;
    }
}
