
public class Apparat extends Pryl{
	private int slitage;
	
	public Apparat(String apparatNamn, int v�rde, int slitage) { //konstruktor
		namn = apparatNamn;
		this.v�rde = v�rde;
		this.slitage = slitage;
	}

	public double getV�rde(){ //metod f�r att returnera v�rdet p� apparaten. Baseras p� slitagev�rdet
		if(slitage==10){
			return v�rde;
		}else if(slitage==9){
			return v�rde*0.9;
		}else if(slitage==8){
			return v�rde*0.8;
		}else if(slitage==7){
			return v�rde*0.7;
		}else if(slitage==6){
			return v�rde*0.6;
		}else if(slitage==5){
			return v�rde*0.5;
		}else if(slitage==4){
			return v�rde*0.4;
		}else if(slitage==3){
			return v�rde*0.3;
		}else if(slitage==2){
			return v�rde*0.2;
		}else if(slitage==1){
			return v�rde*0.1;
		}else{
			return 0;
		}
	}

	public String getPrylSort() { //metod f�r att returnera vilken sorts pryl detta �r eftersom alla prylar �r i samma array
		return "apparat";
	}
}
