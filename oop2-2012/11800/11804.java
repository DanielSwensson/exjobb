
abstract class Prylar {

private String namn; 

public Prylar(String namn){
	this.namn=namn;
	
}

abstract public int värde();

public String getNamn () {
	 return namn;
	 }
public String toString(){
	return namn+ " " +värde();
}
}
	 



 


