package value.register;
//Jakob Elldin M�rtensson
//DSV, Stockholm University
//Inlupp 2 f�r OOP
import java.util.*;

public class Person {
	
	private String name;
	private float totalValue; //det �r lite risky bzns att ha value som en variabel och inte endast en metod, men s� l�nge man kommer ih�g att nollst�lla v�rdet varje g�ng man ska s�ka igenom listan g�r det snabbare att m�ta t.ex. vem som har st�rst v�rde
	
	
	//skulle kunnat ha en lista med items som fylls f�r varje item som l�ggs till	
	
	
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
		//j�mf�r namnet (som ska vara det samma som person name)
		//g�r igenom en lista med items och hittar de som har owner == name
		//adderas deras value till totalvalue
		//returnerar totvalue
		
		//if (name.equals(n)){ //kan t�nkas att denna ifsats inte kommer beh�vas
			totalValue = 0;
			
			for (Item it: i){
				if (it.getOwner().equals(name))
					addTotalValue(it.getValue()); 
					//skickar item till en metod i item som unders�ker vilken subklass det tillh�r och sedan returnerar en float			
					//detta item kan i sin tur vara vilken sorts item som helst s� l�nge det �r en subklass av item
					//om man tex vill l�gga till lastbilar som ett sorts item /v�rdesak s� kan man skapa en subklass till item och l�gga till detta i item metoden getTypeValue(); 
				
			}//end for
			
			
			return totalValue;
			
			
		//}//end if name == n
		
		//else
			//return 0; //om namnet inte �r detsamma
		
		
	}//end calctotalvalue
	
	public void listItems(Person p, List<Item> i){
		//g�r igenom en lista med items
		//hittar alla items som har samma ownername som person p's namn
		//printar dessa
		//denna l�ter person fortfarande vara generell nog, eftersom den kan ta emot en lista med vilka items som helst s� l�nge de har item som superklass
		
		for (Item item: i){
			if (p.getName().equals(item.getOwner()))
				System.out.println(item);
			
			
		}//end for item in i
		
		
	}//end listItems
	
	
}//end person class
