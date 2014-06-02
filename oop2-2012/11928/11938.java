
public class SessionManager {
	private Menu menu;
	private User currentUser;
	private WorkoutManager workoutMgr = new WorkoutManager();


	public SessionManager(){
		this.menu = new Menu("Session Menu");
		menu.addMenuItem(new MenuItem("Start Exercising!!!", 's'));
		menu.addMenuItem(new MenuItem("End a session", 'e'));
		menu.addMenuItem(new MenuItem("View current session", 'c'));
		menu.addMenuItem(new MenuItem("List sessions", 'l'));
		menu.addMenuItem(new MenuItem("Delete a  session", 'd'));
		menu.addMenuItem(new MenuItem("Go to parent menu", 'p'));
	}

	private void sessionList(){
		Io.printHeader("Session list", 2);
		for (Session s : currentUser.sessions){
			System.out.println(s);
		}
	}
	private void viewCurrentSession(){
		Io.printHeader("Current session", 2);
		if (currentUser.currentSession != null){
			System.out.println(currentUser.currentSession);
		}
		else {
			System.out.println("there is no current session");
		}
	}
	
	private void sessionEnd() {
		//sets a timestamp on the current session and thereby ending it.
		//the current session is then saved in the sessions-ArrayList and emptied.
		currentUser.currentSession.sessionEnd();
		currentUser.currentSession = null;
		
	}

	private void sessionStart() {
		if (currentUser.currentSession == null){
			currentUser.currentSession = new Session();
			currentUser.currentSession.sessionStart();
			currentUser.sessions.add(currentUser.currentSession);
		}else{
			System.out.println("You can only have one active session at a time");
		}
	}
	
	
	public void runMenu(User user) {
		currentUser = user;
		boolean menuBreak = false;
		do {
			menu.printMenu();
			Character userMenuChoice = menu.getMenuChoice();
			switch (userMenuChoice.toString()){
				case "e" : //ends a session 
					sessionEnd();
					break;
				case "c" : //view current  session 
					viewCurrentSession();
					break;
				case "s": //Start exercise
					if (currentUser.currentSession != null){
						workoutMgr.runMenu(currentUser);
					}else{
						sessionStart();
						workoutMgr.runMenu(currentUser);

					}
					break;
				case "l" : //list all users 
					sessionList();
					break;
				case "d" : //delete a session 
					break;
				case "p" : //g
					menuBreak = true;
					break;
				}
		}while(menuBreak == false);
	}

}
