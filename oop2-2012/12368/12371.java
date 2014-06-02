//rättad
import java.util.Scanner;
import java.lang.Object;
import java.util.ArrayList;

public class area51 {
	static Scanner scanner = new Scanner(System.in);
	Alien a;
	Doctor d;
	static ArrayList<Alien> aliens = new ArrayList<Alien>();
	static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	String[] Docnr = new String[15];

	int date, id, Did, repdate, input, Dinput, Doclv, autop;
	String name, ALname, des, rep, iD, DiD, asDoc, field, subDoc;
	boolean datecontrol;
//Kontroll------------------------------------------------------
	int AlienIdControl(){
			int clear=1;
			int idtest;
			int x;
			for(;;){
				idtest= IntToStrControl2("Alien idenfication number");
				for(x=0; x<aliens.size(); x++){
					a=aliens.get(x);
					if(idtest == a.getID()){
						clear=0;
						break;
					}
					clear=1;
				}
				if(clear==1) return idtest;
				else if(clear==0){
					 System.out.println("--!Alien profile already exists!--");
				}
			}
	}

	int DocIdControl(){
			int clear=1;
			int idtest;
			int x;
			for(;;){
				idtest= IntToStrControl2("Doctor idenfication number");
				for(x=0; x<doctors.size(); x++){
					d=doctors.get(x);
					if(idtest == d.getID()){
						clear=0;
						break;
					}
					clear=1;
				}
				if(clear==1) return idtest;
				else if(clear==0){
					 System.out.println("--!Doctor profile already exists!--");
				}
			}
	}

	void ExitControl(){
		for(;;){
			String exit = scanner.next();
			if(exit.equals("exit") ||  exit.equals("EXIT") || exit.equals("Exit")) break;
			else System.out.print("--!Inappropriate statement!--");
		}
	}

	int ExitControl2(){
		String input2;
		input2= scanner.next();
		for(;;){
			if(input2.equals("exit") ||  input2.equals("EXIT") || input2.equals("Exit")) return 0;
			else if(input2.equals("report") ||  input2.equals("REPORT") || input2.equals("Report")) return 1;
			else{
				 System.out.print("--!Inappropriate statement!--");
				 input2= scanner.next();
			}
		}
	}

	int IntToStrControl(String statement, String question){
		for(;;){
			try{
				int x = Integer.parseInt(statement);
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("--!" + question + " should be a numeric value!--");
				pickAlien();
			}
		}
	}

	int IntToStrControl2(String question){
		String statement;
		for(;;){
			System.out.print(question + ": "); statement= scanner.next();
			try{
				int x = Integer.parseInt(statement);
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("--!" + question + " should be a numeric value!--");
				//pickAlien();
			}
		}
	}

	int IntToStrControl3(String statement, String question){
		for(;;){
			try{
				int x = Integer.parseInt(statement);
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("--!" + question + " should be a numeric value!--");
				pickDoctor();
			}
		}
	}

	boolean DateControl(int date){
		int length= String.valueOf(date).length();
		if(length%8==0 || length%6==0) return true;
		else return false;
	}

	String DocControl(String question){
		String nameinput, doccheck, add;
		int x, y, z, q=0;
		boolean namecheck=false, redo=false, enough=false;
		for(;;){
			System.out.print(question);
			nameinput= scanner.next() + scanner.nextLine();
			for(z=0; z<nameinput.length(); z++){
				if(nameinput.charAt(z) == ',') q++;
			}
			Scanner scC = new Scanner(nameinput).useDelimiter("\\s*,\\s*");

			for(x=0; x<=q; x++){
				Docnr[x]=(scC.next());
				for(y=0; y<doctors.size(); y++){
					d = doctors.get(y);
					doccheck= d.getName();
					if(Docnr[x].equals(doccheck)){
						namecheck=true;
						break;
					}
				}
				if(namecheck==false){
					System.out.println("--" + Docnr[x] + "'s profile does not exist in the doctor list--");
					redo=true;
				}
			}
			scC.close();
			if(redo==true){
				System.out.println("||                                --Type 'add' to add doctor to the doctor list || Type 're' to rewrire--                           ||");
				add= scanner.next();
				if(add.equals("add") || add.equals("ADD") || add.equals("Add")) newDoctor();
				else DocControl(question);
				return nameinput;
			}
			else if(redo==false) return nameinput;
		}
	}

