
public class Aktiepost extends Prylar {
	
	private int antalAktier;
	private int prisAktiepost;
	
	
public Aktiepost(String n, int aa, int pa){
		super(n);	
		antalAktier=aa;
		prisAktiepost=pa; 
			
			
		}
public int getV�rde(){
	return (antalAktier*prisAktiepost);

}
public String getPrylNamn(){
	return namn;
}

public void setKrasch(){
	prisAktiepost=0;
	
}

}
