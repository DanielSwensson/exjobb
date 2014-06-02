
public class Time {
	private int minute = 0;
	private int second = 0;
	
	public Time(int second, int minute){
		boolean done = false;
		while(!done){
			if(second >= 0 && second < 60){
				this.minute = minute;
				this.second = second;
				done = true;
			}
			else{
				while(second >= 60){
					minute += 1;
					second -= 60;
				}
			}
		}
	}
	
	public String toString(){
		if(second < 10){
			return this.minute + ":" + "0" + this.second;
		}
		else{
			return this.minute + ":" + this.second;
		}
	}
}
