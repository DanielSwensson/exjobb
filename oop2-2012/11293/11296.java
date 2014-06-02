
import java.util.*;

public class Recipe {

	private String name;
	private int numberOfPeople;
	ArrayList<Ingredient> rec = new ArrayList<Ingredient>();
	
	
	public void setNumberOfPeople(int p){
		numberOfPeople = p;
	}
	
	public void setName(String s){
		name = s.trim();
	}
	
	public String getName(){
		return name;
	}
	
	public int getPeople(){
		return numberOfPeople;
	}
	
	public Recipe convertIngredients(int p){
		Recipe r = new Recipe(getName(), p);
		
		for (Ingredient o : rec){
			double am = (o.getAmount()*p/getPeople());
			r.addIngredient(new Ingredient(o.getName(), roundTwoDecimals(am), o.getUnit()));
		}
		return r;
	}
	
	public double roundTwoDecimals(double d){
		double k = Math.round(d*100);
		k /= 100;
		return k;
	}
	
	public void printRecipe(){
		Registry.starLine();
		System.out.println("RECEPT PÅ " + getName().toUpperCase());
		System.out.println("För " + getPeople() + " person(er)\n");
		System.out.println("Ingredienser\n");
		for(Object k : rec){
			((Ingredient)k).printIngredient();
		}
		System.out.println();
	}
	
	public void addIngredient(Ingredient i){
		rec.add(i);
	}
		
	public Recipe(String str, int no){
		setName(str);
		setNumberOfPeople(no);
	}
}
