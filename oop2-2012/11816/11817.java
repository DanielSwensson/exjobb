
//KlassHierarki.java

/******************************************************************
/
/ KlassHierarki.java skapar en lista med flera personer som �r antingen
/ studenter eller l�rare och l�gger till dessa i en arraylist och skriver
/ ut fakta
/
/ KlassHierarki.java anvander sig av: ArrayList<Klass>, �verlagring,
/ konstruktorer, klasser
/
/******************************************************************/

import java.beans.Expression;
import java.io.EOFException;
import java.util.*;

import javax.swing.JOptionPane;

public class KlassHierarki{
	private static Scanner scan;
	

	public static void main(String[] args){
		ArrayList<Person> al = new ArrayList<Person>();
		scan = new Scanner(System.in);
		for(;;){
			
		System.out.println("V�lj med siffor \n1. Ange nytt 2. Visa. 3. Avsluta");
	
		int val = readInt(scan.nextLine());
		switch(val){
		case 1:
			System.out.println("L�gg till (1)student eller (2)l�rare");
			String inNamn;
			boolean jaNej;
			String inSkola;
			String inUtbildning;
			double inBetyg;
			int in�lder;
			int valet = readInt(scan.nextLine());
			if(valet == 1){
				System.out.println("Ange namn p� Student");
				inNamn = scan.nextLine();

						System.out.println("Studiel�n(JA / NEJ)");
						jaNej = checkBoolean(scan.nextLine());
					System.out.println("Ange skola");
					inSkola = scan.nextLine();
					System.out.println("Ange utbildning");
					inUtbildning = scan.nextLine();
					System.out.println("Ange medelbetyg");
					inBetyg = Double.parseDouble(scan.nextLine());
					System.out.println("Ange �lder");
					in�lder = readInt(scan.nextLine());
					Student p = new Student(inNamn, jaNej, inSkola, inUtbildning, inBetyg, in�lder);
					al.add(p);
				
			}
			else if(valet == 2){
				System.out.println("Ange namn p� l�rare");
				String inNamnL�rare = scan.nextLine();
				System.out.println("Jobbar fulltid? (Ja/nej)");
				boolean inFull = checkBoolean(scan.nextLine());
				
				System.out.println("Ange l�n");
				int inL�n = readInt(scan.nextLine());
				System.out.println("Ange �lder");
				int �lder = readInt(scan.nextLine());
				Person l = new L�rare(inNamnL�rare, �lder, inFull, inL�n);
				al.add(l);
				
			}
			
			break;
		case 2:
			for(Person p : al){
				
				System.out.println(p.toString());
				
			}
			break;
		
		case 3:
			System.exit(0);
			default:
			System.out.println("V�lj med sifferknapparna: 1, 2, eller 3");
		}
		}
		
	}



	 static boolean checkBoolean(String booleanCheck){
		if(booleanCheck.equalsIgnoreCase("ja"))
			return true;
		else if(booleanCheck.equalsIgnoreCase("nej"))
			return false;
		else{
			System.out.println("Ange ja eller nej");
			return checkBoolean(scan.nextLine());
		}
	 }

	  static  int readInt(String inString){
	    	
	    	for(;;){
	    		try{
	    			if(inString == null)
	    				readInt(scan.nextLine());
	    			else
	    		return Integer.parseInt(inString);
	    	}catch(NumberFormatException e){
	    		System.out.println("Ange korrekt siffra");
	    		inString = scan.nextLine();
	    		readInt(inString);
	    		
	    	}continue;
	    	}
	  	
		
	}
	
	
}