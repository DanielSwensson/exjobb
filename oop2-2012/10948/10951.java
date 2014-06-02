/*Author: Fredrik Birath Hasselgren
 * 
 *Den här klassen representerar ett smycke som en person kan äga. Klassen är en subklass till Thing
 *Varje smycke har ett antal ädelstenar och kan vara av guld eller silver
 *Förutom en konstruktor har klassen metoder för att returnera värde (olika om av guld eller silver) samt en överskuggad toString-metod
 */
package valuegister;

public class Jewelry extends Thing {

    private int numberOfDiamonds;//antal ädelstenar ett smycke har
    private boolean isGold;//är smycket av guld? Om false så är det av silver

    public Jewelry(String name, boolean isGold, int numberOfDiamonds) {
        super(name);
        this.isGold = isGold;
        this.numberOfDiamonds = numberOfDiamonds;
    }

    @Override
    public double getValue() {
        if (isGold) {//Om smycket är av guld
            return 2000 + numberOfDiamonds * 500;
        } else {//smycket är av silver
            return 700 + numberOfDiamonds * 500;
        }

    }

    @Override
    public String toString() {
        return getName() + " med " + numberOfDiamonds + " ädelstenar värd " + getValue();
    }
}
