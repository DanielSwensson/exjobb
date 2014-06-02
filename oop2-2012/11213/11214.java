public class Belongings {
	
	private String name;
	private int value;

	Belongings(String name, int value) {
		this.name=name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}	
}