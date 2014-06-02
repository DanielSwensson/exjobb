import java.util.ArrayList;

public class UserManager {
	private static User activeUser;
	private ArrayList<User> users = new ArrayList<User>();
	private Menu menu;
	
	public UserManager(){
		this.menu = new Menu("User menu");
		menu.addMenuItem(new MenuItem("Add user", 'a'));
		menu.addMenuItem(new MenuItem("Add measurements to user", 'm'));
		menu.addMenuItem(new MenuItem("Change active user", 'c'));

		menu.addMenuItem(new MenuItem("List users", 'l'));
		menu.addMenuItem(new MenuItem("Delete a user", 'd'));
		menu.addMenuItem(new MenuItem("Use system as guest", 'g'));
		menu.addMenuItem(new MenuItem("Go to parent menu", 'p'));
	}

	public void addGuestUser(){
		User guest = new User("Guest",33);
		
		double height = 1.70;
		guest.setHeight(new Height(height));
		double weight = 75;
		guest.setWeight(new Weight(weight));
		guest.setEnabled();
		guest.calculateStrideLength();
		setActiveUser(guest);
		users.add(guest);
	}
	
	public void addABunchOfDummyUsers(){
		User dummy1 = new User("Karl-Bertil",14);
		dummy1.setHeight(new Height(1.70));
		dummy1.setWeight(new Weight(74));
		dummy1.setEnabled();
		dummy1.calculateStrideLength();
		users.add(dummy1);
		
		User dummy2 = new User("Hans",81);
		dummy2.setHeight(new Height(1.70));
		dummy2.setWeight(new Weight(74));
		dummy2.setEnabled();
		dummy2.calculateStrideLength();
		users.add(dummy2);
	}

	private void userAdd(){
		boolean isUniqueUser = false;
		String nameOfUser ="";
		
		
		//This loop makes sure that the user can't be entered unless the name is unique
		do{
			nameOfUser = Io.getString("Name of user");
			
			if (userFindByName(nameOfUser) == -1 ){
				isUniqueUser = true;
			}
			else{
				System.out.println("That name already exists");
			}
		}while(isUniqueUser == false);	
		
		
		users.add(new User(nameOfUser));
		System.out.println("<<user \"" + nameOfUser+ "\" added>>");
	
	}

	private void userDelete(String userToDelete){
		int indexPos = userFindByName(userToDelete);
		if (indexPos > -1){
			users.remove(indexPos);
			System.out.println("<<user \""+ userToDelete +"\" deleted>>");
	
		}
		else{
			System.err.println(indexPos);
			System.out.println("The specified user was not found");
		}
	}

	private int userFindByName(String name){
		int indexFound = -1;
	
		for (int x = 0 ; x < users.size(); x++){
			if ((users.get(x).getName()).equalsIgnoreCase(name)){
				indexFound = x;
			}
		}
		return indexFound;
	}

	private void userMarkAsActive(){
		int indexPos = userFindByName(Io.getString("which user"));
		if (indexPos > -1){
			setActiveUser(users.get(indexPos));
		}
		else{
			System.out.println("The specified user was not found");
		}
	}

	public User getActiveUser(){
		return activeUser;
		
	}

	private void listAllUsers(){
		if (users.size() >= 1) {
			Io.printHeader("Userlist", 5);

			for (User u : users){
				System.out.print(u);
			}
			if (activeUser != null){
				System.out.println("\n\nThe current user is " + activeUser.getName());
			}else {
				System.out.println("\n\nThere is no active user");
 
			}
		}
		else {
			System.out.println("no registered users");
		}
	}

	@SuppressWarnings("static-access")
	private void setActiveUser(User u){
		this.activeUser = u;
		if (u.isEnabled() == true){
			activeUser = u;
			System.out.println("User " + u.getName() + " is now the active user");

		}
		else if (u.isEnabled() == false){
			System.out.println("The user needs to be completed before it can be set as the active user");
		}
	}

	private void addMeasurements(){
		
		int indexPos = userFindByName(Io.getString("to which user"));
		if (indexPos > -1){
			double height = Io.getDecimalNumber("Please enter your height (in meters i.e 1,70)");
			users.get(indexPos).setHeight(new Height(height));
			double weight = Io.getNumber("Please enter your weight");
			users.get(indexPos).setWeight(new Weight(weight));
			users.get(indexPos).setEnabled();
			users.get(indexPos).calculateStrideLength();

		}
		else{
			System.err.println(indexPos);
			System.out.println("The specified user was not found");
		}
		

	}
	
	public void runMenu() {
		boolean menuBreak = false;
		do {
			menu.printMenu();
			Character userMenuChoice = menu.getMenuChoice();
	
			switch (userMenuChoice.toString()){
				case "l" : //list all users 
					listAllUsers();
					break;
				case "d" : //delete user
					userDelete(Io.getString("User to delete"));
					break;
				case "a" : //add user
					userAdd();
					break;
				case "m" : //add measurements to user
					addMeasurements();
					break;
				case "c" : //mark the user as active
					userMarkAsActive();
					
					
					break;
				case "g" : //creates a guest user and sets it is the active user
					addGuestUser();
					break;				
				case "p" : //exits the loop and returns to the previous menu
					menuBreak = true;
					break;
				}
		}while(menuBreak == false);
	}
}
