import java.io.Serializable;
import java.util.Arrays;


public abstract class Item implements Serializable {
	private int idNr;
	private String name;
	private Person owner;
	abstract double getValue();
	
	Item (Object owner, String name) {
		this.idNr = nextAvailableId();
		this.owner = (Person) owner;
		this.name = name;
	}

	public int getIdNr() {
		return this.idNr;
	}
	
	public String getName() {
		return this.name;
	}
	public Object getOwner() {
		return owner; 
	}
	
	
	private int nextAvailableId() {
		int returnId = 1;
		boolean foundId;
		int[] idNumbers = new int[Inlupp2.itemList.size()]; 	
		for(int x=0; x < Inlupp2.itemList.size(); x++) {
			idNumbers[x] = Inlupp2.itemList.get(x).getIdNr();
		}		
		for(int idStart=1; idStart < 999999; idStart++) {
			foundId = false;
			for(int y=0; y < idNumbers.length; y++) {
				if (idNumbers[y] == idStart) {
					foundId = true;
					break;
				}
			}
			if (!foundId) {
				returnId = idStart;
				break;
			}
		}
		return returnId;
	}
}
