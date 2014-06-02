
public class Apparat extends Prylar{
	public Apparat (String namn,int inköpsPris,int slitage){
		super(namn);
		this.inköpsPris=inköpsPris;
		this.slitage=slitage;
	}
private int inköpsPris;
private int slitage;

public int värde(){
	return (inköpsPris * (slitage * 10))/100;
}

}
