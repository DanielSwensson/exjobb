import java.util.ArrayList;

public abstract class Class_Stuff {

	private String nameOfItem;
	private int valueOfItem;
	private int ownerId;	
	
	private static ArrayList<Class_Stuff> listAllStuff = new ArrayList<Class_Stuff>();
	
	public Class_Stuff(String name, int value, int ownerId) {
		this.nameOfItem = name;
		this.valueOfItem = value;
		this.ownerId = ownerId;		
	}
	
	public static void addStuff(Class_Stuff c) {
		
		listAllStuff.add(c);
	}
	
	public static ArrayList<Class_Stuff> getStuff() {
		return listAllStuff;
	}		
	
	public String getName() {		
		return this.nameOfItem;
	}
	
	public void setValue(int valueOfItem) {		
		this.valueOfItem = valueOfItem;
	}
	
	public int getValue() {		
		return this.valueOfItem;
	}
		
	public int getOwnerId() {		
		return this.ownerId;
	}
		
}
