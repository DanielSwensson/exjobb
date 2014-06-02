package Inlupp2;

import java.util.ArrayList; 

public class Person {
	ArrayList <Item> appliancesreg = new ArrayList <Item> (); 
		
	private String name; 
		
		public Person (String name) {
			
			this.name = name; 
	     
		}
		
		public String getName(){
			return name;
			
		}
		
		public void setStock() {
			
			
		}
		
		public void addItem(Item item) {
			appliancesreg.add(item);
		}
		
		public int totalItemValue() { 
			 
			int totalValue = 0;
			for(Item i : appliancesreg) {
				totalValue += i.getItemValue();
			}
			
			return totalValue; 
		}
		
		public String listItemValue() {
			
			String totalValue = ("");
			for(Item i : appliancesreg) {
				totalValue += i.toString() + "\n" ;
			}
			
			return totalValue; 
			
		}
		
		public ArrayList<Item> getItemList() {
			return appliancesreg; 
			
		}

	}