import java.text.ParseException;
import java.util.Date;


public class Weightlifting extends Exercise{
	private int repetions;
	private String musclegroup;
	
	public Weightlifting() {
		setName("Weights");
		setDuration();
		setReptitions();
		setMusclegroup();

		setStartTime();
		calculateCaloriesBurned();
		setEndTime(null);	
	}

	public void calculateCaloriesBurned() {
		//This is not an accurate formula, but its based on that an hour burns 300 kcal's
		double kcal = getDurationInMinutes() * (300/60); 
		setCaloriesBurned(kcal);
	}
	
	public void finaliseExercise(){
		calculateEndTime(getDurationInSeconds());
		calculateDuration();
	}
	
	public String getMusclegroup(){
		return this.musclegroup;
	}
	public int getRepetitions(){
		return this.repetions;
	}
	
	private void setStartTime(){
		Date s;
		try {
			s = Io.getDateTime("When did you do this");
			setStartTime(s);
		} catch (ParseException e){}
	}


	private void setDuration() {
		super.setDurationInMinutes(Io.getNumber("For how many minutes"));
	}
	
	private void setReptitions() {
		this.repetions = Io.getNumber("How many repetitions did you do");
	}

	private void setMusclegroup() {
		this.musclegroup = Io.getString("Which musclegroup did you work on");
	}

	public String toString(){
		String returnString = "";
		returnString = returnString + "  Exercise: " 	+ getName();
		returnString = returnString + "\t  Date: " 	+ Io.formatDate(getStartTime());
		if (getStartTime() !=null) returnString = returnString + "\t  StartTime: " 	+ Io.formatTime(getStartTime());
		if (getEndTime() !=null) returnString = returnString + "\t  Finish time: " + Io.formatTime(getEndTime());
		if (getDurationInSeconds() != 0) returnString = returnString  + "\t  Duration :" + getDurationInMinutes() +" mins";
		if (getCaloriesBurned() != 0) returnString = returnString  + "\t  Calories burned :" + (Math.round(getCaloriesBurned()*10)/10.0) +" kcal";
		
		if (getMusclegroup() != null) returnString = returnString  + "\t  Musclegroup :" + getMusclegroup();
		if (getRepetitions() != 0) returnString = returnString  + "\t  Reps :" + getRepetitions();

		
		returnString = returnString + "\n";

		return returnString;
	}
}
