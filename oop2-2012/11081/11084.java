import java.io.Serializable;

public class Person implements Serializable{

 private String firstName;
 private String lastName;
 private int age;
 private double weight;
 
 public Person (String firstName, String lastName, int age, double weight){
  this.firstName = firstName;
  this.lastName =lastName;
  this.age = age;
  this.setWeight(weight);
 }
 
 public String getFirstName(){
  return firstName;
 }
 
 public String getLastName(){
  return lastName;
 }
 
 public int getAge(){
  return age;
 }
 
 public double getWeight(){
  return weight;
 }
 
 public void traningCamp(double days){
  weight =+ days;
 }

 public void setWeight(double Weight) {
  Weight = weight;
 }
}