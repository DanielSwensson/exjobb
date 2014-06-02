
public class Apparat extends Pryl{
	private int slitage;
	
	public Apparat(String apparatNamn, int vŠrde, int slitage) { //konstruktor
		namn = apparatNamn;
		this.vŠrde = vŠrde;
		this.slitage = slitage;
	}

	public double getVŠrde(){ //metod fšr att returnera vŠrdet pŒ apparaten. Baseras pŒ slitagevŠrdet
		if(slitage==10){
			return vŠrde;
		}else if(slitage==9){
			return vŠrde*0.9;
		}else if(slitage==8){
			return vŠrde*0.8;
		}else if(slitage==7){
			return vŠrde*0.7;
		}else if(slitage==6){
			return vŠrde*0.6;
		}else if(slitage==5){
			return vŠrde*0.5;
		}else if(slitage==4){
			return vŠrde*0.4;
		}else if(slitage==3){
			return vŠrde*0.3;
		}else if(slitage==2){
			return vŠrde*0.2;
		}else if(slitage==1){
			return vŠrde*0.1;
		}else{
			return 0;
		}
	}

	public String getPrylSort() { //metod fšr att returnera vilken sorts pryl detta Šr eftersom alla prylar Šr i samma array
		return "apparat";
	}
}
