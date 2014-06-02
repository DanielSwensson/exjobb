

public class GymBuddie {
	private UserManager userMgr = new UserManager();
	private SessionManager sessionMgr = new SessionManager();
	private Menu menu;

	
	public static void main(String[] args){
		new GymBuddie();
	}
	
	public GymBuddie(){
		
		this.menu = new Menu("Main menu");

		menu.addMenuItem(new MenuItem("Start workout", 'w'));
		menu.addMenuItem(new MenuItem("User management", 'u'));
		menu.addMenuItem(new MenuItem("Quit", 'q'));
		
		runMenu();
	}
	
	public void runMenu() {
		while(true) {
			menu.printMenu();
			Character userMenuChoice = menu.getMenuChoice();
	
			switch (userMenuChoice.toString()){
				case "w" :

					if (userMgr.getActiveUser() != null){
						User activeUser = userMgr.getActiveUser(); 
						System.out.println("\n\nCurrent user is: " +activeUser.getName());
						sessionMgr.runMenu(activeUser);

					}
					else {
						userMgr.addGuestUser();
						}
					break;
				case "u" :
					userMgr.runMenu();
					break;
				case "q" :
					System.out.println("Quitting...");
					System.exit(0);
					break;
				default:
					break;
				}
		}
	}
}