	String FieldControl(){
		String check;
		check= scanner.next() + scanner.nextLine();
		for(;;){
			if(check.equalsIgnoreCase("Chief") || check.equalsIgnoreCase("Autopsy") || check.equalsIgnoreCase("Marsian Alien") || check.equalsIgnoreCase("no specific")) return check;
			else System.out.println("--!Inappropriate statement!--");
			check= scanner.next() + scanner.nextLine();
		}
	}
//--------------------------------------------------------------
//MAIN----------------------------------------------------------
    public static void main(String[] args) {

		aliens.add(new Alien(20130716, "Marcus Xenon, Adrian Brown", 1001, "Raritus Malignus a.k.a Greyskin", "Six pitch black eyes, a stretched human-like cranium, two rows of sharp teeth, human-like body structure, two pairs of long forearms connected to correspondent upper arms, bird-like bone structure in the legs, human-like feet, grey skin and seemingly six sharp spines pointing out from the back." ));
    	doctors.add(new Doctor(20120819, 101, "Marcus Xenon", 3));
    	doctors.add(new Doctor(20120209, 98, "Adrian Brown", 3));
    	doctors.add(new Doctor(20110523, 67, "Hamir Hawk", 1));

		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("** **               AREA 51                                                            ** ** ");
		System.out.println("** **                    AUTHORISED PERSONNEL COMMAND PAGE                                               ** ** ");
		System.out.println("----------------------------------------------------------------------------------\r\n \r\n");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("||                       ----WELCOME CHIEF DOCTOR---                                                    ||");
		System.out.println("||                                                                                                                                         ||");
		System.out.println("||                            COMMAND LIST                                                            ||");
		System.out.println("||                           1: New specimen profile                                                       ||");
		System.out.println("||                       	2: View specimen profiles                                                      ||");
		System.out.println("||                         	 3: View doctor profiles                                                       ||");
		System.out.println("||                          	 4: New doctor profile                                                       ||");
		System.out.println("||                               5: Exit Program                                                          ||");
		Command();
	}

	public static void Command(){
		area51 main = new area51();
		boolean con=true;
		String commandcheck;
		int command;
		System.out.println("-------------------------------------------------------------------------------------------");
		while(con==true){
			System.out.print("--command--: ");
			commandcheck = scanner.next();
			try{
				command= Integer.parseInt(commandcheck);
				switch(command) {
				case 1 : main.newAlien(); break;
				case 2 : main.viewAlien(); break;
				case 3 : main.viewDoctor(); break;
				case 4 : main.newDoctor(); break;
				case 5 : System.exit(0);
				default : System.out.println("--!Inappropriate command!--");
				}
			}
			catch (NumberFormatException e){
				System.out.println("--!Command should be a numeric value!--");
			}
		}
	}

//NY ALIEN------------------------------------------------------
	public void newAlien(){
		int x;
		System.out.println("----------------------------------------------------------------------------------");
		for(;;){
			date= IntToStrControl2("Date (yyyymmdd)");
			datecontrol= DateControl(date);
			if(datecontrol==true) break;
			else System.out.println("--!Inappropriate date!--");
		}
		asDoc= DocControl("Doctors assigned to specimen: ");
		id= AlienIdControl();
		System.out.print("Alien name:"); ALname= scanner.next() + scanner.nextLine();
		System.out.print("Alien description:"); des = (scanner.next() + scanner.nextLine());

		System.out.println("||      --Type 'report' to proceed to the report || Type 'exit' to exit to command list--                        ||");
		input = ExitControl2();
		if(input==0){
			 aliens.add(new Alien(date, asDoc, id, ALname, des));
			 if(aliens.isEmpty()==false){
					for(x=0; x<aliens.size(); x++){
						a = aliens.get(x);
						int check = a.getID();
						if(id<check || check==0)break;
					}
			  }
			 Command();
		}
		else if(input==1) {
			Report();
		}
	}

	void Report(){
		int x;
		System.out.println("\n                --- REPORT ---   \n");
		for(;;){
			date= IntToStrControl2("Date (yyyymmdd)");
			datecontrol= DateControl(date);
			if(datecontrol==true) break;
			else System.out.println("--!Inappropriate date!--");
		}
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.print("Report: "); rep = (scanner.next() + scanner.nextLine());
		rep= "Date: " + repdate + ("\n--------------------------------------------------------------------------") + "\nReport: " + rep+ "\n";
		aliens.add(new AlienReport(date, asDoc, id, ALname, des, rep));
		if(aliens.isEmpty()==false){
				for(x=0; x<aliens.size(); x++){
					a = aliens.get(x);
					int check = a.getID();
					if(id<check || check==0) break;
				}
		}
	}

//VISA ALIEN---------------------------------------------------
	public void viewAlien(){
		int x;
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("** **      	   <<TOP SECRET -- CLASSIFIED INFORMATION>>                                        ** **\r");
		System.out.println("|| 						        LIST OF SPECIMEN												      ||");
		for(x=0; x<aliens.size(); x++){
			a=aliens.get(x);
			System.out.println("> " + a.getListinfo());
		}
		System.out.println("---------------------------------------------------------------------------------------");
		pickAlien();

	}

