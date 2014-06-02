public class Person {
	
	private String personName;
	private int personTotalValue;
	
	public Person(String personNameData){
		personName = personNameData;			
	}
	
	public Person(int personTotalValueData){
		personTotalValue = personTotalValueData;
	}

	public String getpersonName(){
		return personName;		
	}
	
	public String toString(){
		return "Name: "+ personName +" - "+ personTotalValue +"";
	}
	
}

	


