import java.util.Scanner;

public class Input {
	
	Scanner keyboard = new Scanner(System.in);
	
	public int readInt (String prompt){
		for(;;){
			try{
				System.out.print(prompt);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;
			}
			
			catch (NumberFormatException e){
				System.out.println("Error, please input a numerical value.");
				
			}
		}
	}
	
	public String readString(String prompt){
		System.out.println(prompt);
		String x = keyboard.nextLine();
		return x;
	}

}
