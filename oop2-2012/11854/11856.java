import java.util.Random;
public abstract class BlockofAssets {

private static Random rand = new Random();
private String name;
private int numberOfType;
private static double marketInterestRate =0.005;

public abstract double calculateValue();

public abstract String toString();

public BlockofAssets(String na, int n){
name =na;
numberOfType=n;
}
public static double getMarketInterestRate(){
return marketInterestRate;
}
public static void setMarketInterestRate(){
marketInterestRate = (rand.nextDouble()* marketInterestRate);
}

public String getName(){
return name;
}
public int getNumberOfType (){
return numberOfType;
}

}

 
