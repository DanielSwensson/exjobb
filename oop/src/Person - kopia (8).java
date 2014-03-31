import java.util.*;
public class Person {
	
	private String namn;
	public ArrayList<Pryl> pryllista = new ArrayList<Pryl>();

    public Person(String n){
    		namn = n;
    }
    
	public String getNamn(){
    	return namn;	
    }
    public String toString(){
    	return namn;
    }
    
}