	void pickAlien(){
		int x;
		boolean idcheck=false;
		System.out.println("||   --Type idenfication number of desired alien to view the more detailed profile || Type 'exit' to exit list--         ||");
		iD = scanner.next();
		if(!iD.equals("exit") && !iD.equals("EXIT") && !iD.equals("Exit")) {
			id = IntToStrControl(iD, "Identification number");
			for(x=0; x<aliens.size(); x++){
				a = aliens.get(x);
				int check2 = a.getID();
				if(id==check2){
					 idcheck=true;
					 break;
				}
			}
			if(idcheck==true) viewDetAlien(x);
			else if(idcheck==false){
				 System.out.println("--There is no alien profile with typed idenfication number--");
				 pickAlien();
			}
		}
		Command();
	}

	void viewDetAlien(int nr){
		a = aliens.get(nr);
		System.out.println("\n" + a);
		System.out.println("||    --Type 'report' to update report || Type 'exit' to exit to specimen list--                        ||");
		input = ExitControl2();
		if(input==0) viewAlien();
		else if(input==1) Report2(nr);
	}

	void Report2(int nr){
		int x, arraypos=nr;
		a= aliens.get(nr);
		System.out.println("\n         --- REPORT ---   \n");
		for(;;){
			repdate= IntToStrControl2("Date (yyyymmdd)");
			datecontrol= DateControl(repdate);
			if(datecontrol==true) break;
			else System.out.println("--!Inappropriate date!--");
		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.print("Report: "); rep = (scanner.next() + scanner.nextLine());
		rep= "Date: " + repdate + ("\n-----------------------------------------------------------------------------") + "\nReport: " + rep+ "\n";
		if(a instanceof AlienReport){
			 ((AlienReport)a).updateReport(rep);
		}
		else{
			date= a.getDate();
			asDoc= a.getDocs();
			id= a.getID();
			ALname= a.getName();
			des= a.getDes();
			aliens.set(arraypos, new AlienReport(date, asDoc, id, ALname, des, rep));
			if(aliens.isEmpty()==false){
					for(x=0; x<aliens.size(); x++){
						a = aliens.get(x);
						int check = a.getID();
						if(id<check || check==0) break;
					}
			}
		}
	}

//VISA DOKTOR---------------------------------------------------
	public void viewDoctor(){
		int x;
		//doctors.add(new Doctor(id, date, name));
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("** **          <<AREA 51 PERSONNEL>>                                                ** **");
		System.out.println("|| 				      LIST OF DOCTORS												      ||\r");
		for(x=0; x<doctors.size(); x++){
			d=doctors.get(x);
			System.out.println("> " + d.getListinfo());
		}
		System.out.println("--------------------------------------------------------------------------------------\n");
		pickDoctor();
	}

	public void pickDoctor(){
		int x;
		boolean Didcheck=false;

		System.out.println("||   --Type idenfication number of desired doctor to view the more detailed profile || Type 'exit' to exit list--         ||");
		DiD= scanner.next();
		if(!DiD.equals("exit") && !DiD.equals("EXIT") && !DiD.equals("Exit")) {
			Did = IntToStrControl3(DiD, "Identification number");
			for(x=0; x<doctors.size(); x++){
				d = doctors.get(x);
				int check2 = d.getID();
				if(Did==check2){
					 Didcheck=true;
					 break;
				}
			}
			if(Didcheck==true) viewDetDoctor(x);
			else if(Didcheck==false){
				 System.out.println("--There is no doctor's profile with typed idenfication number--");
				 pickDoctor();
			}
		}
		Command();
	}

	void viewDetDoctor(int nr){
		d = doctors.get(nr);
		System.out.println("\n" + d);
		System.out.println("||         --Type 'exit' to exit to doctor's list--                                               ||");
		ExitControl();
		pickDoctor();
	}

//NY DOKTOR---------------------------------------------------

	public void newDoctor(){
		char control;
		boolean faltyinput=true;
		System.out.println("------------------------------------------------------------------------------");
		for(;;){
			date= IntToStrControl2("Date of employment(yyyymmdd)");
			datecontrol= DateControl(date);
			if(datecontrol==true) break;
			else System.out.println("--!Inappropriate date!--");
		}
		id= DocIdControl();
		System.out.print("Doctor's name:"); name= scanner.next();

		while(faltyinput==true){
			faltyinput=false;
			System.out.print("Doctor's field (Chief, Autopsy, Marsian Alien, no specific): "); field= FieldControl();
			control= field.charAt(0);

			switch(control){
				case 'C' : case 'c': subDoc= DocControl("Teamleader over doctors: "); Doclv=4; doctors.add(new ChiefDoctor(date, id, name, Doclv, field, subDoc)); break;
				case 'A' : case 'a': autop= IntToStrControl2("Number of successful autopsies: "); Doclv=2; doctors.add(new AutopsyDoctor(date, id, name, Doclv, field, autop)); break;
				case 'M' : case 'm': Doclv=1; doctors.add(new MarsianDoctor(date, id, name, Doclv, field)); break;
				case 'N' : case 'n': Doclv=3; doctors.add(new Doctor(date, id, name, Doclv)); break;
				default : System.out.println("--!Inappropriate statement!--"); faltyinput=true;
			}
		}
		Command();
	}
}


