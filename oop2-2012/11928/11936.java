import java.text.ParseException;
import java.util.Date;



public class Promenade extends Exercise{
	private int noOfSteps;
	private double pace;
	private double distanceWalkedInMeters;
	
	public Promenade(int noOfSteps) {
		super("Promenade");
		setNoOfSteps(noOfSteps);
	}
	public Promenade() {
		super("Promenade");
		Date s;
		try {
			s = Io.getDateTime("When was your promenade?");
			setStartTime(s);
		} catch (ParseException e){}

		setDurationInMinutes(Io.getNumber("How many minutes did you walk?"));
		setEndTime(null);
		setNoOfSteps(Io.getNumber("How many steps did you take"));
	}
	
	
	private void setNoOfSteps(int noOfSteps){
		this.noOfSteps = noOfSteps;

	}

	private void calculatePace(){

		double metersPerHour = (distanceWalkedInMeters *60) /getDurationInMinutes();
		double kmPerHour = metersPerHour/1000;
		this.pace = kmPerHour;
	}
	
	private void calculateDistanceWalked(double strideLength){
		this.distanceWalkedInMeters = noOfSteps * strideLength;
	}
	
	public void finaliseExercise(double strideLength){
		calculateDistanceWalked(strideLength);
		calculatePace();
		calculateEndTime(getDurationInSeconds());
		calculateDuration();
		calculateCaloriesBurned();
	}
		
	public void calculateCaloriesBurned(){
		/*The calculation is based upon the table found on http://www.fitjog.com/fat-loss/exercise-calorie-calculator.php
		 * 
		*CaloriesPerHour		Speed (km/Hour)		calories per second
		*229					3,5					0,063611111
		*292					5					0,081111111
		*350					6,5					0,097222222
		*/
		double caloriesPerSecond = 0.0;
		if(pace < 5){
			caloriesPerSecond = 0.063611111;
		}else if(pace > 5 && pace < 6.5){
			caloriesPerSecond = 0.081111111;
		}else if(pace < 6.5){
			caloriesPerSecond = 0.097222222;
		}
		
		double caloriesBurned = getDurationInSeconds() * caloriesPerSecond;
		setCaloriesBurned(caloriesBurned);
	}

	
	public String toString(){
		String returnString = "";
		returnString = returnString + "  Exercise: " 	+ getName();
		returnString = returnString + "\t  Date: " 	+ Io.formatDate(getStartTime());
		if (getStartTime() !=null) returnString = returnString + "\t  StartTime: " 	+ Io.formatTime(getStartTime());
		if (getEndTime() !=null) returnString = returnString + "\t  Finish time: " + Io.formatTime(getEndTime());
		returnString = returnString  + "\t  Duration :" + getDurationInMinutes() +" mins";
		if (noOfSteps != 0) returnString = returnString  + "\t  Steps :" + noOfSteps;
		if (distanceWalkedInMeters != 0) returnString = returnString  + "\t  Distance walked :" + (Math.round(distanceWalkedInMeters *10)/10.0) + " m";
		if (getCaloriesBurned() != 0) returnString = returnString  + "\t  Calories burned :" + (Math.round(getCaloriesBurned()*10)/10.0) +" kcal";
		returnString = returnString  + "\t  Pace :" + (Math.round(pace*10)/10.0 + "km/h");
		returnString = returnString + "\n";

		return returnString;
	}
}
