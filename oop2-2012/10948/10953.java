/*Author: Fredrik Birath Hasselgren
 * 
 *Den här klassen representerar en aktie. Klassen är en subklass till Thing
 *Varje aktie har ett antal, ett pris samt en boolean för om den påverkats av en aktiecrash
 *metoden crash() sätter attributet crashed till true. Metoden kallas då en börskrasch äger rum.
 *Är crash == true returneras värdet 0 då getValue() anropas, annars är värdet price * numberOfPosts
 */
package valuegister;

public class Stock extends Thing {
    
    int numberOfPosts;//antal aktier
    double price;//pris för varje aktie
    boolean crashed = false;//Aktien har ännu inte påverkats av en börscrash
    
    public Stock(String name, int numberOfPosts, double price ){
        super(name);//Kall till superklassen "Things" konstruktor
        this.numberOfPosts = numberOfPosts;
        this.price = price;
    }
 
    public void crash(){//en börskrasch äger rum och den här aktien kraschas
        crashed = true;
    }
  
    @Override
    public double getValue(){
        if(!crashed){//Aktien har inte påverkats av en börskrasch
        return numberOfPosts * price;        
    }
        else{//Aktien påverkades i en börskrasch
            return 0;
        }
    }
    
    @Override
    public String toString(){
        return numberOfPosts +" " + getName() + " köpta för " + price + " st. Värda " + getValue();
    }
}
