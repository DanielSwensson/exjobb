
public class Stock extends Item {

private int stockPrice;
private int stockQuantity;



public Stock(int price, int quantity, String name){
super(name);
stockPrice = price;
stockQuantity = quantity;
}


public int getValue(){
return stockQuantity * stockPrice;




}

public void borsKrasch(){
	stockPrice = 0;
			
}



}