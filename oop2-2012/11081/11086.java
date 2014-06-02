import java.io.Serializable;


public class StaffMember extends Person implements Serializable{

 private String role;
 
 public StaffMember(String firstName, String lastName, int age, double weight, String role){
  super (firstName, lastName, age, weight);
  this.role = role;
 }
 
 public String getRole(){
  return role;
 }
 public void traningCamp(double days){
		setWeight(getWeight() + days);
 }
}