
abstract class Pryl {
 private String sort;
 int v�rde;
 
public Pryl(String sort) {
 this.sort = sort;
 
}
 
public String getSort() {
 return sort;
 }
 
public abstract int getV�rde();
 
public String toString() {
 return sort + " " + getV�rde();
 }
}
	
	
	
	
