
public class MenuItem {
	private String menuID;
	private String description;
	private char shortcut;
	
	public MenuItem(String newDescription, char newShortcut){
		this.description = newDescription;
		this.shortcut = newShortcut;
	}
	public String getMenuDescription(){
		return this.description;
	}
	public char getShortcut(){
		return this.shortcut;
	}
	public String toString(){
		return "menuID:\t\t" + menuID + "\nDescription:\t" + description + "\nShortcut:\t" + shortcut	;
	}
}
