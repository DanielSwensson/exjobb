package HABLO2;

import java.util.Random;

public abstract class Unit {
	
	private int dmg;
	private int def;
	private int currentHp;
	private int agil;
	private String type;
	private int gold;
	private int lvl;
	private int maxHp;
	
	public Unit(int dmg, int def, int currentHp, int agil, String type, int gold, int lvl, int maxHp){
		
		this.dmg=dmg;
		this.def=def;
		this.currentHp=currentHp;
		this.agil=agil;
		this.type=type;
		this.gold=gold;
		this.lvl=lvl;
		this.maxHp=maxHp;
		
	}
	
	
	public int attack(Unit target){
		Random rnd = new Random();
		int rndNr = rnd.nextInt(this.dmg);
		rndNr -= this.dmg/2;
		int trueDmg = this.dmg - target.def + rndNr;
		
		
		if(trueDmg < 1) trueDmg = 1;
		
		target.changeCurrentHp(-trueDmg);//Göra skada
		
		int targetHp = target.getCurrentHp();
		
		if(targetHp<1) targetHp = 0;
		
		if(target.getType().equals("Human")){
			System.out.println("The " + this.getType() + " attacks you!\n You now got " + targetHp + " hp left.");
		}else{
			System.out.println("You attack the "+target.getType()+" \n It now has " + targetHp + " hp left.");
		}

		return trueDmg;
	}
	
	public void setMaxHp(int newMaxHp){
		this.maxHp = newMaxHp;
	}
	
	public int getMaxHp(){
		return this.maxHp;
	}
	
	public void changeCurrentHp(int nr){
		this.setCurrentHp(this.getCurrentHp() + nr);
		
		if(this.getCurrentHp()>this.maxHp){
			this.setCurrentHp(this.maxHp);
		}
	}
	
	public boolean firstBlood(Unit target){
		boolean fb = false;

		if(this.agil+1>target.agil)	fb = true;
		
		return fb;
	}
	
	public void setType(String newType){
		this.type = newType;
	}
	
	public int getDmg(){
		return dmg;
	}
	
	public int getDef(){
		return def;
	}
	
	public int getCurrentHp(){
		return currentHp;
	}
	
	public String getType(){
		return type;
	}
	
	public int getAgil(){
		return agil;
	}
	
	public int getLvl(){
		return lvl;
	}
	
	public int getGold(){
		return gold;
	}
	
	public void setDmg(int dmg){
		this.dmg = dmg;
	}
	
	public void setDef(int def){
		this.def = def;
	}
	
	public void setCurrentHp(int hp){
		this.currentHp = hp;
	}
	
	public void setAgil(int agil){
		this.agil = agil;
	}
	
	public void setGold(int gold){
		this.gold = gold;
	}
	
	public void setLvl(int lvl){
		this.lvl = lvl;
	}
	
}
