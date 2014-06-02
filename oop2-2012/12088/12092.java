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
  
  //L�gger till ett objekt av Property i propertyList, Property objektet kan vara en Device, Jewelry, Stock eller
  //n�got annat som �r en generalisering av Property
  public void addProperty(Property p){
    propertyList.add(p);
  }
  
  //Skriver in alla personens �godelar i en string samt returnerar den, om personen inte �ger n�got returneras
  //en String med texten "ingenting."
  public String getAllProperty(ArrayList<Property> propertyList){
    String allProperty = "";
    for(int i=0; i<propertyList.size(); i++){
      allProperty += propertyList.get(i);
    }
    //Om personen inte �ger n�got
    if(allProperty.isEmpty()){
      return "ingenting. \n";
    }
    return allProperty;   
  }
  
  //R�knar ihop v�rdet av personens alla tillg�ngar
  public void estimateTotalValue(ArrayList<Property> propertyList){
    total=0;
    for(int i=0; i<propertyList.size(); i++){
      total += propertyList.get(i).getValue();
    }
  }
  
  //Returnerar v�rdet av alla tillg�ngar
  public int getTotalValue(){
    estimateTotalValue(propertyList);
    return total;
  }
  
  //Kallar p� crash() i alla personens Stock
  public void stockCrash(){
    for(int i=0; i<propertyList.size(); i++){
      if(propertyList.get(i) instanceof Stock){
        ((Stock)propertyList.get(i)).crash();
      }
    }
  }
  
  public String toString(){
    return "\n" + name + " �ger f�ljande: \n" + getAllProperty(propertyList) 
      + name + " har saker till ett v�rde av " + getTotalValue() + "\n -------------------- \n";
  }
  
}