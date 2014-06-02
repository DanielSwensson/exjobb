
package game;

/**
 *
 * @author Maria Hansson och  Gustav Larsson
 */
abstract class Item {

    private String name;
    private int stat;
    //private int point;

    Item(String name, int stat/*, int point*/) {
        this.name = name;
        this.stat = stat;
        
    }
    abstract public double getPoint();
        
    
    public String getName() {
        return name;
    }

    public int getStat() {
        return stat;
    }
    
    public String toString() {
        return name;
    }
}

class Candy extends Item {
    private int taste;
   
    public Candy(String name, int stat, int taste) {
        super(name, stat);
        this.taste = taste; 
    }
   public double getPoint(){
    return taste+2;
}    
  
    
}

class Salt extends Item {
    int grainsOfSalt;
    

    public Salt(String name, int stat, int grainsOfSalt) {
        super(name, stat);
        this.grainsOfSalt = grainsOfSalt;
    }
  public double getPoint(){
    return grainsOfSalt-2;  
}

}
class Weapon extends Item {
    private final double STARTDURABILITY;
    private int durability;
    private int value;

    public Weapon(String name, int stat, double STARTDURABILITY, int durability, int value) {
        super(name, stat);
        this.STARTDURABILITY = STARTDURABILITY;
        this.durability = durability;
        this.value = value;  

        
    }
    
    
    public int getDurability() {
        return durability ;
    }

    public void setDurability() {
        durability = durability-1;
    }
    public double getPoint(){
      double weaponPoints = value*((durability/STARTDURABILITY));
    return Math.floor(weaponPoints);
    }
    
}
class Fist extends Item {
    
    public Fist(String name, int stat) {
        super(name, stat);
        
    }

    public double getPoint(){
    return 0; 
    }
 
}


