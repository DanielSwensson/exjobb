
//	OOP Inlämningsuppgift 2
//	Prylregister
//	Jonas Ask , 760818-0035

import java.io.*;
import java.util.*;

public class Person implements Serializable{
	private String name;
	private ArrayList<Valueable> collection = new ArrayList<Valueable>();
	
	public Person(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addThing(Valueable p){
		collection.add(p);
	}
	
	public void deleteThing(int i){
		collection.remove(i);
	}
	
	public int getSum(){
		int sum = 0;
		for(Valueable p :collection)
			sum = sum + p.getValue();
		return sum;
	}
	
	public void stockCrash(){
		for(Valueable p : collection)
			if(p instanceof Stock)
				((Stock)p).setPrice(0);		
	}
	
	public void listStuff(){
		for(Valueable p : collection)
			System.out.println(" " +(1+collection.indexOf(p)) +" = " +  p.getName() +"\t" + p.getTypeOfThing() + "\t\tvärde = "+ p.getValue());
		System.out.println(" -------------------------------\t\t-----------------"
							+ "\n\t\t\tSumma : "+ this.getSum()
							+ "\n --------------------------------------------------------------------");
	}
	
	public void listStuffAll(){
		System.out.println("\n Aktie\tAntal\tInköpskurs\tVärde");
		for(Valueable p : collection)
			if(p instanceof Stock)
				System.out.println(p.toString());
		System.out.println("\n Apparat\tNypris\tSlitage\tvärde");
		for(Valueable p : collection)
			if (p instanceof Gadget)
				System.out.println(p.toString());
		System.out.println("\n Smycke\tMaterial\tÄdelstenar\tvärde");
		for(Valueable p : collection)
			if (p instanceof Jewellery)
				System.out.println(p.toString());
			System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
					+ "\n\t\t         Summa : "+ this.getSum()
					+ "\n -----------------------------------------------------------");
		
	}
	
	public String toString(){
		return collection.toString();
	}
}
