
public class ValuableRegisterProgram {

	private static InputHelper help = new InputHelper();
	
	public static void main(String[] args) {
		
		PersonRegister register = new PersonRegister();
		
		while(true) {
			System.out.println("");
			int choice = help.readInt("Choose what you want to do:\n\t\n\t1.Add new person.\n\t2.Add new Valuable. \n\t3.Show all persons. \n\t4.show specific person. \n\t5.Show richest person. \n\t6.Create stockcrash. \n\t7. Exit.");
						
			switch (choice) {
				case 1: register.newPerson(); break;
				case 2: register.newValuable(); break;
				case 3: register.showAll(); break;
				case 4: register.showPerson(); break;
				case 5: register.richestPerson(); break;
				case 6: register.stockCrash(); break;
				case 7: System.exit(0); break;
					
				default: System.out.println("None of the upper choices, try a number between 1-7.");
			
			}	
		}
	}
	
}
