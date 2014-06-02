import java.util.Scanner;

public abstract class Event {
	private boolean isCompleted = false;
	private String description;
	
	public Event(String descrption){
		
		this.description = descrption;
	}
	
	public static void pause() {
		Scanner keyIn = new Scanner(System.in);
		
		System.out.println("Press the enter key to continue...");
		keyIn.nextLine();
	}
	
	public String getDescription(){
		
		return description;
	}

	public void setIsCompleted(boolean value){
		isCompleted = value;
	}
	
	public boolean getIsCompleted(){
		return isCompleted;
	}
	
	public abstract Player startEvent(Player player);
	
}
