import java.util.ArrayList;

public class Person	{
    private String namn;
    private ArrayList<Pryl> allaprylar=new ArrayList<Pryl>();
    
    public Person (String namn)	{
        this.namn=namn;
    }
	
    public int getRikast()	{
        int v�rde=0;
			for(Pryl p : allaprylar)	{
				v�rde+=p.getV�rde();
				
				}
        return v�rde;
    } 
	
    public String getNamn()	{
        return namn;
    }
    
    public String toString(){
        return namn+"\t"+getRikast()+"\n";
    }
    
    public String visaPrylar(){
        String prylarna="";
        for(Pryl p : allaprylar)
            prylarna+=p.toString();
        return prylarna;
    }
    
    public void addPryl(Pryl p){
        allaprylar.add(p);
    }
    
    public ArrayList<Pryl> getPrylar(){
        return allaprylar;
    }    
}