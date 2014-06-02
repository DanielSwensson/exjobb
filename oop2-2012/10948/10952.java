/*Author: Fredrik Birath Hasselgren
 * 
 *Den är klassen representerar en person.
 *Varje person har ett namn samt en lista med de prylar personen äger
 *getName() returnerar personens namn
 *addThing() lägger till en pryl i personens lista över prylar
 *crashStocks() går igenom alla prylar som personen äger och kallar på metoden crash() för eventuella aktier
 *showThings() skriver ut de prylar personen äger
 *sumThings() summerar värdet för alla prylar och returnerar summan av dem
 */
package valuegister;

import java.util.ArrayList;

public class Person {

    private ArrayList<Thing> things = new ArrayList<>();//personens saker
    private String name;

    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void addThing(Thing t) {
        things.add(t);
    }
    
    public void crashStocks(){
        for (Thing t: things){
            if (t instanceof Stock){
                ((Stock)t).crash();
            }
        }
    }

    public void showThings() {
        for (Thing t : things) {
            System.out.println(t);
        }
        System.out.println("---------------");
    }

    public double sumThings() {
        double sum = 0;
        for (Thing t : things) {
            sum += t.getValue();
        }
        return sum;
    }

    @Override
    public String toString() {
        return name;
    }
}
