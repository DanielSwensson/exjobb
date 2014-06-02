
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class for persons
 */
public class Person implements Serializable {

    private String name;
    public ArrayList<Valuable> valuables = new ArrayList<Valuable>();

    /*
     * A person is constructed with a name
     */
    public Person(String name) {
        this.name = name;
    }

    /*
     * Returns the name of the person
     */
    public String getName() {
        return this.name;
    }

    /*
     * Compiles the collected values of the persons valuables
     */
    public double getValue() {
        double value = 0;
        for (Valuable valuable : valuables) {
            value += valuable.getValue();
        }
        return value;
    }

    /*
     * Returns the person and the value of its valuables as a string
     */
    @Override
    public String toString() {
        return "Namn: " + this.name + " Tillgångar: " + this.getValue();
    }
}
