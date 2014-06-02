import java.util.*;

public class InputHelper {
	
	private Scanner keyboard = new Scanner(System.in);

	public int readInt(String question) {
		return readInt(question, Integer.MIN_VALUE);
	}

	public int readInt(String question, int min) {
		return readInt(question, min, Integer.MAX_VALUE);
	}
	
	public int readInt(String question, int min, int max) {
		while(true) {
			try {
				System.out.println(question);
				int y = Integer.parseInt(keyboard.nextLine());
			
				if (y < min || y > max) {
					System.out.println("Out of range, please try again.");
					continue; 
				}
				
				return y;
				
			} catch (NumberFormatException e) {
				System.out.println("Wrong, you need to type a numerical value.");
			} catch(InputMismatchException e) {
				System.out.println("Wrong, needs to be written in text. ");
			}
		}
		
	}
	
	public String readString(String question) {
		
		System.out.println(question);
		String str = keyboard.nextLine();
		
		return str;
	}
}
