//import java.util.ArrayList;

abstract public class Valuable {
	protected String name;
	final protected String listFormat ="%1$10s %2$-10s value:%3$s";
	Valuable() {
	}
	
	abstract public int getValue();

	abstract public String toString();
	
	abstract public void crash();
}
