public class Jewelry extends Property{
  
  private boolean gold;
  private int gems;
  
  public Jewelry(String name, boolean gold, int gems){
    super(name);
    this.gold = gold;
    this.gems = gems;   
  }
  
  //Returnerar v�rdet p� smycket
  public int getValue(){
    if(gold){
    return 2000 + (500*gems);
    }
    return 700 + (500*gems);
  }
  
  public String toString(){
    return name + " till ett v�rde av " + getValue() + " \n";
  } 
  
}