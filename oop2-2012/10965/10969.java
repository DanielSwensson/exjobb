
public class Person {
	private String personNamn;
	private int total;
	
	public Person (String namn){
		personNamn = namn; 
	}
	public String getNamn (){
		return personNamn;
	}
	public int getTotal (){
		return total;
	}
	public void setTotal(int newTotal){
		total = newTotal;
	}
	public String toString (){
		return personNamn +"		" + getTotal();
	}
}


