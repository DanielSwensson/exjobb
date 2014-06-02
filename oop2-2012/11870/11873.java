package prylregister;

import java.util.*;
public class Person {
    private String name;
    private ArrayList<Pryl>prylar =new ArrayList<>();
    
    Person (String fullname){
        name =fullname;
    }
    public String getName(){
        return name;
    }
    public void addPryl (Pryl p){
        prylar.add(p);
    }
    public String listPryl(){
        String list="";
        for (Pryl p :prylar){
            list+=" "+p;
        }
        return list;
    }
    public int getTotalValue(){
        int value=0;
        for (Pryl p :prylar){
            value+= p.getValue();
        }
        return value;
    }
    public void setAktieValue (double x){
        for (Pryl p :prylar){
            if (p instanceof Aktie) {
                ((Aktie)p).setValue(x);
            }
        }
    }
    @Override
    public String toString(){
        return name + prylar;
    }
}