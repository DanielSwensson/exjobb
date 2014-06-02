

import java.util.ArrayList;
public class Client {
private String firma;
private String legalForm;
public ArrayList<BlockofAssets> Assets = new ArrayList<BlockofAssets>();
double totalWealth= this.getTotalWealth();

public Client (String firmaName, String legalFormIn ){
firma = firmaName;
legalForm =legalFormIn;

}


public double getTotalWealth(){

double totalWealth = 0;

for (BlockofAssets PartOfWealth: Assets){
totalWealth = totalWealth + PartOfWealth.calculateValue();
}
return totalWealth;
}

public String getName(){
return firma;
}

public String toString (){
String printClient = "\n Kundens namn: "+firma+"\n Juridisk form: "+ this.legalForm+"\n Tillgångar: \n"+Assets +"\n Total förmögenhet: "+ this.getTotalWealth();
return printClient;
}


}

 

 

