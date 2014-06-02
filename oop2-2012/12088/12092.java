import java.util.*;

public class Person{
  
  private String name;
  private int total;
  private ArrayList<Property> propertyList = new ArrayList<Property>();
  private static int anonymousCounter = 1;
  
  //Om det skickas med ett namn
  public Person(String name){
    this.name = name;
    this.total = 0;
  }
  
  //Om det inte skickas med ett namn
  public Person(){
    this.name = "Anonym " + anonymousCounter;
    anonymousCounter++;
  }
  
  //Returnerar personens namn
  public String getName(){
    return name;
  }
  
  //Lägger till ett objekt av Property i propertyList, Property objektet kan vara en Device, Jewelry, Stock eller
  //något annat som är en generalisering av Property
  public void addProperty(Property p){
    propertyList.add(p);
  }
  
  //Skriver in alla personens ägodelar i en string samt returnerar den, om personen inte äger något returneras
  //en String med texten "ingenting."
  public String getAllProperty(ArrayList<Property> propertyList){
    String allProperty = "";
    for(int i=0; i<propertyList.size(); i++){
      allProperty += propertyList.get(i);
    }
    //Om personen inte äger något
    if(allProperty.isEmpty()){
      return "ingenting. \n";
    }
    return allProperty;   
  }
  
  //Räknar ihop värdet av personens alla tillgångar
  public void estimateTotalValue(ArrayList<Property> propertyList){
    total=0;
    for(int i=0; i<propertyList.size(); i++){
      total += propertyList.get(i).getValue();
    }
  }
  
  //Returnerar värdet av alla tillgångar
  public int getTotalValue(){
    estimateTotalValue(propertyList);
    return total;
  }
  
  //Kallar på crash() i alla personens Stock
  public void stockCrash(){
    for(int i=0; i<propertyList.size(); i++){
      if(propertyList.get(i) instanceof Stock){
        ((Stock)propertyList.get(i)).crash();
      }
    }
  }
  
  public String toString(){
    return "\n" + name + " äger följande: \n" + getAllProperty(propertyList) 
      + name + " har saker till ett värde av " + getTotalValue() + "\n -------------------- \n";
  }
  
}