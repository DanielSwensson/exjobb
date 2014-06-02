import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


abstract class Varden {
	
	private float value;
	protected String name;
	 // värdet är av typen float alltsÃ¥ lagrad i 32 bits (7siffrigt)
	public float value() {
		return this.value;
	}
	public void setValue(float value) {
		this.value = value;
	}
 
	abstract public float getValue();
	//abstract public void create();
	
	public String getName(){
		return name;
	}
}

class Smycke extends Varden {  // klassen Smycke Ã¤rver frÃ¥n Varden 

	private int gemstones;
	private boolean gold;	// 1 if gold, 0 if silver
	
	public int gemstones() {
		return this.gemstones;
	}
 
	public boolean gold() {  // Guld - boolean dÃ¥ man antingen har guld eller inte 
		return this.gold;
	}
	public float getValue() {
		int value = gold ? 2000 : 700;  // vÃ¤rdet av guld Ã¤r 2000 och silver 700
 
		return value += gemstones*500;  // FÃ¶r varje Ã¤delsten Ã¶kar vÃ¤rdet med 500
	}
 
	Smycke(String name, int gemstones, boolean gold) {
		this.name = name;
		this.gemstones = gemstones;
		this.gold = gold;
	}
	 
	Smycke() {
	}
}
 
class Aktie extends Varden {
	private int amount;
 
	public int amount() {
		return this.amount;
	}
	public void setValue(int value) {
		super.setValue(value); // Super refererar till huvud klassen (the Parent Class)
	}
 
	public float getValue() {
		return super.value()*amount;
	}
 
	Aktie(String name, int amount, int price) {  // 
		this.name = name;
		this.amount = amount;
		super.setValue(price);
	}
 
	Aktie() {
	}
}
 
class Sak extends Varden {
	private int wear;
 
	public int wear() {
		return this.wear;
	}
 
	public float getValue() {
 		if(wear == 0)
			return super.value();
 
		return super.value()*((float)wear/10);
	}
 
	Sak(String name, int original_price, int wear) {
		this.name = name;
		super.setValue(original_price);
		this.wear = wear;
	}
 
	Sak() {
	}
}
 



