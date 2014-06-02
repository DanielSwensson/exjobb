public abstract class Thing {
    
    private String name;

    Thing(String name) {
	this.name = name;
    }
    
    public String toString() {
	return name + " " + getValue();
    }
    
    public abstract double getValue();

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}
