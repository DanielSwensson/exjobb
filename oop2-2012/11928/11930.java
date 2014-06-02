import java.util.Date;


public abstract class Exercise {
	private double caloriesBurned;
	private String name;
	
	private int durationInSeconds;
	private int durationInMinutes;
	private Date startTime;
	private Date endTime;
	
	public Exercise(String name){
		this.name = name;
	}
	public Exercise(){
		
	}
	public abstract void calculateCaloriesBurned();
	public void calculateDuration(){
			if (endTime != null){
				this.durationInSeconds = (int) ((this.endTime.getTime() - getStartTime().getTime())/1000);
				this.durationInMinutes = getDurationInSeconds() /60;
	
			}
		}
	public void calculateEndTime(int secondsToAdd){
		//calculates the completion based upon minutes active 
		if (getStartTime() != null){
			Date start = getStartTime();
			Date end = (Date) start.clone();
			setEndTime(Io.addSecondsToTime(end, (secondsToAdd)));
		}
	}
	public void finaliseExercise(){
		calculateEndTime(getDurationInSeconds());
		calculateDuration();
	}
	public String getName(){
		return name;
	}
	public Date getStartTime(){
		return startTime;
	}
	public Date getEndTime(){
		return endTime;
	}
	public double getCaloriesBurned() {
		return caloriesBurned;
	}
	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	public int getDurationInSeconds(){
		return durationInSeconds;
	}
	public void setEndTime(Date endtime){
		if(endtime != null){
			this.endTime = endtime;
		}else{
			this.endTime = new Date();
		}
	}
	public void setName(String name){
		this.name = name;
	}
	
	public void setStartTime(Date startTime){
		
		if(startTime != null){
			this.startTime = startTime;
		}else{
			if(this.startTime == null){
				this.startTime = new Date();
			}else{
				System.out.println("there is already a start time and startdate");
			}
		}
	}
	public void setCaloriesBurned(double caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
		setDurationInSeconds(null);
	}
	public void setDurationInSeconds(Integer durationInSeconds) {
		if(durationInSeconds != null){
			this.durationInSeconds = durationInSeconds;
		}else{
			this.durationInSeconds =(getDurationInMinutes() *60);
		}
	}
	public String toString(){
		String returnString = "";
		returnString = returnString + "  Exercise: " 	+ getName();
		returnString = returnString + "\t  Date: " 	+ Io.formatDate(getStartTime());
		if (getStartTime() !=null) returnString = returnString + "\t  StartTime: " 	+ Io.formatTime(getStartTime());
		if (getEndTime() !=null) returnString = returnString + "\t  Finish time: " + Io.formatTime(getEndTime());
		if (getDurationInSeconds() != 0) returnString = returnString  + "\t  Duration :" + getDurationInMinutes() +" mins";
		if (getCaloriesBurned() != 0) returnString = returnString  + "\t  Calories burned :" + (Math.round(getCaloriesBurned()*10)/10.0) +" kcal";

		returnString = returnString + "\n";

		return returnString;
	}
}
