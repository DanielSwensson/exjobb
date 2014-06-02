
public class Pryl {
	protected String namn;
    protected int värde;
	
    public Pryl(String namn){
        this.namn=namn;
}

	public int getVärde(){
        return värde;
    }
	
	public String getNamn(){
        return namn;
    }

	public String toString(){
        return namn+"\t"+värde+"\n";
    }
}
