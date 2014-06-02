
abstract class Pryl {
 private String sort;
 int värde;
 
public Pryl(String sort) {
 this.sort = sort;
 
}
 
public String getSort() {
 return sort;
 }
 
public abstract int getVärde();
 
public String toString() {
 return sort + " " + getVärde();
 }
}
	
	
	
	
