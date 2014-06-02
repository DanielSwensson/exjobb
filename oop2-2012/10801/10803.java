
abstract public class Pryl {
	
  private String namn;
  
  public String getNamn(){
	  return this.namn;
  }
  public Pryl(String namn){
	  this.namn = namn;
  }
  abstract public String getTyp();	
  abstract public int kalkyleraVärde();

  
  
  
}
