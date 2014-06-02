
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Io {
	private final static String ERROR_MESSAGE = "Invalid entry, please try again";

	public static String getString(String displayText){
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print(displayText + ": ");
		String userInputText = keyboard.nextLine() ;
		return (userInputText);
	}
	public static int getNumber(String displayText){
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int userInputNumber = 0;
		boolean correctInput = false;
		do{

			try {
				System.out.print(displayText + ": ");
				userInputNumber = keyboard.nextInt() ;
				correctInput = true;
		    } 
			catch (InputMismatchException e) {
				System.out.println(ERROR_MESSAGE);
				correctInput = false;
			}	
		}while(correctInput == false);
		return (userInputNumber);

	}	
	public static double getDecimalNumber(String displayText){
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		double userInputNumber = 0.0;
		boolean correctInput = false;
		do{
			try {
				System.out.print(displayText + ": ");
				userInputNumber = keyboard.nextDouble() ;
				correctInput = true;
		    } 
			catch (InputMismatchException e) {
				System.out.println(ERROR_MESSAGE);
				correctInput = false;
			}	
		}while(correctInput == false);
		return (userInputNumber);
	}	   

	public static char getChar(String displayText) throws StringIndexOutOfBoundsException{
		boolean correctInput = false;
		char userInputChar =' ';
		do{
			try{
				String userInputText = getString(displayText);
				userInputChar = userInputText.charAt(0);
				correctInput = true;
			} 
			catch (StringIndexOutOfBoundsException e){
				System.out.println(ERROR_MESSAGE);
			}
		}while(correctInput == false);
		
		return (userInputChar);
	}
	public static Date getDateTime(String displayText) throws ParseException{
		boolean correctInput = false;
		Date returnDate;
		do{
			String userDateTime = getString(displayText +"\nPlease enter the date and time (ie 2013-01-15 13.01) \tor \"Today \" for today");
			if (userDateTime.equalsIgnoreCase("today")){
				returnDate = Io.getTime(formatDate(new Date()));

			}else{
				returnDate = makeDateTimeFromString(userDateTime);
			}
			correctInput = true;
		}while(correctInput == false);
		return returnDate;
	}
	public static void getDate() throws ParseException{
		boolean correctInput = false;
		do{
			String userDate = getString("Please enter the date (ie 2013-01-15)");
			Io.makeDateFromString(userDate);
			correctInput = true;
		}while(correctInput == false);

	}

	public static Date getTime(String date) throws ParseException{
		Date returnTime;

		boolean correctInput = false;
		do{
			String userTime = getString("Please enter the date and time (ie 13.01)");
			returnTime = makeDateTimeFromString(date +" " + userTime);
			correctInput = true;
		}while(correctInput == false);
		return returnTime;
	}
	
	
	public static void printHeader(String headerText, int indentation){
		System.out.println("\n" + printBlanks(indentation) + headerText);
		System.out.print(printBlanks(indentation) + makeBorder(headerText.length(), indentation));


		System.out.println();
	}
	private static String makeBorder(int lenghtOfBorder, int menuLevel){
		
		String border ="";
		
		for (int x = 0 ; x< lenghtOfBorder ;x++){
			border = border + ("=");
		}
		return border;
	}
	public static String printBlanks(int noOfSpaces){
		String returnSpaces = "";
		
		for (int x = 0; x < noOfSpaces; x++){
			returnSpaces = returnSpaces + " ";
		}
		
		return returnSpaces;
	}
	
	//Time and date functions
	
	public static Date addSecondsToTime(Date endDate, int secToAdd){
		/*
		adds SecondsToAdd of seconds to a time by converting them over to milliseconds and then converting back again
		when using this method, clone the date if you want to keep the original value. 
		cloning is done like this Date d2 = (Date) d1.clone(); where d1 is the old value and d2 is the new value
		cloning clones the object and puts is as an object rather than as a date. this is why we are casting it back to 
		a Date  (SOLVED??)
		*/

		Date d = new Date();
		long msToAdd = secToAdd*1000; 
		long endDateInMs = endDate.getTime();
		d.setTime(endDateInMs);
		endDateInMs = endDateInMs + msToAdd;
		d.setTime(endDateInMs);

		return d;
	} 
	
	public static String formatTime(Date d){
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		return timeFormat.format(d);
	}
	public static String formatDate(Date d){
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
		return timeFormat.format(d);
	}
	
	public static int  calculateTimeDiff(Date startTime, Date endTime){
		int secondsDifference = (int)(endTime.getTime()- startTime.getTime())/1000;
		
		return secondsDifference;
	}
	
	public static Date makeDateFromString(String date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = dateFormat.parse(date);
		} catch (ParseException e) {
			System.out.println("Something went wrong when parsing");
			d = null;
		}
		return d;
	}
	
	public static Date makeDateTimeFromString(String dateTime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm");
		Date d =null;
		try {
			d = dateFormat.parse(dateTime);
		} catch (ParseException e) {
			System.out.println("Something went wrong when parsing the dateTimeString. Correct format is yyyy-MM-dd HH:mm");
		}
		return d;
	}
	
	public static Date makeTimeFromString(String time){
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH.mm");
		Date d= null;
		try {
			d = timeFormat.parse(time);
		} catch (ParseException e) {
			System.out.println("Something went wrong when parsing the time. Correct format is HH.mm");
		}
		return d;
	}
}





