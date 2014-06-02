package value.register;
//Jakob Elldin Mårtensson
//DSV, Stockholm University
//Inlupp 2 för OOP
import java.util.*;

public class Person {
	
	private String name;
	private float totalValue; //det är lite risky bzns att ha value som en variabel och inte endast en metod, men så länge man kommer ihåg att nollställa värdet varje gång man ska söka igenom listan går det snabbare att mäta t.ex. vem som har störst värde
	
	
	//skulle kunnat ha en lista med items som fylls för varje item som läggs till	
	
	
	public Person(String s){
		this.name = s;
	}//end konstruktor

	public Person(String n, float v){
		this.name = n;
		this.totalValue = v;
	}//end konstruktor 2
	
	public String getName(){
		return name;
	}//end getname
	
	public float getTotalValue(){
		return totalValue;
	}//end gettotalvalue
	
	/*
	private void setTotalValue(float f){
		this.totalValue = f;
	}//end settotalvalue
	*/
	
	public void addTotalValue(float f){
		this.totalValue += f;
	}
	
	public String toString(){
		return "Name: "+name+" | Total value: "+totalValue+" ";
	}
	
	public float calcTotalValue(String n, List<Item> i){
		//jämför namnet (som ska vara det samma som person name)
		//går igenom en lista med items och hittar de som har owner == name
		//adderas deras value till totalvalue
		//returnerar totvalue
		
		//if (name.equals(n)){ //kan tänkas att denna ifsats inte kommer behövas
			totalValue = 0;
			
			for (Item it: i){
				if (it.getOwner().equals(name))
					addTotalValue(it.getValue()); 
					//skickar item till en metod i item som undersöker vilken subklass det tillhör och sedan returnerar en float			
					//detta item kan i sin tur vara vilken sorts item som helst så länge det är en subklass av item
					//om man tex vill lägga till lastbilar som ett sorts item /värdesak så kan man skapa en subklass till item och lägga till detta i item metoden getTypeValue(); 
				
			}//end for
			
			
			return totalValue;
			
			
		//}//end if name == n
		
		//else
			//return 0; //om namnet inte är detsamma
		
		
	}//end calctotalvalue
	
	public void listItems(Person p, List<Item> i){
		//går igenom en lista med items
		//hittar alla items som har samma ownername som person p's namn
		//printar dessa
		//denna låter person fortfarande vara generell nog, eftersom den kan ta emot en lista med vilka items som helst så länge de har item som superklass
		
		for (Item item: i){
			if (p.getName().equals(item.getOwner()))
				System.out.println(item);
			
			
		}//end for item in i
		
		
	}//end listItems
	
	
}//end person class
