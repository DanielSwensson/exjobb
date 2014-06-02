import java.io.*;

public class Item implements Serializable {
	
	private String name;
	private static int antal = 0;
	private int idnr = ++antal;
	protected int equipmentSlot;
	protected String type = "item";
	
	Item (String name){
		this.name = name;
		antal = antal++;
	}
	
	public String getName(){
		return name;
	}
	
	public int getIdnr(){
		return idnr;
	}
	
	public int getValue(){
		return 0;
	}
	
	public String getType(){
		return type;
	}
	
	public int getEquipmentSlot(){
		return equipmentSlot;
	}
	
	public String toString(){
		return name;
	}
}
