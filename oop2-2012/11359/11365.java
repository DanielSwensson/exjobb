
public class Pryl {
	protected String namn;
    protected int v�rde;
	
    public Pryl(String namn){
        this.namn=namn;
}

	public int getV�rde(){
        return v�rde;
    }
	
	public String getNamn(){
        return namn;
    }

	public String toString(){
        return namn+"\t"+v�rde+"\n";
    }
}
