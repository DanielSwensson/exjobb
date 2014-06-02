/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vardesaksregister;

import java.util.ArrayList;

/**
 *
 * @author Krille
 */
public class Person implements Comparable{
private String namn;
private long totalVarde;
private ArrayList<Pryl> prylar = new ArrayList<>();

    public Person(String namn) {
       this.namn=namn;
       totalVarde=0;
    }
    
    public void addPryl(Pryl pr){
        prylar.add(pr);
        System.out.println("Pryl tillagd till "+getNamn()+ "s ägodelar");
     //   System.out.println("Pryl: " + pr.toString());
    }
    public void setNamn(String namn){
        this.namn = namn;
    }
    public ArrayList<Pryl> getPrylar(){
        return prylar;
    }
    public String getNamn(){
        return namn;
    }
    
    public long getTotalvarde(){
        totalVarde = 0;
        for(Pryl pr: prylar){
            totalVarde += pr.getVarde();
        }
        return totalVarde;
    }
    public String toString(){
        
        return namn +"\t" + getTotalvarde();
    }
 
    public String toStringPrylsamling(){
        StringBuilder sb = new StringBuilder();
        sb.append(namn +"s ägodelar: \n");
        for(Pryl p: prylar){
            sb.append(p);
            sb.append("\n");
        }
        return sb.toString();
    }



    @Override
    public int compareTo(Object o) {
         if (!(o instanceof Person)){
             throw new ClassCastException("Ej personobjekt");
         }
         
        return (int) (this.getTotalvarde()-((Person)o).getTotalvarde());
    }
}