// 
// ConsoleIO.java
//
// Innehåller metoder för att underlätta läsning och skrivning 
// från console-fönstret
//

package myassets.helper;

import java.util.ArrayList;
import java.util.Scanner;
import myassets.domainobjects.assets.AbstractAsset;
import myassets.domainobjects.person.Person;

public class ConsoleIO {

    private Scanner scanner = new Scanner(System.in);

    public ConsoleIO() {
    }
    // Hjälpmetoder

    public String readString(String prompt) {
        print(prompt);
        String input = scanner.nextLine();
        return input;
    }

    public String readString() {
        String input = scanner.nextLine();
        return input;
    }

    public double readDouble(String prompt) {
        while (true) {
            try {
                print(prompt);
                double input = Double.parseDouble(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                println("Fel - skall vara ett flyttal (double).");
            }
        }
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                print(prompt);
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                println("Fel - skall vara ett heltal (int).");
            }
        }
    }

    public int readInt() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                println("Fel - skall vara ett heltal (int).");
            }
        }
    }

    public void print(String str) {
        System.out.print(str);
    }

    public void println(String str) {
        System.out.println(str);
    }

    public void println(AbstractAsset asset) {
        System.out.println(asset);
    }
    
    public void println(ArrayList<AbstractAsset> a) {
        System.out.println(a);
    }

    public void print(Person p) {
        System.out.println(p);
    }
}
