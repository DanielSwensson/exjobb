import java.text.ParseException;
import java.util.Date;


public class Cardio extends Exercise{

	public Cardio() {
		setName(getExerciseType());
		setDuration();
		setCaloriesBurned();
		setStartTime();
		calculateCaloriesBurned();
		setEndTime(null);	
	}

	public void calculateCaloriesBurned() {
		//intentinally left empty since this data is set already
	}
	
	public void finaliseExercise(){
		calculateEndTime(getDurationInSeconds());
		calculateDuration();
	}
	
	private String getExerciseType(){
		String typeOfCardio = "";

		boolean correctInput= false;
		while(correctInput == false){
			typeOfCardio = Io.getString("What type of cardio? Treadmill (or t) or crosstrainer (or c)");
			switch (typeOfCardio){
			case "t":
				typeOfCardio= "treadmill";
				break;
			case "c":
				typeOfCardio= "crosstrainer";
				break;
			}
			if (typeOfCardio.equals("treadmill") != false || typeOfCardio.equals("crosstrainer") != false ){
				correctInput = true;
			}
		}
		return typeOfCardio;
	}
	private void setStartTime(){
		Date s;
		try {
			s = Io.getDateTime("Please enter the time of your exercise");
			setStartTime(s);
		} catch (ParseException e){}
	}

	private void setCaloriesBurned() {
		super.setCaloriesBurned((double) Io.getNumber("How many calories did you burn"));
		
	}

	private void setDuration() {
		super.setDurationInMinutes(Io.getNumber("For how many minutes"));
	}
}
