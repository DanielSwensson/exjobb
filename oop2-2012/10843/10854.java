import java.util.Scanner;

public class ReadInput {
	private Scanner keyboard = new Scanner(System.in);
	
	public int readInt(String prompt){
		for (;;){
			try{
				System.out.println(prompt);
				int x=Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Error - should be a numeric value");
			}
		}
	}
	
	public String readString(String prompt){
		System.out.println(prompt);
		String str = keyboard.nextLine();
		return str;
	}
}
