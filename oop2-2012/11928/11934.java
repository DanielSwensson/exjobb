import java.util.ArrayList;


public class Menu {
	protected final String MENU_QUESTION = "What do you want to do";
	protected ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	private String menuDescription;
	
	public Menu(String menuDescription){
		this.menuDescription = menuDescription;
		
	}
	
	public void addMenuItem(MenuItem menuItem){
		menuItems.add(menuItem);
	}
	public char getMenuChoice(){
		char userMenuChoice;
		boolean validInput = false;
		do{
			 userMenuChoice = Io.getChar(MENU_QUESTION);
			validInput = verifyMenuChoice(userMenuChoice);
			if (validInput == false){
				System.out.println("That is not a valid menu option");
			}
		}while ( validInput == false);
	
		return userMenuChoice;
	}
	public String getMenuDescription() {
		return menuDescription;
	}
	
	public int getNumberOfMenuItems(){
		return this.menuItems.size();
	}

	public void printMenu(){
		Io.printHeader(this.getMenuDescription(),0);
		for (MenuItem x : menuItems){
			System.out.println("("+ x.getShortcut() + ")  " + x.getMenuDescription());
		}
	}
	public void printFullMenu(){
		for (MenuItem x : menuItems){
			System.out.println("Description\t" + x.getMenuDescription());
			System.out.println("Shortcut\t" + x.getShortcut());

		}
	}
	public boolean verifyMenuChoice(char userChoice){
		/*This takes the users input and discards everything except for the first letter
		It then loopes through the menuitems of the menu and compares the remaining character 
		to the possible shortcuts of the menu. It  returns true if the user has entered the 
		correct shortcut key.
		 */
		boolean correctMenuChoice = false;
		for (MenuItem a : menuItems){
			if (userChoice == a.getShortcut()){
				correctMenuChoice = true;
			}
		}	
		return correctMenuChoice;
	}
}
