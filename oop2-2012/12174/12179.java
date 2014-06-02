import java.util.Scanner;

public class Dialogue
{   
    private Register register;
    private Scanner scan;
    private int switchSelection;

    public Dialogue() {
        register = new Register();
        scan = new Scanner(System.in);
        start();
    }

    private void start() {
        boolean running = true;
        while(running) {
            System.out.println("----------Välkommen till prylregistret----------");
            System.out.println();
            System.out.println("1. Registrera person");
            System.out.println("2. Skapa pryl");
            System.out.println("3. Visa alla");
            System.out.println("4. Visa rikaste");
            System.out.println("5. Visa viss person");
            System.out.println("6. Börskrasch");
            System.out.println("7. Avsluta");
            switchSelection = readInt("");

            switch(switchSelection) {
                case 1: createPerson();
                break;
                case 2: checkAvailability();
                break;
                case 3: showAll();
                break;
                case 4: showRichest();
                break;
                case 5: showPerson();
                break;
                case 6: marketCrasch();
                break;
                case 7:  System.out.println("Hej då!");
                running = false;
                break;
                default:
                break;
            }
        }
    }

    private void createPerson() {
        System.out.println("----------Lägga till ny person----------");
        System.out.println();

        String name = readString("Vad heter personen? ");

        boolean success = register.addPerson(name);

        if(success) {
            System.out.println(name + " är nu registrerad.");
        } else {
            System.out.println("Någonting gick snett. Se till att personen inte redan finns.");
        }
        System.out.println();
    }

    private void checkAvailability() {
        String owner = readString("Vem äger prylen? ");
        boolean personFound = register.findPerson(owner);
        if(personFound) {
            itemSelection(register.getPerson(owner));
        } else {
            System.out.println("Personen finns inte.");
        }
    }

    private void itemSelection(Person owner) {
        System.out.println("----------Vilken sorts pryl?----------");
        System.out.println();
        System.out.println("1. Smycke");
        System.out.println("2. Aktie");
        System.out.println("3. Apparat");

        switchSelection = readInt("");
        switch (switchSelection) {
            case 1: readJewelry(owner);
            break;
            case 2: readShareholding(owner);
            break;
            case 3: readDevice(owner);
            break;
            default: System.out.println("Ogiltligt kommando");
            break;   
        }
    }

    public void readJewelry(Person p) {
        System.out.println("----------Lägga till smycke----------");
        System.out.println();
        boolean material;

        String name = readString("Vad är det för typ av smycke? ");
        System.out.println();

        System.out.println("1. Guld");
        System.out.println("eller");
        System.out.println("2. Silver");
        System.out.println("(Standard är guld)");

        switchSelection = readInt("");
        switch(switchSelection) {
            case 1: material = true;
            break;
            case 2: material = false;
            break;
            default: material = true;
            break;
        }

        System.out.println();
        int numberOfGems = readInt("Hur många ädelstenar har smycket? ");

        p.addJewelry(name, material, numberOfGems);
    }

    public void readShareholding(Person p) {
        System.out.println("----------Lägga till aktie----------");
        System.out.println();

        String name = readString("Vad är namnet på aktieposten? ");
        System.out.println();
        int purchasePrice = readInt("Vad är inköpspriset? ");
        System.out.println();
        int amount = readInt("Hur många aktier? ");

        p.addShareholding(name, purchasePrice, amount);
    }

    public void readDevice(Person p) {
        System.out.println("----------Lägga till apparat---------");
        System.out.println();

        String name = readString("Vad heter apparaten? ");
        System.out.println();
        int purchasePrice = readInt("Vad är inköpspriset? ");
        System.out.println();
        
        int quality;
        for(;;) {
            quality = readInt("I vilket skick är apparaten? (på en skala på 10) ");
            if(quality > 1 || quality < 10) {
                break;    
            } else {
                System.out.println("Kvaliten kan inte vara mindre än 1 eller större en 10.");
            }
        }
        
        p.addDevice(name, purchasePrice, quality);
    }

    private void showAll() {
        register.list();
        System.out.println();
    }

    private void showPerson() {
        String name = readString("Vem letar du efter? ");
        boolean success = register.printPerson(name);

        if (!success) {
            System.out.println("Personen kunde inte hittas.");
        }
    }

    private void showRichest() {
        boolean success = register.printRichest();

        if(!success) {
            System.out.println("Din lista är tom.");
        }
    }

    private void marketCrasch() {
        register.crashMarket(0);
        System.out.println("Wall Street brinner, alla aktier har tappat sitt värde.");
        System.out.println();
    }

    private String readString(String prompt) {
        String input = null;
        while (input == null) {
            System.out.print(prompt);
            input=scan.nextLine();
        }
        return input;
    }

    private int readInt(String prompt) {
        String input = readString(prompt);
        int parsedNumber;
        try {
            parsedNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            parsedNumber = readInt(prompt);
        }
        return parsedNumber;
    }

    public static void main(String[] args) {
        new Dialogue();
    }
}
