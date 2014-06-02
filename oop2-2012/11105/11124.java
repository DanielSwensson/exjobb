
public class Room {

	private String description;
	private Item loot;
	private Event roomEvent;
	
	public Room(String description, Item item, Event evnt){
		roomEvent = evnt;
		this.description = description;	
		loot = item;	
		}
	
	public Room(String description, Item item){
		
		this.description = description;	
		loot = item;
		}
	
public Room(String description, Event event){
		this.roomEvent = event;
		this.description = description;	
		}	
	
	public Room(String description){
		
		this.description = description;	
		}
	
	public String getDescription(){
		return description;
	}
	
	public void setRoomEvent(Event roomEvent){
		
		this.roomEvent=roomEvent;
	
	}
	
	public Event getRoomEvent(){
		
		return roomEvent;
	}
	
	public String toString(){	
		if(getItem() != null)
		return description + "\nYou see a "+ getItem().getName() + "!";
		else 
			return description;
	}
	
	public Item getItem(){
		
		return loot;
	}
	

	public void removeItem(){
		
		loot=null;
	}
	
	
}
