import java.util.ArrayList;
import java.util.Date;

public class Session {
	private ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	private Date endDate;
	private double totalCaloriesBurned;
	protected Date startDate;
	
	public Session(){
		sessionStart();
	}
	public void calculateTotalCaloriesBurned(){
		totalCaloriesBurned = 1.1;
	}

	public void sessionEnd() {
		calculateTotalCaloriesBurned();
		endDate = new Date();
	}
	public void sessionStart() {
		this.startDate = new Date();
	}
	public String toString(){
		String returnString = "";
		
		returnString = returnString + "Date: " + Io.formatDate(startDate);
		returnString = returnString + "\tStart time: " + Io.formatTime(startDate);
		if (endDate != null){
			returnString = returnString + "\tEnd time: " + Io.formatTime(endDate);
		}else{
			returnString = returnString + "\tEnd time: <<active>>";
		}
		returnString = returnString + "\tNoOf Workouts: " + exercises.size();
		returnString = returnString + "\tCaloriesBurned: " + totalCaloriesBurned;
	
		return returnString;
	}
}



