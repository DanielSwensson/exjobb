
public class Distance extends Exercise{
	
private int length;

public Distance(String name, String equipment, int length, int amount) {
	super(name, equipment, amount);
	this.length = length;
}
public Distance(String name, int length, int amount) {
	super(name, amount);
	this.length = length;
}
public Distance(String name, String equipment, int length) {
	super(name, equipment);
	this.length = length;
}

public Distance(String name, int length) {
	super(name);
	this.length = length;
}

public int getLength() {
	return length;
}

public void setLength(int length) {
	this.length = length;
}

public String toString(){
	return getName() + " " + length + "m";
}

}
